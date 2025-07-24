package ast.expression.terminal;

import ast.expression.Expr;
import console.Format;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.type.RefType;
import interpreter.type.Type;
import interpreter.value.RefValue;
import interpreter.value.Value;
import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import interpreter.environment.Symbol;

public final class IdExpr extends Expr {

    private final @NotNull Symbol symbol;

    public IdExpr(@NotNull Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    @Contract(value = "_ -> new", pure = true)
    public @NotNull Value eval(@Flow(sourceIsContainer = true) @NotNull ValEnv env) throws RuntimeError {
        return RefValue.valueOf(symbol, env.get(symbol));
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@Flow(sourceIsContainer = true) @NotNull TypeEnv env) throws TypeError {
        return RefType.valueOf(env.get(symbol));
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE) +
                symbol +
                "%s</%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE);
    }
}
