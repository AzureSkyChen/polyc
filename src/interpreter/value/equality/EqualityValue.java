package interpreter.value.equality;

import interpreter.error.RuntimeError;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract sealed class EqualityValue extends Value permits IntegerValue, BooleanValue, StringValue {
    @Contract(pure = true)
    public abstract @NotNull BooleanValue implOfEq(Value v) throws RuntimeError;

    @Contract(pure = true)
    public @NotNull BooleanValue implOfNeq(Value v) throws RuntimeError {
        return implOfEq(v).implOfLogNot();
    }
}
