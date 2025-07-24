package interpreter.value.builtin.list;

import interpreter.error.RuntimeError;
import interpreter.value.ArrayValue;
import interpreter.value.Callable;
import interpreter.value.Value;
import org.jetbrains.annotations.NotNull;

public final class ListGet extends Value implements Callable {

    private final @NotNull ArrayValue Self;

    public ListGet(@NotNull ArrayValue self) {
        Self = self;
    }

    @Override
    public @NotNull Value implOfApply(@NotNull Value @NotNull [] valParams) throws RuntimeError {
        return Self.implOfGet(valParams[0]);
    }
}
