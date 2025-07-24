package ast.expression.arithmetic;

import ast.expression.Expr;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.value.RefValue;
import interpreter.value.Value;
import interpreter.value.equality.IntegerValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class MinusMinusExpr extends ArithmeticAssignExpr {
    public MinusMinusExpr(@NotNull Expr expr) {
        super(expr);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        RefValue rv = (RefValue) expr.eval(env);
        return rv.implOfAssign(env, ((IntegerValue) rv.deref()).implOfDec());
    }

}
