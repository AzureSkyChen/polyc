package ast.operator.unary;

import ast.expression.Expr;
import ast.expression.builtin.SizeExpr;
import org.jetbrains.annotations.NotNull;

public final class SizeOperator extends UnaryOperator {

    public static final @NotNull SizeOperator SIZE_OPERATOR = new SizeOperator();

    private SizeOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr e) {
        return new SizeExpr(e);
    }
}
