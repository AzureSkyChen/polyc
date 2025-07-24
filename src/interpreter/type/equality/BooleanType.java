package interpreter.type.equality;

import console.Format;
import interpreter.type.*;
import interpreter.type.Iterable;
import interpreter.value.equality.BooleanValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public sealed class BooleanType extends EqualityType implements IntLike, StringLike, Sizeable permits
        BooleanType.IterableBooleanType {
    private static final @NotNull BooleanType BOOL = new BooleanType();

    private BooleanType() {
    }

    @Contract(pure = true)
    public static @NotNull BooleanType getInstance() {
        return BOOL;
    }

    @Contract(pure = true)
    public static @NotNull BooleanType getIterableInstance() {
        return IterableBooleanType.ITERABLE_BOOL;
    }

    static final class IterableBooleanType extends BooleanType implements Iterable {
        private static final @NotNull IterableBooleanType ITERABLE_BOOL = new IterableBooleanType();

        @Override
        @Contract(pure = true)
        public @NotNull String toString() {
            return "%s[Iterable BooleanType]%s".formatted(Format.BLUE_BACK, Format.NONE);
        }
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s[BooleanType]%s".formatted(Format.BLUE_BACK, Format.NONE);
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type getIterable() {
        return BooleanType.IterableBooleanType.ITERABLE_BOOL;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type getNotIterable() {
        return BooleanType.BOOL;
    }

    @Override
    @Contract(pure = true)
    public boolean isEqualTo(@NotNull Type t) {
        return t instanceof BooleanType;
    }

    @Override
    @Contract(pure = true)
    public @NotNull BooleanValue getDefault() {
        return BooleanValue.FALSE;
    }
}
