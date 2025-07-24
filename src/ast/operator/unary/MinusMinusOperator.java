package ast.operator.unary;

import ast.expression.Expr;
import ast.expression.arithmetic.MinusMinusExpr;
import org.jetbrains.annotations.NotNull;

public final class MinusMinusOperator extends UnaryOperator {

    public static final @NotNull MinusMinusOperator MINUS_MINUS_OPERATOR = new MinusMinusOperator();

    private MinusMinusOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr e) {
        return new MinusMinusExpr(e);
    }

}
