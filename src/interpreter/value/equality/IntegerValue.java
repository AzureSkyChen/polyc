package interpreter.value.equality;

import console.Format;
import interpreter.error.RuntimeError;
import interpreter.type.equality.IntegerType;
import interpreter.value.ArrayValue;
import interpreter.value.Comparable;
import interpreter.value.Constable;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static java.lang.Math.abs;

public final class IntegerValue extends EqualityValue implements Comparable<IntegerValue>, Constable {
    private final int integer;
    private final boolean isBinary;
    public static final @NotNull IntegerValue ZERO = new IntegerValue(0, false);
    public static final @NotNull IntegerValue ONE = new IntegerValue(1, false);

    private IntegerValue(int integer, boolean isBinary) {
        this.integer = integer;
        this.isBinary = isBinary;
    }

    @Contract(pure = true)
    public static @NotNull IntegerValue valueOf(int integer) {
        if (integer == 0) {
            return ZERO;
        } else if (integer == 1) {
            return ONE;
        }
        return new IntegerValue(integer, false);
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull IntegerValue valueOfBinary(int integer) {
        return new IntegerValue(integer, true);
    }

    @Contract(pure = true)
    public static @NotNull IntegerValue valueOf(@NotNull String s) {
        if (s.equals("0")) {
            return ZERO;
        } else if (s.equals("1")) {
            return ONE;
        }
        return new IntegerValue(Integer.parseInt(s), false);
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull IntegerValue valueOfBinary(@NotNull String s) {
        return new IntegerValue(Integer.parseInt(s.substring(2), 2), true);
    }

    @Contract(pure = true)
    public @NotNull IntegerValue implOfAdd(@NotNull IntegerValue intValAdd) {
        return IntegerValue.valueOf(integer + intValAdd.integer);
    }

    @Contract(pure = true)
    public @NotNull IntegerValue implOfInc() {
        return IntegerValue.valueOf(integer + 1);
    }

    @Contract(pure = true)
    public @NotNull IntegerValue implOfDec() {
        return IntegerValue.valueOf(integer - 1);
    }

    @Contract(pure = true)
    public static @NotNull IntegerValue implOfAdd(@NotNull IntegerValue intValAug, @NotNull IntegerValue intValAdd) {
        return IntegerValue.valueOf(intValAug.integer + intValAdd.integer);
    }

    @Contract(pure = true)
    public @NotNull IntegerValue implOfMinus() {
        return IntegerValue.valueOf(-integer);
    }

    @Contract(pure = true)
    public @NotNull IntegerValue implOfSub(@NotNull IntegerValue intValSubtrahend) {
        return IntegerValue.valueOf(integer - intValSubtrahend.integer);
    }

    @Contract(pure = true)
    public @NotNull IntegerValue implOfMod(@NotNull IntegerValue intValDivisor) throws RuntimeError {
        if (intValDivisor.equals(ZERO)) {
            throw RuntimeError.DIVISION_BY_ZERO;
        }
        return IntegerValue.valueOf(integer % intValDivisor.integer);
    }

    @Contract(pure = true)
    public @NotNull IntegerValue implOfDiv(@NotNull IntegerValue intValDivisor) throws RuntimeError {
        if (intValDivisor.equals(ZERO)) {
            throw RuntimeError.DIVISION_BY_ZERO;
        }
        return IntegerValue.valueOf(integer / intValDivisor.integer);
    }

    @Contract(pure = true)
    public @NotNull IntegerValue implOfShift(@NotNull IntegerValue intVal) {
        return IntegerValue.valueOf(integer >> intVal.integer);
    }

    @Contract(value = " -> new", pure = true)
    public @NotNull IntegerValue implOfBitNot() {
        return IntegerValue.valueOfBinary(~integer);
    }

    @Contract(value = "_ -> new", pure = true)
    public @NotNull IntegerValue implOfBitAnd(@NotNull IntegerValue intVal) {
        return IntegerValue.valueOfBinary(integer & intVal.integer);
    }

    @Contract(value = "_ -> new", pure = true)
    public @NotNull IntegerValue implOfBitXor(@NotNull IntegerValue intVal) {
        return IntegerValue.valueOfBinary(integer ^ intVal.integer);
    }

    @Contract(value = "_ -> new", pure = true)
    public @NotNull IntegerValue implOfBitOr(@NotNull IntegerValue intVal) {
        return IntegerValue.valueOfBinary(integer | intVal.integer);
    }

    @Override
    @Contract(pure = true)
    public @NotNull BooleanValue implOfGreater(@NotNull IntegerValue intValRHS) {
        return BooleanValue.valueOf(integer > intValRHS.integer);
    }

    @Override
    @Contract(pure = true)
    public @NotNull BooleanValue implOfLess(@NotNull IntegerValue intValRHS) {
        return BooleanValue.valueOf(integer < intValRHS.integer);
    }

    @Override
    @Contract(pure = true)
    public @NotNull BooleanValue implOfGreaterEq(@NotNull IntegerValue intValRHS) {
        return BooleanValue.valueOf(integer >= intValRHS.integer);
    }

    @Override
    @Contract(pure = true)
    public @NotNull BooleanValue implOfLessEq(@NotNull IntegerValue intValRHS) {
        return BooleanValue.valueOf(integer <= intValRHS.integer);
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
        IntegerValue that = (IntegerValue) value;
        return BooleanValue.valueOf(Objects.equals(integer, that.integer));
    }

    @Override
    @Contract(pure = true)
    public @NotNull IntegerValue implOfInt() {
        return this;
    }

    @Override
    @Contract(pure = true)
    public @NotNull IntegerValue implOfSize() {
        if (integer == 0) {
            return ZERO;
        }
        return IntegerValue.valueOf(Integer.toBinaryString(abs(integer)).length());
    }

    @Override
    @Contract(value = " -> new", pure = true)
    public @NotNull StringValue implOfString() {
        return StringValue.valueOf(integer);
    }

    @Override
    @Contract(value = " -> new", pure = true)
    public @NotNull ArrayValue implOfArray() {
        return ArrayValue.fromSize(integer);
    }

    @Contract(pure = true)
    public @NotNull Integer toInteger() {
        return integer;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        if (isBinary) {
            return "%s(Integer:0b%s)%s".formatted(Format.YELLOW_BACK, Integer.toBinaryString(integer), Format.NONE);
        }
        return "%s(Integer:%s)%s".formatted(Format.YELLOW_BACK, Integer.toString(integer), Format.NONE);
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
        IntegerValue that = (IntegerValue) o;
        return Objects.equals(integer, that.integer);
    }

    @Override
    @Contract(pure = true)
    public int hashCode() {
        return Objects.hash(integer);
    }

    @Override
    @Contract(pure = true)
    public @NotNull IntegerType getType() {
        return IntegerType.getIterableInstance();
    }
}
