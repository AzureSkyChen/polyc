package interpreter.value;

import interpreter.value.equality.BooleanValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface Comparable<T> {
    @Contract(pure = true)
    @NotNull BooleanValue implOfGreater(@NotNull T valRHS);

    @Contract(pure = true)
    @NotNull BooleanValue implOfLess(@NotNull T valRHS);

    @Contract(pure = true)
    @NotNull BooleanValue implOfGreaterEq(@NotNull T valRHS);

    @Contract(pure = true)
    @NotNull BooleanValue implOfLessEq(@NotNull T valRHS);
}
