package ast.declaration.initializer;

import ast.expression.Expr;
import console.Format;
import interpreter.error.RuntimeError;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Initializer extends Expr {

    private final @NotNull Expr clause;

    public Initializer(@NotNull Expr clause) {
        this.clause = clause;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        return clause.eval(env).deref();
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        return clause.typeCheck(env).deref();
    }

    @Override
    public String toString() {
        return "%s<%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE) +
                "\n\t" + Format.addIndent(clause) +
                "\n%s</%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE);
    }
}
