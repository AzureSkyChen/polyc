package interpreter.type;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface Assignable {
    @Contract(pure = true)
    boolean isAssignableFrom(@NotNull Type t);
}
