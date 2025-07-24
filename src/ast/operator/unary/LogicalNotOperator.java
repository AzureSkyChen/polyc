package ast.operator.unary;

import ast.expression.Expr;
import ast.expression.logical.LogicalNotExpr;
import org.jetbrains.annotations.NotNull;

public final class LogicalNotOperator extends UnaryOperator {

    public static final @NotNull LogicalNotOperator LOGICAL_NOT_OPERATOR = new LogicalNotOperator();

    private LogicalNotOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr e) {
        return new LogicalNotExpr(e);
    }

}
