package ast.operator.binary;

import ast.expression.Expr;
import ast.expression.assignment.MinusAssignExpr;
import org.jetbrains.annotations.NotNull;

public final class MinusAssignOperator extends BinaryOperator {

    public static final @NotNull MinusAssignOperator MINUS_ASSIGN_OPERATOR = new MinusAssignOperator();

    private MinusAssignOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr le, @NotNull Expr re) {
        return new MinusAssignExpr(le, re);
    }

}
