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

public final class BreakStmt extends Stmt {
    private static final @NotNull BreakStmt BREAK_STMT = new BreakStmt();

    private BreakStmt() {
    }

    @Contract(pure = true)
    public static @NotNull BreakStmt getInstance() {
        return BREAK_STMT;
    }

    @Override
    @Contract(pure = true)
    public @NotNull UnitValue eval(@NotNull ValEnv env) {
        return UnitValue.BREAK;
    }

    @Override
    @Contract(pure = true)
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) throws TypeError {
        if (env.isInsideLoop() || env.isInsideSwitch()) {
            return VoidType.VOID;
        }
        throw TypeError.CONTINUE_BREAK_RETURN_ERROR;
    }

    @Override
    public String toString() {
        return "%s<BreakStmt/>%s".formatted(Format.YELLOW, Format.NONE);
    }

    @Override
    @Contract(pure = true)
    public @NotNull UnitValue evalSwitch(@NotNull ValEnv env, @NotNull Value valLabel) {
        return UnitValue.BREAK;
    }
}
