package interpreter.value.builtin.dict;

import interpreter.error.RuntimeError;
import interpreter.value.Callable;
import interpreter.value.DictValue;
import interpreter.value.UnitValue;
import interpreter.value.Value;
import org.jetbrains.annotations.NotNull;

public final class DictPut extends Value implements Callable {

    private final @NotNull DictValue Self;

    public DictPut(@NotNull DictValue self) {
        Self = self;
    }

    @Override
    public @NotNull UnitValue implOfApply(@NotNull Value @NotNull [] valParams) throws RuntimeError {
        Self.implOfPut(valParams[0], valParams[1]);
        return UnitValue.UNIT;
    }
}
