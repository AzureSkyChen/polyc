package ast.operator.binary;

import ast.expression.assignment.AssignExpr;
import ast.expression.Expr;
import org.jetbrains.annotations.NotNull;

public final class AssignOperator extends BinaryOperator {

    public static final @NotNull AssignOperator ASSIGN_OPERATOR = new AssignOperator();

    private AssignOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr le, @NotNull Expr re) {
        return new AssignExpr(le, re);
    }
}
