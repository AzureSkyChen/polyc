package ast.operator.binary;

import ast.expression.assignment.DivAssignExpr;
import ast.expression.Expr;
import org.jetbrains.annotations.NotNull;

public final class DivAssignOperator extends BinaryOperator {

    public static final @NotNull DivAssignOperator DIV_ASSIGN_OPERATOR = new DivAssignOperator();

    private DivAssignOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr le, @NotNull Expr re) {
        return new DivAssignExpr(le, re);
    }
}
