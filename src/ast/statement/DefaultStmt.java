package ast.statement;

import console.Format;
import interpreter.error.RuntimeError;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.type.VoidType;
import interpreter.value.UnitValue;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class DefaultStmt extends Stmt {

    private final @NotNull Stmt stmt;

    public DefaultStmt(@NotNull Stmt stmt) {
        this.stmt = stmt;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull UnitValue eval(@NotNull ValEnv env) throws RuntimeError {
        return stmt.eval(env);
    }

    @Override
    @Contract(value = "_ -> fail")
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) throws TypeError {
        throw TypeError.DEFAULT_ERROR;
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
        return stmt.eval(env);
    }

    @Override
    @Contract(pure = true)
    public @NotNull VoidType checkSwitch(@NotNull TypeEnv env, @NotNull Type typeLabel) throws TypeError {
        return stmt.typeCheck(env);
    }
}
