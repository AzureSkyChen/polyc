package interpreter.value;

import console.Format;
import interpreter.error.RuntimeError;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class UnitValue extends Value {

    public static final @NotNull UnitValue UNIT;
    public static final @NotNull UnitValue CONTINUE;
    public static final @NotNull UnitValue BREAK;

    private static class ReturnValue extends UnitValue {
        private final @NotNull Value val;

        private ReturnValue(@NotNull Value val) {
            this.val = val;
        }

        @Override
        @Contract(pure = true)
        public @NotNull Value getReturnValue() {
            return val;
        }

        @Override
        @Contract(pure = true)
        public boolean isReturnValue() {
            return true;
        }

        @Override
        @Contract(pure = true)
        public @NotNull String toString() {
            return "%s(Return:%s%s%s)%s".formatted(Format.BLACK, Format.NONE, val, Format.BLACK, Format.NONE);
        }
    }

    @Contract("_ -> new")
    public static @NotNull ReturnValue from(Value val) {
        return new ReturnValue(val);
    }

    @Contract(pure = true)
    public boolean isReturnValue() {
        return false;
    }

    @Contract(pure = true)
    public @NotNull Value getReturnValue() throws RuntimeError {
        if (this == UNIT) {
            return UNIT;
        }
        throw RuntimeError.SHOULD_NOT_HAPPEN;
    }

    static {
        UNIT = new UnitValue() {
            @Override
            @Contract(pure = true)
            public @NotNull String toString() {
                return "%s(Unit)%s".formatted(Format.BLACK, Format.NONE);
            }
        };
        CONTINUE = new UnitValue() {
            @Override
            @Contract(pure = true)
            public @NotNull String toString() {
                return "%s(Continue)%s".formatted(Format.BLACK, Format.NONE);
            }
        };
        BREAK = new UnitValue() {
            @Override
            @Contract(pure = true)
            public @NotNull String toString() {
                return "%s(Break)%s".formatted(Format.BLACK, Format.NONE);
            }
        };
    }
}
