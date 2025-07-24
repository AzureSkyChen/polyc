package ast.expression.builtin;

import ast.expression.Expr;
import ast.expression.UnaryExpr;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.ArrayType;
import interpreter.type.Iterable;
import interpreter.type.Sizeable;
import interpreter.type.Type;
import interpreter.type.equality.IntegerType;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class ArrayExpr extends UnaryExpr {

    public ArrayExpr(@NotNull Expr expr) {
        super(expr);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        Value v = expr.eval(env).deref();
        return v.implOfArray();
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type t = expr.typeCheck(env).deref();
        if (t instanceof IntegerType) {
            return ArrayType.fromEmpty();
        }
        throw TypeError.TYPE_MISMATCH;
    }
}
