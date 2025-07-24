package ast.declaration;

import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.type.VoidType;
import interpreter.value.UnitValue;
import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Program extends Decl {
    private final @NotNull Decl @NotNull[] declList;

    private static final @NotNull Program EMPTY_PROGRAM = new Program(0);

    public Program(int size) {
        declList = new Decl[size];
    }

    @Contract(pure = true)
    public static @NotNull Program valueOfEmpty() {
        return EMPTY_PROGRAM;
    }

    public void add(int index, @NotNull @Flow(targetIsContainer = true, target = "this.declList") Decl decl) {
        declList[index] = decl;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull UnitValue eval(@NotNull ValEnv env) throws RuntimeError {
        for (@NotNull Decl decl : declList) {
            decl.eval(env);
        }
        return UnitValue.UNIT;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) throws TypeError {
        for (@NotNull Decl decl : declList) {
            Type t = decl.typeCheck(env);
            if (t != VoidType.VOID) {
                throw TypeError.CONTINUE_BREAK_RETURN_ERROR;
            }
        }
        return VoidType.VOID;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        StringBuilder sb = new StringBuilder("%s<%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE));
        for (@NotNull Decl decl : declList) {
            sb.append("\n").append(Format.addIndent(decl));
        }
        sb.append("\n%s</%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE));
        return sb.toString();
    }
}
