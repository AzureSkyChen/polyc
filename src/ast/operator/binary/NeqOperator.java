package ast.operator.binary;

import ast.expression.Expr;
import ast.expression.equality.NeqExpr;
import org.jetbrains.annotations.NotNull;

public final class NeqOperator extends BinaryOperator {

    public static final @NotNull NeqOperator NEQ_OPERATOR = new NeqOperator();

    private NeqOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr le, @NotNull Expr re) {
        return new NeqExpr(le, re);
    }
}
