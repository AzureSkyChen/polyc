package ast.expression.builtin;

import ast.expression.Expr;
import ast.expression.UnaryExpr;
import console.Format;
import interpreter.environment.Symbol;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class DotExpr extends UnaryExpr {

    private final @NotNull Symbol methodName;

    public DotExpr(@NotNull Expr expr, @NotNull Symbol methodName) {
        super(expr);
        this.methodName = methodName;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        Value le = expr.eval(env).deref();
        return le.getMethod(methodName);
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type lt = expr.typeCheck(env).deref();
        return lt.getMethodType(methodName, env);
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(expr) +
                "\n\t%s<Method>%s".formatted(Format.PURPLE, Format.NONE) + methodName +
                "%s</Method>%s".formatted(Format.PURPLE, Format.NONE) +
                "\n%s</%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE);
    }
}
