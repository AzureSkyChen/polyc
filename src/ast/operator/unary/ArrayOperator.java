package ast.operator.unary;

import ast.expression.Expr;
import ast.expression.builtin.ArrayExpr;
import org.jetbrains.annotations.NotNull;

public final class ArrayOperator extends UnaryOperator {

    public static final @NotNull ArrayOperator ARRAY_OPERATOR = new ArrayOperator();

    private ArrayOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr e) {
        return new ArrayExpr(e);
    }
}
