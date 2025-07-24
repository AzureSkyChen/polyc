package interpreter.type;

import interpreter.environment.Symbol;
import interpreter.environment.TypeEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract class Type {

    protected void checkIterable(@NotNull TypeEnv env) throws TypeError {
        if (this instanceof Iterable && env.iterableNotAssignable()) {
            throw TypeError.ITERABLE_NOT_ASSIGNABLE;
        }
    }

    @Contract(pure = true)
    public ArrowType getMethodType(@NotNull Symbol methodName, @NotNull TypeEnv env) throws TypeError {
        throw TypeError.NO_SUCH_METHOD;
    }

    @Contract(pure = true)
    public @NotNull Type getIterable() {
        return this;
    }

    @Contract(pure = true)
    public @NotNull Type getNotIterable() {
        return this;
    }

    @Contract(pure = true)
    public boolean isValidInSpecifier() {
        return true;
    }

    @Contract(pure = true)
    public boolean isInvalidInEnv() {
        return !isValidInSpecifier();
    }

    @Contract(pure = true)
    public Type deref() {
        return this;
    }

    @Contract(pure = true)
    public @NotNull Value getDefault() throws RuntimeError {
        throw RuntimeError.SHOULD_NOT_HAPPEN;
    }

    @Contract(pure = true)
    public static <T extends Type> @NotNull T min(@NotNull T t1, @NotNull T t2) {
        if (t1 instanceof Iterable) {
            return t2;
        }
        return t1;
    }

    @Contract(pure = true)
    public static <T> boolean ge(@NotNull T t1, @NotNull T t2) {
        if (t1 instanceof Iterable) {
            return true;
        }
        return !(t2 instanceof Iterable);
    }
}
