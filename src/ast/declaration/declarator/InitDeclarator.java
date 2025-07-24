package ast.declaration.declarator;

import ast.declaration.initializer.Initializer;
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

public final class InitDeclarator extends Declarator {

    private final @NotNull Initializer initializer;

    public InitDeclarator(@NotNull Symbol s, @NotNull Initializer initializer) {
        super(s);
        this.initializer = initializer;
    }

    @Contract(mutates = "param2")
    public void evalFor(@NotNull Value defaultVal, @NotNull ValEnv env) throws RuntimeError {
        env.put(getSymbol(), initializer.eval(env).deref());
    }

    @Override
    @Contract(mutates = "param2")
    public void typeCheckFor(@NotNull Type declType, @NotNull TypeEnv env) throws TypeError {
        Type t = initializer.typeCheck(env).deref();
        if (declType instanceof Assignable assignable && assignable.isAssignableFrom(t)) {
            env.putAndCheck(getSymbol(), declType);
            return;
        }
        throw TypeError.TYPE_MISMATCH;
    }

    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(getSymbol()) +
                "\n" + Format.addIndent(initializer) +
                "\n%s</%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE);
    }
}
