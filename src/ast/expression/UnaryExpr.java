package ast.expression;

import console.Format;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract class UnaryExpr extends Expr {
    protected final @NotNull Expr expr;

    protected UnaryExpr(@NotNull Expr expr) {
        this.expr = expr;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(expr) +
                "\n%s</%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE);
    }
}
