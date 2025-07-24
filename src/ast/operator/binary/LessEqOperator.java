package ast.operator.binary;

import ast.expression.Expr;
import ast.expression.comparison.LessEqExpr;
import org.jetbrains.annotations.NotNull;

public final class LessEqOperator extends BinaryOperator {

    public static final @NotNull LessEqOperator LESS_EQ_OPERATOR = new LessEqOperator();

    private LessEqOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr le, @NotNull Expr re) {
        return new LessEqExpr(le, re);
    }

}
