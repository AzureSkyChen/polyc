package ast.operator.unary;

import ast.expression.arithmetic.BitNotExpr;
import ast.expression.Expr;
import org.jetbrains.annotations.NotNull;

public final class BitNotOperator extends UnaryOperator {

    public static final @NotNull BitNotOperator BIT_NOT_OPERATOR = new BitNotOperator();

    private BitNotOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr e) {
        return new BitNotExpr(e);
    }
}
