package interpreter.value;

import console.Format;
import interpreter.environment.Symbol;
import interpreter.error.RuntimeError;
import interpreter.value.builtin.dict.*;
import interpreter.value.equality.BooleanValue;
import interpreter.value.equality.IntegerValue;
import interpreter.value.equality.StringValue;
import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;


public final class DictValue extends Value {
    private final @NotNull Map<Value, Value> valDict = new HashMap<>();

    private DictValue() {
    }

    @Contract(value = " -> new", pure = true)
    public static @NotNull DictValue valueOfEmpty() {
        return new DictValue();
    }

    @Override
    public @NotNull Value getMethod(Symbol methodName) throws RuntimeError {
        if (methodName == Symbol.symbol("get")) {
            return new DictGet(this);
        } else if (methodName == Symbol.symbol("set")) {
            return new DictPut(this);
        } else if (methodName == Symbol.symbol("remove")) {
            return new DictRemove(this);
        } else if (methodName == Symbol.symbol("isEmpty")) {
            return new DictEmpty(this);
        } else if (methodName == Symbol.symbol("containsKey")) {
            return new DictContainsKey(this);
        }
        throw RuntimeError.SHOULD_NOT_HAPPEN;
    }

    @Contract(pure = true)
    @Flow(sourceIsContainer = true, source = "this.valDict")
    public @NotNull Value implOfGet(Value valKey) throws RuntimeError {
        if (!valDict.containsKey(valKey)) {
            return UnitValue.UNIT;
        }
        return valDict.get(valKey);
    }

    @Contract(mutates = "this")
    public void implOfPut(@NotNull @Flow(targetIsContainer = true, target = "this.valDict") Value valKey,
                          @NotNull @Flow(targetIsContainer = true, target = "this.valDict") Value valVal) {
        valDict.put(valKey, valVal);
    }

    @Contract(mutates = "this")
    @Flow(sourceIsContainer = true, source = "this.valDict")
    public @NotNull Value implOfRemove(@NotNull Value valKey) {
        return valDict.remove(valKey);
    }

    @Contract(pure = true)
    public @NotNull BooleanValue implOfContainsKey(@NotNull Value valKey) {
        return BooleanValue.valueOf(valDict.containsKey(valKey));
    }

    @Contract(pure = true)
    public @NotNull BooleanValue implOfIsEmpty() {
        return BooleanValue.valueOf(valDict.isEmpty());
    }

    @Override
    @Contract(pure = true)
    public @NotNull IntegerValue implOfSize() throws RuntimeError {
        IntegerValue size = IntegerValue.ZERO;
        for (@NotNull Value valKey : valDict.keySet()) {
            Value valVal = valDict.get(valKey);
            size = size.implOfAdd(IntegerValue.implOfAdd(valKey.implOfSize(), valVal.implOfSize()));
        }
        return size;
    }

    @Override
    @Contract(pure = true)
    public @NotNull StringValue implOfString() throws RuntimeError {
        StringValue.StrValBuilder strValBuilder = StringValue.getStrValBuilder("{");
        for (@NotNull Value valKey : valDict.keySet()) {
            Value valVal = valDict.get(valKey);
            strValBuilder.append(valKey.implOfString()).append("->").append(valVal.implOfString()).append(",");
        }
        strValBuilder.append("end}");
        return strValBuilder.toStringValue();
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s(Dict%s:%s%s)%s".formatted(Format.BLUE, Format.NONE, valDict, Format.BLUE, Format.NONE);
    }
}
