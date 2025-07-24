package ast.declaration.declarator;

import ast.Node;
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

public sealed class Declarator extends Node permits InitDeclarator {

    private final @NotNull Symbol s;

    public Declarator(@NotNull Symbol s) {
        this.s = s;
    }

    @Contract(pure = true)
    public @NotNull Symbol getSymbol() {
        return s;
    }

    @Contract(mutates = "param2")
    public void evalFor(@NotNull Value defaultVal, @NotNull ValEnv env) throws RuntimeError {
        env.put(s, defaultVal);
    }

    @Contract(mutates = "param2")
    public void typeCheckFor(@NotNull Type declType, @NotNull TypeEnv env) throws TypeError {
        env.putAndCheck(s, declType);
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE) +
                s +
                "%s</%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE);
    }
}
