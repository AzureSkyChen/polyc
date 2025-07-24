package interpreter.type.equality;

import interpreter.type.Assignable;
import interpreter.type.Type;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract sealed class EqualityType extends Type implements Assignable permits IntegerType, BooleanType, StringType {
    @Contract(pure = true)
    public abstract boolean isEqualTo(@NotNull Type t);

    @Override
    @Contract(pure = true)
    public boolean isAssignableFrom(@NotNull Type t) {
        return isEqualTo(t);
    }
}
