package ast.expression;

import console.Format;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract class BinaryExpr extends Expr {
    protected final @NotNull Expr le;
    protected final @NotNull Expr re;

    protected BinaryExpr(@NotNull Expr le, @NotNull Expr re) {
        this.le = le;
        this.re = re;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(le) +
                "\n" + Format.addIndent(re) +
                "\n%s</%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE);
    }
}
