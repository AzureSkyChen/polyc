package ast.operator.binary;

import ast.expression.Expr;
import ast.expression.assignment.BitXorAssignExpr;
import org.jetbrains.annotations.NotNull;

public final class XorAssignOperator extends BinaryOperator {

    public static final @NotNull XorAssignOperator XOR_ASSIGN_OPERATOR = new XorAssignOperator();

    private XorAssignOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr le, @NotNull Expr re) {
        return new BitXorAssignExpr(le, re);
    }

}
