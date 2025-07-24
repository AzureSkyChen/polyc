package ast.operator.unary;

import ast.expression.Expr;
import org.jetbrains.annotations.NotNull;

public final class PlusOperator extends UnaryOperator {

    public static final @NotNull PlusOperator PLUS_OPERATOR = new PlusOperator();

    private PlusOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr e) {
        return e;
    }

}
