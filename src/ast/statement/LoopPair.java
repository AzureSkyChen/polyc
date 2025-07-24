package ast.statement;

import ast.expression.Expr;
import console.Format;
import interpreter.environment.Symbol;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.type.equality.IntegerType;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class LoopPair extends Expr {

    public final @NotNull Symbol s;
    public final @NotNull Expr expr;

    public LoopPair(@NotNull Symbol s, @NotNull Expr expr) {
        this.s = s;
        this.expr = expr;
    }

    @Contract(pure = true)
    public @NotNull Symbol getSymbol() {
        return s;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        return expr.eval(env);
    }

    @Override
    @Contract(pure = true)
    public @NotNull IntegerType typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type t = expr.typeCheck(env).deref();
        if (t == IntegerType.getIterableInstance()) {
            return IntegerType.getIterableInstance();
        }
        throw TypeError.LOOP_VAR_ITERABLE;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(s) +
                "\n" + Format.addIndent(expr) +
                "\n%s</%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE);
    }
}
