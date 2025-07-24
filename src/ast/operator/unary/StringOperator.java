package ast.operator.unary;

import ast.expression.Expr;
import ast.expression.builtin.StringExpr;
import org.jetbrains.annotations.NotNull;

public final class StringOperator extends UnaryOperator {

    public static final @NotNull StringOperator STRING_OPERATOR = new StringOperator();

    private StringOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr e) {
        return new StringExpr(e);
    }
}
