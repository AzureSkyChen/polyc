package ast.expression;

import ast.declaration.initializer.CommaInitList;
import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.ArrowType;
import interpreter.type.Type;
import interpreter.value.Callable;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class ApplyExpr extends Expr {

    private final @NotNull Expr idExpr;
    private final @NotNull CommaInitList parameters;

    public ApplyExpr(@NotNull Expr le, @NotNull CommaInitList re) {
        this.idExpr = le;
        this.parameters = re;
    }

    public ApplyExpr(@NotNull Expr le) {
        this.idExpr = le;
        this.parameters = CommaInitList.valueOfEmpty();

    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        Callable valFun = (Callable) idExpr.eval(env).deref();
        Value[] valParams = parameters.evalAsParams(env);
        return valFun.implOfApply(valParams);
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type funType = idExpr.typeCheck(env).deref();
        Type[] paramTypes = parameters.typeCheckAsParams(env);
        if (funType instanceof ArrowType) {
            ((ArrowType) funType).match(paramTypes);
            return ((ArrowType) funType).getReturnType();
        }
        throw TypeError.TYPE_MISMATCH;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(idExpr) +
                "\n" + Format.addIndent(parameters) +
                "\n%s</%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE);
    }
}
