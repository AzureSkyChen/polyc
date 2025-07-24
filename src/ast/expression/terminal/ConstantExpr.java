package ast.expression.terminal;

import ast.expression.Expr;
import console.Format;
import interpreter.error.TypeError;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.type.Iterable;
import interpreter.type.Type;
import interpreter.value.Constable;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class ConstantExpr extends Expr {

    private final @NotNull Value constant;

    public ConstantExpr(@NotNull Value v) {
        this.constant = v;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Value eval(@NotNull ValEnv env) {
        return constant;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        if (constant instanceof Constable) {
            Type t = ((Constable) constant).getType();
            if (t instanceof Iterable) {
                return t;
            }
            throw TypeError.SHOULD_NOT_HAPPEN;
        }
        throw TypeError.TYPE_NOT_CONSTABLE;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE) +
                constant +
                "%s</%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE);
    }
}
