package interpreter.value.builtin.dict;

import interpreter.error.RuntimeError;
import interpreter.value.Callable;
import interpreter.value.DictValue;
import interpreter.value.Value;
import org.jetbrains.annotations.NotNull;

public final class DictRemove extends Value implements Callable {

    private final @NotNull DictValue Self;

    public DictRemove(@NotNull DictValue self) {
        Self = self;
    }

    @Override
    public @NotNull Value implOfApply(@NotNull Value @NotNull [] valParams) throws RuntimeError {
        return Self.implOfRemove(valParams[0]);
    }
}
