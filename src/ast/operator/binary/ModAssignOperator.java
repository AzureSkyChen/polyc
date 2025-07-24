package ast.operator.binary;

import ast.expression.Expr;
import ast.expression.assignment.ModAssignExpr;
import org.jetbrains.annotations.NotNull;

public final class ModAssignOperator extends BinaryOperator {

    public static final @NotNull ModAssignOperator MOD_ASSIGN_OPERATOR = new ModAssignOperator();

    private ModAssignOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr le, @NotNull Expr re) {
        return new ModAssignExpr(le, re);
    }
}
