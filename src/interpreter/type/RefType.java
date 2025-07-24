package interpreter.type;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class RefType extends Type {
    private final @NotNull Type t;


    private RefType(@NotNull Type t) {
        this.t = t;
    }

    @Override
    public Type deref() {
        return t;
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull RefType valueOf(@NotNull Type t) {
        return new RefType(t);
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return t.toString();
    }
}
