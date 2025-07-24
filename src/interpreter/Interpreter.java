package interpreter;

import ast.Node;
import ast.declaration.Program;
import interpreter.environment.Symbol;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.SyntaxError;
import interpreter.value.FuncValue;
import interpreter.value.Value;
import interpreter.value.equality.IntegerValue;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import parser.PolyCLexer;
import parser.PolyCParserParser;

import java.io.IOException;

public final class Interpreter {
    private final boolean debug;

    private Interpreter(boolean debug) {
        this.debug = debug;
    }

    @Contract(pure = true)
    private @NotNull Program parse(@NotNull String filename) throws SyntaxError, IOException {
        CharStream inputStream = CharStreams.fromFileName(filename);
        PolyCLexer lexer = new PolyCLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PolyCParserParser parser = new PolyCParserParser(tokens);
        ParseTree parseTree = parser.parse();
        PolyCVisitor vis = new PolyCVisitor();
        Node ast = vis.visit(parseTree);
        if (!(ast instanceof Program)) {
            throw SyntaxError.SHOULD_NOT_HAPPEN;
        }
        return (Program) ast;
    }

    private void run(String @NotNull [] args) throws Exception {
        if (args.length == 0) {
            System.out.println("No file provided!");
            return;
        }
        String filename = args[0];
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Interpret: " + filename);

        Program ast = parse(filename);
        ValEnv globalValEnv = ValEnv.createGlobalEnv();
        TypeEnv globalTypeEnv = TypeEnv.createGlobalTypeEnv();

        ast.typeCheck(globalTypeEnv);
        if (debug) {
            System.out.println(globalTypeEnv);
        }

        ast.eval(globalValEnv);
        Symbol symMain = Symbol.symbol("main");
        if (!globalValEnv.containsKey(symMain)) {
            throw SyntaxError.NO_MAIN_FUNCTION;
        }
        Value mainFunc = globalValEnv.get(Symbol.symbol("main"));
        if (!(mainFunc instanceof FuncValue)) {
            throw SyntaxError.NO_MAIN_FUNCTION;
        }

        if (args.length != ((FuncValue) mainFunc).getParamCnt() + 1) {
            System.out.println("Please provide enough number of parameters");
            return;
        }

        Value[] values = new Value[args.length - 1];
        for (int i = 1; i < args.length; ++i) {
            values[i - 1] = IntegerValue.valueOf(String.valueOf(args[i]));
        }

        Value res = ((FuncValue) mainFunc).implOfApply(values);
        if (debug) {
            System.out.println(globalValEnv);
        }
        System.out.println("\nProcess finished with exit code " + ((IntegerValue) res).toInteger());
        System.out.println("-------------------------------------------------------------------");
    }

    @SuppressWarnings("unused")
    public static void interpret(String @NotNull [] args) throws Exception {
        Interpreter interpreter = new Interpreter(false);
        interpreter.run(args);
    }

    @SuppressWarnings("unused")
    public static void interpretAndDebug(String @NotNull [] args) throws Exception {
        Interpreter interpreter = new Interpreter(true);
        interpreter.run(args);
    }

    public static void main(String @NotNull [] args) throws Exception {
        interpret(args);
    }
}
