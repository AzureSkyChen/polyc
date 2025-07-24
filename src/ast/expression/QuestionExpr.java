package ast.expression;

import console.Format;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.type.Assignable;
import interpreter.type.Type;
import interpreter.type.equality.BooleanType;
import interpreter.value.equality.BooleanValue;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class QuestionExpr extends Expr {

    private final @NotNull Expr cond;
    private final @NotNull Expr le;
    private final @NotNull Expr re;

    public QuestionExpr(@NotNull Expr cond, @NotNull Expr le, @NotNull Expr re) {
        this.cond = cond;
        this.le = le;
        this.re = re;
    }

    @Override
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        BooleanValue b = (BooleanValue) cond.eval(env).deref();
        if (b.toBoolean()) {
            return le.eval(env);
        } else {
            return re.eval(env);
        }
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type typeOfCond = cond.typeCheck(env).deref();
        Type lt = le.typeCheck(env).deref();
        Type rt = re.typeCheck(env).deref();
        if (typeOfCond instanceof BooleanType && lt instanceof Assignable && ((Assignable) lt).isAssignableFrom(rt)) {
            return Type.min(lt, rt);
        }
        throw TypeError.TYPE_MISMATCH;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(cond) +
                "\n" + Format.addIndent(le) +
                "\n" + Format.addIndent(re) +
                "\n%s</%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE);
    }
}
