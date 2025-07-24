package ast.operator;

import ast.Node;
import ast.expression.Expr;
import ast.operator.binary.*;
import ast.operator.unary.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract class Operator extends Node {
    private static final @NotNull Operator NULL = new Operator() {
        @Contract(pure = true)
        @SuppressWarnings({"unused", "SameReturnValue"})
        public @NotNull Expr applyTo() {
            return Expr.valueOfEmpty();
        }
    };

    @Contract(pure = true)
    public static @NotNull Operator fromOpName(@NotNull String name) {
        return switch (name) {
            case "++" -> PlusPlusOperator.PLUS_PLUS_OPERATOR;
            case "--" -> MinusMinusOperator.MINUS_MINUS_OPERATOR;
            case "+" -> PlusOperator.PLUS_OPERATOR;
            case "-" -> MinusOperator.MINUS_OPERATOR;
            case "~" -> BitNotOperator.BIT_NOT_OPERATOR;
            case "!", "not" -> LogicalNotOperator.LOGICAL_NOT_OPERATOR;
            case "size" -> SizeOperator.SIZE_OPERATOR;
            case "int" -> IntOperator.INT_OPERATOR;
            case "string" -> StringOperator.STRING_OPERATOR;
            case "array" -> ArrayOperator.ARRAY_OPERATOR;
            case "print" -> PrintOperator.PRINT_OPERATOR;
            case "==" -> EqOperator.EQ_OPERATOR;
            case "!=" -> NeqOperator.NEQ_OPERATOR;
            case ">" -> GreaterOperator.GREATER_OPERATOR;
            case "<" -> LessOperator.LESS_OPERATOR;
            case ">=" -> GreaterEqOperator.GREATER_EQ_OPERATOR;
            case "<=" -> LessEqOperator.LESS_EQ_OPERATOR;
            case "=" -> AssignOperator.ASSIGN_OPERATOR;
            case "/=" -> DivAssignOperator.DIV_ASSIGN_OPERATOR;
            case "%=" -> ModAssignOperator.MOD_ASSIGN_OPERATOR;
            case "+=" -> PlusAssignOperator.PLUS_ASSIGN_OPERATOR;
            case "-=" -> MinusAssignOperator.MINUS_ASSIGN_OPERATOR;
            case ">>=" -> ShiftAssignOperator.SHIFT_ASSIGN_OPERATOR;
            case "&=" -> AndAssignOperator.AND_ASSIGN_OPERATOR;
            case "|=" -> OrAssignOperator.OR_ASSIGN_OPERATOR;
            case "^=" -> XorAssignOperator.XOR_ASSIGN_OPERATOR;
            default -> NULL;
        };
    }
}
