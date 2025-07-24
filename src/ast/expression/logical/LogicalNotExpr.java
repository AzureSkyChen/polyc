package ast.expression.logical;

import ast.expression.Expr;
import ast.expression.UnaryExpr;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.type.Type;
import interpreter.type.equality.BooleanType;
import interpreter.value.Value;
import interpreter.value.equality.BooleanValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

public final class LogicalNotExpr extends UnaryExpr {
    public LogicalNotExpr(@NotNull Expr expr) {
        super(expr);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        BooleanValue v = (BooleanValue) expr.eval(env).deref();
        return v.implOfLogNot();
    }

    @Override
    @Contract(pure = true)
    public @NotNull BooleanType typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type t = expr.typeCheck(env);
        if (t instanceof BooleanType) {
            return BooleanType.getIterableInstance();
        }
        throw TypeError.TYPE_MISMATCH;
    }
}
