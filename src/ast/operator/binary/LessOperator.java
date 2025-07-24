package ast.operator.binary;

import ast.expression.Expr;
import ast.expression.comparison.LessExpr;
import org.jetbrains.annotations.NotNull;

public final class LessOperator extends BinaryOperator {

    public static final @NotNull LessOperator LESS_OPERATOR = new LessOperator();

    private LessOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr le, @NotNull Expr re) {
        return new LessExpr(le, re);
    }
}
