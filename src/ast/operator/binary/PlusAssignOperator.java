package ast.operator.binary;

import ast.expression.Expr;
import ast.expression.assignment.PlusAssignExpr;
import org.jetbrains.annotations.NotNull;

public final class PlusAssignOperator extends BinaryOperator {

    public static final @NotNull PlusAssignOperator PLUS_ASSIGN_OPERATOR = new PlusAssignOperator();

    private PlusAssignOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr le, @NotNull Expr re) {
        return new PlusAssignExpr(le, re);
    }
}
