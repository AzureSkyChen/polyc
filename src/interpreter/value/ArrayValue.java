package interpreter.value;

import console.Format;
import interpreter.environment.Symbol;
import interpreter.error.RuntimeError;
import interpreter.value.builtin.list.*;
import interpreter.value.equality.IntegerValue;
import interpreter.value.equality.StringValue;
import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class ArrayValue extends Value {
    private final @NotNull List<Value> valList = new ArrayList<>();

    private ArrayValue() {
    }

    @Contract(value = " -> new", pure = true)
    public static @NotNull ArrayValue valueOfEmpty() {
        return new ArrayValue();
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull ArrayValue fromSize(int size) {
        ArrayValue val = new ArrayValue();
        for (int i = 0; i < size; ++i) {
            val.valList.add(UnitValue.UNIT);
        }
        return val;
    }

    @Override
    public @NotNull Value getMethod(Symbol methodName) throws RuntimeError {
        if (methodName == Symbol.symbol("append")) {
            return new ListAppend(this);
        } else if (methodName == Symbol.symbol("pop")) {
            return new ListPop(this);
        } else if (methodName == Symbol.symbol("len")) {
            return new ListLen(this);
        } else if (methodName == Symbol.symbol("get")) {
            return new ListGet(this);
        } else if (methodName == Symbol.symbol("set")) {
            return new ListSet(this);
        }
        throw RuntimeError.SHOULD_NOT_HAPPEN;
    }

    @Contract(pure = true)
    private boolean checkIndex(@NotNull IntegerValue intValIndex) {
        int i = intValIndex.toInteger();
        return i >= 0 && i < valList.size();
    }

    @Contract(pure = true)
    @Flow(sourceIsContainer = true, source = "this.valList")
    public @NotNull Value implOfGet(@NotNull Value valIndex) throws RuntimeError {
        if (!(valIndex instanceof IntegerValue intValIndex)) {
            throw RuntimeError.SHOULD_NOT_HAPPEN;
        }
        if (checkIndex(intValIndex)) {
            return valList.get(intValIndex.toInteger());
        }
        throw RuntimeError.LIST_INDEX_OUT_OF_RANGE;
    }

    @Contract(mutates = "this")
    public void implOfAppend(@NotNull @Flow(targetIsContainer = true, target = "this.valList") Value v) {
        valList.add(v);
    }

    @Contract(mutates = "this")
    @Flow(sourceIsContainer = true, source = "this.valList")
    public Value implOfPop() {
        return valList.remove(valList.size() - 1);
    }

    @Contract(pure = true)
    public @NotNull IntegerValue implOfLen() {
        return IntegerValue.valueOf(valList.size());
    }

    @Contract(mutates = "this")
    public void implOfSet(@NotNull Value valIndex,
                          @NotNull @Flow(targetIsContainer = true, target = "this.valList") Value val) throws RuntimeError {
        if (!(valIndex instanceof IntegerValue intValIndex)) {
            throw RuntimeError.SHOULD_NOT_HAPPEN;
        }
        if (!checkIndex(intValIndex)) {
            throw RuntimeError.LIST_INDEX_OUT_OF_RANGE;
        }
        valList.set(intValIndex.toInteger(), val);
    }

    @Override
    @Contract(pure = true)
    public @NotNull IntegerValue implOfSize() throws RuntimeError {
        IntegerValue size = IntegerValue.ZERO;
        for (@NotNull Value val : valList) {
            size = size.implOfAdd(val.implOfSize());
        }
        return size;
    }

    @Override
    @Contract(pure = true)
    public @NotNull StringValue implOfString() throws RuntimeError {
        StringValue.StrValBuilder strValBuilder = StringValue.getStrValBuilder("[");
        for (@NotNull Value val : valList) {
            strValBuilder.append(val.implOfString()).append(":");
        }
        strValBuilder.append("nil]");
        return strValBuilder.toStringValue();
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s(Array:%s%s%s)%s".formatted(Format.DARK_GREEN, Format.NONE, valList, Format.DARK_GREEN, Format.NONE);
    }
}
