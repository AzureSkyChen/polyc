package ast.expression.builtin;

import ast.expression.Expr;
import ast.expression.UnaryExpr;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.type.Iterable;
import interpreter.type.StringLike;
import interpreter.type.Type;
import interpreter.type.equality.EqualityType;
import interpreter.type.equality.StringType;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class StringExpr extends UnaryExpr {

    public StringExpr(@NotNull Expr expr) {
        super(expr);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        Value v = expr.eval(env).deref();
        return v.implOfString();
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type t = expr.typeCheck(env).deref();
        if (t instanceof StringLike) {
            if (t instanceof Iterable) {
                return StringType.getIterableInstance();
            } else if (t instanceof EqualityType) {
                return StringType.getInstance();
            }
            throw TypeError.TYPE_MISMATCH;
        }
        throw TypeError.TYPE_NOT_STRING_LIKE;
    }
}
