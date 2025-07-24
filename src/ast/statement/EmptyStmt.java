package ast.statement;

import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.type.VoidType;
import interpreter.value.UnitValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class EmptyStmt extends Stmt {

    private static final @NotNull EmptyStmt EMPTY_STMT = new EmptyStmt();

    private EmptyStmt() {
    }

    @Contract(pure = true)
    public static @NotNull EmptyStmt getInstance() {
        return EMPTY_STMT;
    }

    @Override
    public @NotNull UnitValue eval(@NotNull ValEnv env) {
        return UnitValue.UNIT;
    }

    @Override
    @Contract(pure = true)
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) {
        return VoidType.VOID;
    }

    @Override
    public String toString() {
        return "%s<EmptyStmt/>%s".formatted(Format.YELLOW, Format.NONE);
    }
}
