package ast.expression.arithmetic;

import ast.expression.Expr;
import interpreter.environment.TypeEnv;
import interpreter.error.TypeError;
import interpreter.type.Iterable;
import interpreter.type.RefType;
import interpreter.type.Type;
import interpreter.type.equality.IntegerType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public sealed class ArithmeticAssignExpr extends ArithmeticUnaryExpr permits PlusPlusExpr, MinusMinusExpr {
    protected ArithmeticAssignExpr(@NotNull Expr expr) {
        super(expr);
    }

    @Override
    @Contract(pure = true)
    public @NotNull IntegerType typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type t = expr.typeCheck(env);
        if (!(t instanceof RefType)) {
            throw TypeError.TYPE_NOT_ASSIGNABLE;
        }
        if (env.iterableNotAssignable() && t.deref() instanceof Iterable) {
            throw TypeError.ITERABLE_NOT_ASSIGNABLE;
        }
        if (t.deref() instanceof IntegerType) {
            return (IntegerType) t.deref();
        }
        throw TypeError.TYPE_MISMATCH;
    }
}
