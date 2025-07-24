package ast.expression.comparison;

import ast.expression.Expr;
import interpreter.error.RuntimeError;
import interpreter.environment.ValEnv;
import interpreter.value.Comparable;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class LessEqExpr extends ComparisonExpr {

    public LessEqExpr(@NotNull Expr le, @NotNull Expr re) {
        super(le, re);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        Comparable<Value> lv = CastUtils.castEval(le, env);
        Value rv = CastUtils.castEval(re, env);
        return lv.implOfLessEq(rv);
    }
}
