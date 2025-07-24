package interpreter.value.equality;

import console.Format;
import interpreter.type.equality.BooleanType;
import interpreter.value.Constable;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public non-sealed class BooleanValue extends EqualityValue implements Constable {

    public static final @NotNull BooleanValue TRUE;
    public static final @NotNull BooleanValue FALSE;

    private BooleanValue() {
    }

    static {
        TRUE = new BooleanValue() {
            @Override
            @Contract(pure = true)
            public @NotNull String toString() {
                return "%s(Boolean:true)%s".formatted(Format.BLUE_BACK, Format.NONE);
            }
        };
        FALSE = new BooleanValue() {
            @Override
            @Contract(pure = true)
            public @NotNull String toString() {
                return "%s(Boolean:false)%s".formatted(Format.BLUE_BACK, Format.NONE);
            }
        };
    }

    @Contract(pure = true)
    public static @NotNull BooleanValue valueOf(@Nullable String s) {
        return "true".equalsIgnoreCase(s) ? TRUE : FALSE;
    }

    @Contract(pure = true)
    public static @NotNull BooleanValue valueOf(boolean b) {
        return b ? TRUE : FALSE;
    }

    @Contract(pure = true)
    public @NotNull BooleanValue implOfLogNot() {
        return this == TRUE ? FALSE : TRUE;
    }

    @Contract(pure = true)
    public @NotNull BooleanValue implOfLogAnd(@NotNull BooleanValue boolVal) {
        return BooleanValue.valueOf(this == TRUE && boolVal == TRUE);
    }

    @Contract(pure = true)
    public @NotNull BooleanValue implOfLogOr(@NotNull BooleanValue boolVal) {
        return BooleanValue.valueOf(this == TRUE || boolVal == TRUE);
    }

    @Contract(pure = true)
    public @NotNull BooleanValue implOfEq(@NotNull Value valRHS) {
        return BooleanValue.valueOf(this == valRHS);
    }

    @Override
    @Contract(pure = true)
    public @NotNull IntegerValue implOfInt() {
        return this == TRUE ? IntegerValue.ONE : IntegerValue.ZERO;
    }

    @Override
    @Contract(pure = true)
    public @NotNull IntegerValue implOfSize() {
        return IntegerValue.ONE;
    }

    @Override
    @Contract(pure = true)
    public @NotNull StringValue implOfString() {
        return this == TRUE ? StringValue.valueOf("true") : StringValue.valueOf("false");
    }

    @Contract(pure = true)
    public boolean toBoolean() {
        return this == TRUE;
    }

    @Override
    @Contract(pure = true)
    public @NotNull BooleanType getType() {
        return BooleanType.getIterableInstance();
    }
}
