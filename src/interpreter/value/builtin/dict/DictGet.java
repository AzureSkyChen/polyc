package interpreter.value.builtin.dict;

import interpreter.error.RuntimeError;
import interpreter.value.*;
import org.jetbrains.annotations.NotNull;

public final class DictGet extends Value implements Callable {

    private final @NotNull DictValue Self;

    public DictGet(@NotNull DictValue self) {
        Self = self;
    }

    @Override
    public @NotNull Value implOfApply(@NotNull Value @NotNull [] valParams) throws RuntimeError {
        return Self.implOfGet(valParams[0]);
    }
}
