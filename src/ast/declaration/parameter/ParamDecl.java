package ast.declaration.parameter;

import ast.declaration.declarator.DeclSpec;
import ast.declaration.declarator.Declarator;
import ast.expression.Expr;
import console.Format;
import interpreter.environment.Symbol;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.Assignable;
import interpreter.type.Type;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class ParamDecl extends Expr {
    private final @NotNull DeclSpec declSpec;
    private final @NotNull Declarator declarator;
    private final @NotNull Expr initializer;

    private ParamDecl(@NotNull DeclSpec declSpec, @NotNull Declarator declarator, @NotNull Expr initializer) {
        this.declSpec = declSpec;
        this.declarator = declarator;
        this.initializer = initializer;
    }

    @Contract("_, _, _ -> new")
    public static @NotNull ParamDecl from(@NotNull DeclSpec declSpec,
                                          @NotNull Declarator declarator,
                                          @NotNull Expr initializer) {
        return new ParamDecl(declSpec, declarator, initializer);
    }

    @Contract("_, _ -> new")
    public static @NotNull ParamDecl from(@NotNull DeclSpec declSpec, @NotNull Declarator declarator) {
        return new ParamDecl(declSpec, declarator, Expr.valueOfEmpty());
    }

    @Contract(pure = true)
    public @NotNull Symbol getSymbol() {
        return declarator.getSymbol();
    }

    @Contract(pure = true)
    public boolean hasDefaultValue() {
        return !initializer.isEmpty();
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        return initializer.eval(env).deref();
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type declType = declSpec.getType();
        if (initializer.isEmpty()) {
            return declType;
        } else {
            Type t = initializer.typeCheck(env);
            if (declType instanceof Assignable && ((Assignable) declType).isAssignableFrom(t)) {
                return declType;
            }
        }
        throw TypeError.TYPE_MISMATCH;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(declSpec) +
                "\n" + Format.addIndent(declarator) +
                (initializer.isEmpty() ? "" : "\n" + Format.addIndent(initializer)) +
                "\n%s</%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE);
    }
}
