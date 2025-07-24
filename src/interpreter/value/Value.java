package interpreter.value;

import interpreter.environment.Symbol;
import interpreter.error.RuntimeError;
import interpreter.value.equality.IntegerValue;
import interpreter.value.equality.StringValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract class Value {

    @Contract(value = "_ -> fail", pure = true)
    public @NotNull Value getMethod(Symbol methodName) throws RuntimeError {
        throw RuntimeError.SHOULD_NOT_HAPPEN;
    }

    @Contract(value = " -> fail", pure = true)
    public @NotNull IntegerValue implOfInt() throws RuntimeError {
        throw RuntimeError.SHOULD_NOT_HAPPEN;
    }

    @Contract(value = " -> fail", pure = true)
    public @NotNull IntegerValue implOfSize() throws RuntimeError {
        throw RuntimeError.SHOULD_NOT_HAPPEN;
    }

    @Contract(value = " -> fail", pure = true)
    public @NotNull StringValue implOfString() throws RuntimeError {
        throw RuntimeError.SHOULD_NOT_HAPPEN;
    }

    @Contract(value = " -> fail", pure = true)
    public @NotNull ArrayValue implOfArray() throws RuntimeError {
        throw RuntimeError.SHOULD_NOT_HAPPEN;
    }

    @Contract(value = " -> this", pure = true)
    public @NotNull Value deref() throws RuntimeError {
        return this;
    }
}
