package interpreter.type.equality;

import console.Format;
import interpreter.type.*;
import interpreter.type.Iterable;
import interpreter.value.equality.StringValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public sealed class StringType extends EqualityType implements IntLike, StringLike, Sizeable permits
        StringType.IterableStringType {
    private static final @NotNull StringType STRING = new StringType();

    private StringType() {
    }

    @Contract(pure = true)
    public static @NotNull StringType getInstance() {
        return STRING;
    }

    @Contract(pure = true)
    public static @NotNull StringType getIterableInstance() {
        return IterableStringType.ITERABLE_STRING;
    }

    static final class IterableStringType extends StringType implements Iterable {
        private static final @NotNull StringType ITERABLE_STRING = new IterableStringType();

        @Override
        @Contract(pure = true)
        public @NotNull String toString() {
            return "%s[Iterable StringType]%s".formatted(Format.GREEN, Format.NONE);
        }

    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s[StringType]%s".formatted(Format.GREEN, Format.NONE);
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type getIterable() {
        return StringType.IterableStringType.ITERABLE_STRING;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type getNotIterable() {
        return StringType.STRING;
    }

    @Override
    @Contract(pure = true)
    public boolean isEqualTo(@NotNull Type t) {
        return t instanceof StringType;
    }

    @Override
    @Contract(pure = true)
    public @NotNull StringValue getDefault() {
        return StringValue.EMPTY;
    }
}
