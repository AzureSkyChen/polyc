package ast.expression.arithmetic;

import ast.expression.Expr;
import interpreter.error.RuntimeError;
import interpreter.environment.ValEnv;
import interpreter.value.Value;
import interpreter.value.equality.IntegerValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

public final class BitNotExpr extends ArithmeticUnaryExpr {
    public BitNotExpr(@NotNull Expr expr) {
        super(expr);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        IntegerValue v = (IntegerValue) expr.eval(env).deref();
        return v.implOfBitNot();
    }
}
