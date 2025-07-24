package ast.operator.unary;

import ast.expression.Expr;
import ast.expression.arithmetic.MinusExpr;
import org.jetbrains.annotations.NotNull;

public final class MinusOperator extends UnaryOperator {

    public static final @NotNull MinusOperator MINUS_OPERATOR = new MinusOperator();

    private MinusOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr e) {
        return new MinusExpr(e);
    }

}
