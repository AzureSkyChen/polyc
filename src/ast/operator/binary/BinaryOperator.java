package ast.operator.binary;

import ast.expression.Expr;
import ast.operator.Operator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract sealed class BinaryOperator extends Operator permits
        AndAssignOperator, AssignOperator, DivAssignOperator, EqOperator, GreaterEqOperator,
        GreaterOperator, LessEqOperator, LessOperator, MinusAssignOperator, ModAssignOperator,
        NeqOperator, OrAssignOperator, PlusAssignOperator, ShiftAssignOperator, XorAssignOperator {
    @Contract(value = "_, _ -> new", pure = true)
    public abstract @NotNull Expr applyTo(@NotNull Expr le, @NotNull Expr re);

}
