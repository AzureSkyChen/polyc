package interpreter.value.equality;

import console.Format;
import interpreter.error.RuntimeError;
import interpreter.type.equality.StringType;
import interpreter.value.Constable;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.Objects;

public final class StringValue extends EqualityValue implements Constable {
    private final @NotNull String string;

    public static final @NotNull StringValue EMPTY = new StringValue("");

    public static final class StrValBuilder {
        private final @NotNull StringBuilder stringBuilder;

        private StrValBuilder() {
            stringBuilder = new StringBuilder();
        }

        private StrValBuilder(String s) {
            stringBuilder = new StringBuilder(s);
        }

        @Contract(mutates = "this")
        public @NotNull StrValBuilder append(@NotNull String s) {
            stringBuilder.append(s);
            return this;
        }

        @Contract(mutates = "this")
        public StrValBuilder append(@NotNull StringValue strVal) {
            stringBuilder.append(strVal.string);
            return this;
        }

        @Contract(pure = true)
        public @NotNull StringValue toStringValue() {
            return StringValue.valueOf(toString());
        }

        @Override
        @Contract(pure = true)
        public @NotNull String toString() {
            return stringBuilder.toString();
        }
    }

    private StringValue(@NotNull String s) {
        this.string = s;
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull StringValue valueOf(@NotNull String s) {
        return new StringValue(s);
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull StringValue valueOf(@NotNull Integer integer) {
        return new StringValue(integer.toString());
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull StringValue valueOfQuotation(@NotNull String s) {
        return new StringValue(s.substring(1, s.length() - 1));
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull StringValue implOfConcat(@NotNull StringValue strVal1, @NotNull StringValue strVal2) {
        return StringValue.valueOf(strVal1.string + strVal2.string);
    }

    @Contract(value = "_ -> new", pure = true)
    public @NotNull StringValue implOfCharAt(@NotNull Value index) throws RuntimeError {
        if (index instanceof IntegerValue) {
            int i = ((IntegerValue) index).toInteger();
            if (i < 0 || i >= string.length()) {
                throw RuntimeError.LIST_INDEX_OUT_OF_RANGE;
            }
            return StringValue.valueOf(String.valueOf(string.charAt(i)));
        }
        throw RuntimeError.SHOULD_NOT_HAPPEN;
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull StrValBuilder getStrValBuilder(@NotNull String s) {
        return new StrValBuilder(s);
    }

    @Contract(value = " -> new", pure = true)
    @SuppressWarnings("unused")
    public static @NotNull StrValBuilder getStrValBuilder() {
        return new StrValBuilder();
    }

    @Override
    @Contract(pure = true)
    public @NotNull BooleanValue implOfEq(@NotNull Value valRHS) throws RuntimeError {
        Value value = valRHS.deref();
        if (this == value) {
            return BooleanValue.TRUE;
        }
        if (getClass() != value.getClass()) {
            return BooleanValue.FALSE;
        }
        StringValue that = (StringValue) value;
        return BooleanValue.valueOf(string.equals(that.string));
    }

    public void implOfPrint() {
        System.out.print(string);
    }

    @Override
    @Contract(pure = true)
    public @NotNull IntegerValue implOfInt() {
        return IntegerValue.valueOf(string);
    }

    @Override
    @Contract(pure = true)
    public @NotNull IntegerValue implOfSize() {
        return IntegerValue.valueOf(string.length());
    }

    @Override
    @Contract(pure = true)
    public @NotNull StringValue implOfString() {
        return this;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s(String:%s\"%s\"%s)%s".formatted(Format.GREEN, Format.NONE, string, Format.GREEN, Format.NONE);
    }

    @Override
    @Contract(pure = true)
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StringValue that = (StringValue) o;
        return string.equals(that.string);
    }

    @Override
    @Contract(pure = true)
    public int hashCode() {
        return Objects.hash(string);
    }

    @Override
    @Contract(pure = true)
    public @NotNull StringType getType() {
        return StringType.getIterableInstance();
    }
}
