package ast.statement;

import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.TypeError;
import interpreter.type.VoidType;
import interpreter.value.UnitValue;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class ContinueStmt extends Stmt {

    private static final @NotNull ContinueStmt CONTINUE_STMT = new ContinueStmt();

    private ContinueStmt() {
    }

    @Contract(pure = true)
    public static @NotNull ContinueStmt getInstance() {
        return CONTINUE_STMT;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull UnitValue eval(@NotNull ValEnv env) {
        return UnitValue.CONTINUE;
    }

    @Override
    @Contract(pure = true)
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) throws TypeError {
        if (env.isInsideLoop()) {
            return VoidType.VOID;
        }
        throw TypeError.CONTINUE_BREAK_RETURN_ERROR;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<ContinueStmt/>%s".formatted(Format.YELLOW, Format.NONE);
    }

    @Override
    @Contract(pure = true)
    public @NotNull UnitValue evalSwitch(@NotNull ValEnv env, @NotNull Value valLabel) {
        return UnitValue.CONTINUE;
    }
}
