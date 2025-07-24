package interpreter.value.builtin.list;

import interpreter.value.ArrayValue;
import interpreter.value.Callable;
import interpreter.value.UnitValue;
import interpreter.value.Value;
import org.jetbrains.annotations.NotNull;

public final class ListAppend extends Value implements Callable {

    private final @NotNull ArrayValue Self;

    public ListAppend(@NotNull ArrayValue self) {
        Self = self;
    }

    @Override
    public @NotNull Value implOfApply(@NotNull Value @NotNull [] valParams) {
        Self.implOfAppend(valParams[0]);
        return UnitValue.UNIT;
    }
}
