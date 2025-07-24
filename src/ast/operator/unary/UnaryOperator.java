package ast.operator.unary;

import ast.expression.Expr;
import ast.operator.Operator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract sealed class UnaryOperator extends Operator permits
        BitNotOperator, IntOperator, LogicalNotOperator, MinusMinusOperator, MinusOperator,
        PlusOperator, PlusPlusOperator, SizeOperator, StringOperator, ArrayOperator,
        PrintOperator {

    @Contract(value = "_ -> new", pure = true)
    public abstract @NotNull Expr applyTo(@NotNull Expr e);
}
