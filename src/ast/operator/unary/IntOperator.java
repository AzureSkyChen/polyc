package ast.operator.unary;

import ast.expression.Expr;
import ast.expression.builtin.IntExpr;
import org.jetbrains.annotations.NotNull;

public final class IntOperator extends UnaryOperator {

    public static final @NotNull IntOperator INT_OPERATOR = new IntOperator();

    private IntOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr e) {
        return new IntExpr(e);
    }
}
