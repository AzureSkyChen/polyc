package ast.expression;

import interpreter.error.RuntimeError;
import interpreter.environment.TypeEnv;
import interpreter.error.TypeError;
import interpreter.environment.ValEnv;
import interpreter.type.Type;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class ParenExpr extends UnaryExpr {

    public ParenExpr(@NotNull Expr expr) {
        super(expr);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        return expr.eval(env);
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        return expr.typeCheck(env);
    }
}
