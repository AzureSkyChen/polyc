package ast.statement;

import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.type.VoidType;
import interpreter.value.UnitValue;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class BlockStmt extends Stmt {
    private final Stmt stmt;

    public BlockStmt(Stmt stmt) {
        this.stmt = stmt;
    }

    @Contract(pure = true)
    public @NotNull Stmt getStmt() {
        return stmt;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull UnitValue eval(@NotNull ValEnv env) throws RuntimeError {
        return stmt.eval(ValEnv.fromOuter(env));
    }

    @Override
    @Contract(pure = true)
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) throws TypeError {
        return stmt.typeCheck(TypeEnv.fromOuter(env));
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(stmt) +
                "\n%s</%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE);
    }

    @Override
    @Contract(mutates = "param1")
    public @NotNull UnitValue evalSwitch(@NotNull ValEnv env, @NotNull Value valLabel) throws RuntimeError {
        return stmt.evalSwitch(ValEnv.fromOuter(env), valLabel);
    }

    @Override
    @Contract(pure = true)
    public @NotNull VoidType checkSwitch(@NotNull TypeEnv env, @NotNull Type typeLabel) throws TypeError {
        return stmt.checkSwitch(TypeEnv.fromOuter(env), typeLabel);
    }
}
