package ast.expression;

import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.error.RuntimeError;
import interpreter.environment.ValEnv;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.value.Value;
import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class CommaExpr extends Expr {
    private final @NotNull Expr @NotNull [] exprList;

    public CommaExpr(int size) {
        this.exprList = new Expr[size];
    }

    @Contract(mutates = "this")
    public void addExpr(int index, @NotNull @Flow(targetIsContainer = true, target = "this.exprList") Expr expr) {
        exprList[index] = expr;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        Value last = null;
        for (@NotNull Expr expr : exprList) {
            last = expr.eval(env);
        }
        if (last == null) {
            throw RuntimeError.SHOULD_NOT_HAPPEN;
        }
        return last;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type last = null;
        for (@NotNull Expr expr : exprList) {
            last = expr.typeCheck(env);
        }
        if (last == null) {
            throw TypeError.SHOULD_NOT_HAPPEN;
        }
        return last;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%s<%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE));
        for (Expr expr : exprList) {
            stringBuilder.append("\n").append(Format.addIndent(expr));
        }
        stringBuilder.append("\n%s</%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE));
        return stringBuilder.toString();
    }
}
