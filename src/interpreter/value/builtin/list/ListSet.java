package interpreter.value.builtin.list;

import interpreter.error.RuntimeError;
import interpreter.value.ArrayValue;
import interpreter.value.Callable;
import interpreter.value.UnitValue;
import interpreter.value.Value;
import org.jetbrains.annotations.NotNull;

public final class ListSet extends Value implements Callable {

    private final @NotNull ArrayValue Self;

    public ListSet(@NotNull ArrayValue self) {
        Self = self;
    }

    @Override
    public @NotNull UnitValue implOfApply(@NotNull Value @NotNull [] valParams) throws RuntimeError {
        Self.implOfSet(valParams[0], valParams[1]);
        return UnitValue.UNIT;
    }
}
