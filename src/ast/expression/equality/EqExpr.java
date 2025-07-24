package ast.expression.equality;

import ast.expression.Expr;
import interpreter.error.RuntimeError;
import interpreter.environment.ValEnv;
import interpreter.value.Value;
import interpreter.value.equality.EqualityValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class EqExpr extends EqualityExpr {

    public EqExpr(@NotNull Expr le, @NotNull Expr re) {
        super(le, re);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        Value lv = le.eval(env).deref();
        Value rv = re.eval(env).deref();
        return ((EqualityValue) lv).implOfEq(rv);
    }
}
