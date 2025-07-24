package ast.expression.arithmetic;

import ast.expression.Expr;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.value.RefValue;
import interpreter.value.Value;
import interpreter.value.equality.IntegerValue;
import org.jetbrains.annotations.NotNull;

public final class PlusPlusExpr extends ArithmeticAssignExpr {
    public PlusPlusExpr(@NotNull Expr expr) {
        super(expr);
    }

    @Override
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        RefValue rv = (RefValue) expr.eval(env);
        return rv.implOfAssign(env, ((IntegerValue) rv.deref()).implOfInc());
    }
}
