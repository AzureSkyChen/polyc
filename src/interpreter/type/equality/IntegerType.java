package interpreter.type.equality;

import console.Format;
import interpreter.type.Comparable;
import interpreter.type.Iterable;
import interpreter.type.*;
import interpreter.value.equality.IntegerValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public sealed class IntegerType extends EqualityType implements Comparable, IntLike, StringLike, Sizeable permits
        IntegerType.IterableIntegerType {
    private static final @NotNull IntegerType INT = new IntegerType();

    private IntegerType() {
    }

    @Contract(pure = true)
    public static @NotNull IntegerType getInstance() {
        return INT;
    }

    @Contract(pure = true)
    public static @NotNull IntegerType getIterableInstance() {
        return IterableIntegerType.ITERABLE_INT;
    }

    static final class IterableIntegerType extends IntegerType implements Iterable {
        private static final @NotNull IterableIntegerType ITERABLE_INT = new IterableIntegerType();

        @Override
        @Contract(pure = true)
        public String toString() {
            return "%s[Iterable IntegerType]%s".formatted(Format.YELLOW_BACK, Format.NONE);
        }
    }

    @Override
    @Contract(pure = true)
    public String toString() {
        return "%s[IntegerType]%s".formatted(Format.YELLOW_BACK, Format.NONE);
    }

    @Override
    @Contract(pure = true)
    public @NotNull IntegerType getIterable() {
        return IntegerType.IterableIntegerType.ITERABLE_INT;
    }

    @Override
    @Contract(pure = true)
    public @NotNull IntegerType getNotIterable() {
        return IntegerType.INT;
    }

    @Override
    @Contract(pure = true)
    public boolean isComparableWith(@NotNull Type t) {
        return t instanceof IntegerType;
    }

    @Override
    @Contract(pure = true)
    public boolean isEqualTo(@NotNull Type t) {
        return t instanceof IntegerType;
    }

    @Override
    @Contract(pure = true)
    public @NotNull IntegerValue getDefault() {
        return IntegerValue.ZERO;
    }
}
