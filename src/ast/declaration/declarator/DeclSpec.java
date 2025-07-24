package ast.declaration.declarator;

import ast.Node;
import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.Iterable;
import interpreter.type.Type;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class DeclSpec extends Node {
    private final @NotNull Type t;

    public DeclSpec(@NotNull Type t) {
        this.t = t;
    }

    @Contract(pure = true)
    public @NotNull Type getType() {
        return t;
    }

    @Contract(pure = true)
    public @NotNull DeclSpec toIterable() {
        if (t instanceof Iterable) {
            return this;
        }
        return new DeclSpec(t.getIterable());
    }

    @Override
    @Contract(pure = true)
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        return t.getDefault();
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(TypeEnv env) throws TypeError {
        if (t.isValidInSpecifier()) {
            return t;
        }
        throw TypeError.INVALID_TYPE;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE) +
                t +
                "%s</%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE);
    }
}
