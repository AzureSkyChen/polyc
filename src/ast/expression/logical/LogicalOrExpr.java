package ast.expression.logical;

import ast.expression.Expr;
import interpreter.error.RuntimeError;
import interpreter.environment.ValEnv;
import interpreter.value.Value;
import interpreter.value.equality.BooleanValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class LogicalOrExpr extends LogicalExpr {

    public LogicalOrExpr(@NotNull Expr le, @NotNull Expr re) {
        super(le, re);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        BooleanValue lv = (BooleanValue) le.eval(env).deref();
        BooleanValue rv = (BooleanValue) re.eval(env).deref();
        return lv.implOfLogOr(rv);
    }
}
