package interpreter.value.builtin.list;

import interpreter.value.ArrayValue;
import interpreter.value.Callable;
import interpreter.value.Value;
import org.jetbrains.annotations.NotNull;

public final class ListPop extends Value implements Callable {

    private final @NotNull ArrayValue Self;

    public ListPop(@NotNull ArrayValue self) {
        Self = self;
    }

    @Override
    public @NotNull Value implOfApply(@NotNull Value @NotNull [] valParams) {
        return Self.implOfPop();
    }
}
