package interpreter.value;

import interpreter.type.Type;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface Constable {
    @NotNull
    @Contract(pure = true)
    Type getType();
}
