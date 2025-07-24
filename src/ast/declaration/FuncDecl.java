package ast.declaration;

import ast.declaration.declarator.DeclSpec;
import ast.declaration.declarator.Declarator;
import ast.declaration.parameter.ParamList;
import ast.statement.BlockStmt;
import ast.statement.Stmt;
import console.Format;
import interpreter.environment.Symbol;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.ArrowType;
import interpreter.type.Type;
import interpreter.type.VoidType;
import interpreter.value.FuncValue;
import interpreter.value.UnitValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class FuncDecl extends Decl {
    private final @NotNull DeclSpec declSpec;
    private final @NotNull Declarator declarator;
    private final @NotNull ParamList paramList;
    private final @NotNull Stmt functionBody;

    public FuncDecl(@NotNull DeclSpec declSpec,
                    @NotNull Declarator declarator,
                    @NotNull ParamList paramList,
                    @NotNull BlockStmt functionBody) {
        this.declSpec = declSpec;
        this.declarator = declarator;
        this.paramList = paramList;
        this.functionBody = functionBody.getStmt();
    }

    @Override
    public @NotNull UnitValue eval(@NotNull ValEnv env) throws RuntimeError {
        ValEnv bodyEnv = ValEnv.fromOuter(env);
        Symbol symFunc = declarator.getSymbol();
        final @NotNull Symbol @NotNull [] symDecls = paramList.evalAsParams(bodyEnv);
        env.put(symFunc, new FuncValue(symDecls, functionBody, bodyEnv));
        return UnitValue.UNIT;
    }

    @Override
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) throws TypeError {
        TypeEnv bodyEnv;
        if (declarator.getSymbol() == Symbol.symbol("main")) {
            bodyEnv = TypeEnv.fromOuterToMain(env);
        } else {
            bodyEnv = TypeEnv.fromOuterToFunction(env);
        }
        Symbol symFunc = declarator.getSymbol();
        int cnt = paramList.cntOfDeclWithoutDefault();
        final @NotNull Type @NotNull [] paramTypes = paramList.typeCheckAsParams(bodyEnv);
        Type declType = declSpec.typeCheck(env);
        VoidType returnType = functionBody.typeCheck(bodyEnv);
        env.putAndCheck(symFunc, new ArrowType(paramTypes, VoidType.mergeReturnType(returnType, declType), cnt));
        return VoidType.VOID;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(declSpec) +
                "\n" + Format.addIndent(declarator) +
                "\n" + Format.addIndent(paramList) +
                "\n" + Format.addIndent(functionBody) +
                "\n%s</%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE);
    }
}
