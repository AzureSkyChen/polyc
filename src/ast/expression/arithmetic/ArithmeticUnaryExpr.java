package ast.expression.arithmetic;

import ast.expression.Expr;
import ast.expression.UnaryExpr;
import interpreter.error.TypeError;
import interpreter.environment.TypeEnv;
import interpreter.type.Type;
import interpreter.type.equality.IntegerType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract sealed class ArithmeticUnaryExpr extends UnaryExpr permits
        BitNotExpr,
        MinusExpr,
        ArithmeticAssignExpr {
    protected ArithmeticUnaryExpr(@NotNull Expr expr) {
        super(expr);
    }

    @Override
    @Contract(pure = true)
    public @NotNull IntegerType typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type t = expr.typeCheck(env).deref();
        if (t instanceof IntegerType) {
            return (IntegerType) t;
        }
        throw TypeError.TYPE_MISMATCH;
    }
}
