package ast.expression.arithmetic;

import ast.expression.Expr;
import interpreter.error.RuntimeError;
import interpreter.environment.ValEnv;
import interpreter.value.Value;
import interpreter.value.equality.IntegerValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class SubExpr extends ArithmeticBinExpr {

    public SubExpr(@NotNull Expr le, @NotNull Expr re) {
        super(le, re);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        IntegerValue lv = (IntegerValue) le.eval(env).deref();
        IntegerValue rv = (IntegerValue) re.eval(env).deref();
        return lv.implOfSub(rv);
    }
}
