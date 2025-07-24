package ast.operator.unary;

import ast.expression.Expr;
import ast.expression.builtin.ArrayExpr;
import ast.expression.builtin.PrintExpr;
import org.jetbrains.annotations.NotNull;

public final class PrintOperator extends UnaryOperator {

    public static final @NotNull PrintOperator PRINT_OPERATOR = new PrintOperator();

    private PrintOperator() {
    }

    @Override
    public @NotNull Expr applyTo(@NotNull Expr e) {
        return new PrintExpr(e);
    }
}
