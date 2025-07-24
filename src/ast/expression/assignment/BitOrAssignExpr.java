package ast.expression.assignment;

import ast.expression.Expr;
import interpreter.error.RuntimeError;
import interpreter.environment.ValEnv;
import interpreter.value.RefValue;
import interpreter.value.Value;
import interpreter.value.equality.IntegerValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class BitOrAssignExpr extends AssignBaseExpr {
    public BitOrAssignExpr(@NotNull Expr le, @NotNull Expr re) {
        super(le, re);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        RefValue rv = (RefValue) le.eval(env);
        IntegerValue v = (IntegerValue) re.eval(env).deref();
        return rv.implOfAssign(env, ((IntegerValue) rv.deref()).implOfBitOr(v));
    }
}
