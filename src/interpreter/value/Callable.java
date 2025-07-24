package interpreter.value;

import interpreter.error.RuntimeError;
import org.jetbrains.annotations.NotNull;

public interface Callable {
    @NotNull Value implOfApply(@NotNull Value @NotNull [] valParams) throws RuntimeError;
}
