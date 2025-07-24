package ast.operator.binary;

import ast.expression.equality.EqExpr;
import ast.expression.Expr;
import org.jetbrains.annotations.NotNull;

public final class EqOperator extends BinaryOperator {

    public static final @NotNull EqOperator EQ_OPERATOR = new EqOperator();

    private EqOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr le, @NotNull Expr re) {
        return new EqExpr(le, re);
    }

}
