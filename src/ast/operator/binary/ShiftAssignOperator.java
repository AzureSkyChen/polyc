package ast.operator.binary;

import ast.expression.Expr;
import ast.expression.assignment.ShiftAssignExpr;
import org.jetbrains.annotations.NotNull;

public final class ShiftAssignOperator extends BinaryOperator {

    public static final @NotNull ShiftAssignOperator SHIFT_ASSIGN_OPERATOR = new ShiftAssignOperator();

    private ShiftAssignOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr le, @NotNull Expr re) {
        return new ShiftAssignExpr(le, re);
    }

}
