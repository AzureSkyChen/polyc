package ast.operator.binary;

import ast.expression.Expr;
import ast.expression.comparison.GreatEqExpr;
import org.jetbrains.annotations.NotNull;

public final class GreaterEqOperator extends BinaryOperator {

    public static final @NotNull GreaterEqOperator GREATER_EQ_OPERATOR = new GreaterEqOperator();

    private GreaterEqOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr le, @NotNull Expr re) {
        return new GreatEqExpr(le, re);
    }
}
