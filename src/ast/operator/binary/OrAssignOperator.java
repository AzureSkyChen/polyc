package ast.operator.binary;

import ast.expression.Expr;
import ast.expression.assignment.BitOrAssignExpr;
import org.jetbrains.annotations.NotNull;

public final class OrAssignOperator extends BinaryOperator {

    public static final @NotNull OrAssignOperator OR_ASSIGN_OPERATOR = new OrAssignOperator();

    private OrAssignOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr le, @NotNull Expr re) {
        return new BitOrAssignExpr(le, re);
    }
}
