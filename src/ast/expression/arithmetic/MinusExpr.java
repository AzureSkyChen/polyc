package ast.expression.arithmetic;

import ast.expression.Expr;
import interpreter.error.RuntimeError;
import interpreter.environment.ValEnv;
import interpreter.value.equality.IntegerValue;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class MinusExpr extends ArithmeticUnaryExpr {
    public MinusExpr(@NotNull Expr expr) {
        super(expr);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        IntegerValue v = (IntegerValue) expr.eval(env).deref();
        return v.implOfMinus();
    }
}
