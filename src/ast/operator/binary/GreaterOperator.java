package ast.operator.binary;

import ast.expression.Expr;
import ast.expression.comparison.GreatExpr;
import org.jetbrains.annotations.NotNull;

public final class GreaterOperator extends BinaryOperator {

    public static final @NotNull GreaterOperator GREATER_OPERATOR = new GreaterOperator();

    private GreaterOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr le, @NotNull Expr re) {
        return new GreatExpr(le, re);
    }

}
