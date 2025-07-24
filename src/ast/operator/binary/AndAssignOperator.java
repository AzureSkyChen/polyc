package ast.operator.binary;

import ast.expression.Expr;
import ast.expression.assignment.BitAndAssignExpr;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class AndAssignOperator extends BinaryOperator {

    public static final @NotNull AndAssignOperator AND_ASSIGN_OPERATOR = new AndAssignOperator();

    private AndAssignOperator(){
    }


    @Override
    @Contract("_, _ -> new")
    public @NotNull Expr applyTo(@NotNull Expr le, @NotNull Expr re) {
        return new BitAndAssignExpr(le, re);
    }
}
