package interpreter.type;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface Comparable {
    @Contract(pure = true)
    boolean isComparableWith(@NotNull Type t);
}
