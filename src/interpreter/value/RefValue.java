package interpreter.value;

import interpreter.environment.Symbol;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.value.equality.StringValue;
import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RefValue extends Value {
    private final @NotNull Symbol symbol;
    private final @NotNull Value val;
    private final @Nullable Value index;
    private final @Nullable Value toAssign;

    private RefValue(@NotNull Symbol symbol, @NotNull Value val,
                     @Nullable Value index, @Nullable Value toAssign) throws RuntimeError {
        if (val instanceof RefValue) {
            throw RuntimeError.NOT_ASSIGNABLE;
        }
        this.symbol = symbol;
        this.val = val;
        this.index = index;
        this.toAssign = toAssign;
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull RefValue valueOf(@NotNull Symbol symbol, @NotNull Value val) throws RuntimeError {
        return new RefValue(symbol, val, null, null);
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    public static @NotNull RefValue valueOf(@NotNull Symbol symbol, @NotNull Value val,
                                            @NotNull Value index, @NotNull Value toAssign) throws RuntimeError {
        return new RefValue(symbol, val, index, toAssign);
    }

    @Contract(pure = true)
    public @NotNull Value implOfIndexing(Value valIndex) throws RuntimeError {
        if (val instanceof ArrayValue) {
            return RefValue.valueOf(symbol, ((ArrayValue) val).implOfGet(valIndex), valIndex, val);
        } else if (val instanceof DictValue) {
            return RefValue.valueOf(symbol, ((DictValue) val).implOfGet(valIndex), valIndex, val);
        } else if (val instanceof StringValue) {
            return ((StringValue) val).implOfCharAt(valIndex);
        }
        throw RuntimeError.INDEX_ERROR;
    }

    @Contract(mutates = "param1, this")
    public @NotNull RefValue implOfAssign(@NotNull @Flow(source = "newVal") ValEnv env,
                                          @NotNull @Flow(targetIsContainer = true) Value newVal) throws RuntimeError {
        if (index == null) {
            env.update(symbol, newVal);
            return RefValue.valueOf(symbol, newVal);
        } else if (toAssign instanceof ArrayValue) {
            ((ArrayValue) toAssign).implOfSet(index, newVal);
            return RefValue.valueOf(symbol, newVal, index, toAssign);
        } else if (toAssign instanceof DictValue) {
            ((DictValue) toAssign).implOfPut(index, newVal);
            return RefValue.valueOf(symbol, newVal, index, toAssign);
        }
        throw RuntimeError.NOT_ASSIGNABLE;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Value deref() throws RuntimeError {
        if (val instanceof UnitValue) {
            if (toAssign instanceof DictValue) {
                throw RuntimeError.DICT_KEY_NOT_EXISTS;
            }
            throw RuntimeError.VARIABLE_UNINITIALIZED;
        }
        return val;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return val.toString();
    }
}
