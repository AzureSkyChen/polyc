package interpreter.value.builtin.dict;

import interpreter.error.RuntimeError;
import interpreter.value.Callable;
import interpreter.value.DictValue;
import interpreter.value.Value;
import interpreter.value.equality.BooleanValue;
import org.jetbrains.annotations.NotNull;

public final class DictEmpty extends Value implements Callable {

    private final @NotNull DictValue Self;

    public DictEmpty(@NotNull DictValue self) {
        Self = self;
    }

    @Override
    public @NotNull BooleanValue implOfApply(@NotNull Value @NotNull [] valParams) throws RuntimeError {
        return Self.implOfIsEmpty();
    }
}
