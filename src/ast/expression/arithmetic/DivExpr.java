package ast.expression.arithmetic;

import ast.expression.Expr;
import interpreter.error.RuntimeError;
import interpreter.environment.ValEnv;
import interpreter.value.equality.IntegerValue;
import interpreter.value.Value;
import org.jetbrains.annotations.NotNull;

public final class DivExpr extends ArithmeticBinExpr {
    public DivExpr(@NotNull Expr le, @NotNull Expr re) {
        super(le, re);
    }

    @Override
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        IntegerValue lv = (IntegerValue) le.eval(env).deref();
        IntegerValue rv = (IntegerValue) re.eval(env).deref();
        return lv.implOfDiv(rv);
    }
}
