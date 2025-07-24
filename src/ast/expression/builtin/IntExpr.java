package ast.expression.builtin;

import ast.expression.Expr;
import ast.expression.UnaryExpr;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.type.IntLike;
import interpreter.type.Iterable;
import interpreter.type.Type;
import interpreter.type.equality.IntegerType;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class IntExpr extends UnaryExpr {
    public IntExpr(@NotNull Expr expr) {
        super(expr);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        Value v = expr.eval(env).deref();
        try {
            return v.implOfInt();
        } catch (Exception e) {
            throw RuntimeError.INT_ERROR;
        }
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type t = expr.typeCheck(env).deref();
        if (t instanceof IntLike) {
            if (t instanceof Iterable) {
                return IntegerType.getIterableInstance();
            }
            return IntegerType.getInstance();
        }
        throw TypeError.TYPE_NOT_INT_LIKE;
    }
}
