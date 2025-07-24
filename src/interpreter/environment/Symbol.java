package interpreter.environment;

import console.Format;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public final class Symbol {
    private final @NotNull String name;
    private static final Map<String, Symbol> SYMBOLS = new HashMap<>();

    private Symbol(@NotNull String name) {
        this.name = name;
    }

    @Contract(pure = true)
    public static @NotNull Symbol symbol(@NotNull String name) {
        if (Symbol.SYMBOLS.containsKey(name)) {
            return Symbol.SYMBOLS.get(name);
        }
        Symbol s = new Symbol(name);
        Symbol.SYMBOLS.put(name, s);
        return s;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s(Symbol:%s)%s".formatted(Format.GREEN_BACK, this.name, Format.NONE);
    }
}
