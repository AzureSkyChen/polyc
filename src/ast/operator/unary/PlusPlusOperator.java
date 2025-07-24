package ast.operator.unary;

import ast.expression.Expr;
import ast.expression.arithmetic.PlusPlusExpr;
import org.jetbrains.annotations.NotNull;

public final class PlusPlusOperator extends UnaryOperator {

    public static final @NotNull PlusPlusOperator PLUS_PLUS_OPERATOR = new PlusPlusOperator();

    private PlusPlusOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr e) {
        return new PlusPlusExpr(e);
    }

}
