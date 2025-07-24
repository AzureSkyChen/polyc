package interpreter.environment;

import console.Format;
import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract sealed class Environment<T> permits TypeEnv, ValEnv {
    private final @NotNull Map<@NotNull Symbol, @NotNull T> map = new HashMap<>();
    private final @Nullable Environment<@NotNull T> outerEnv;

    protected Environment(@Nullable Environment<T> outerEnv) {
        this.outerEnv = outerEnv;
    }

    @Contract(pure = true)
    public @Nullable Environment<T> getOuterEnv() {
        return outerEnv;
    }

    @Contract(pure = true)
    @Flow(sourceIsContainer = true, source = "this.map")
    public @NotNull T get(@NotNull Symbol symKey) throws Exception {
        if (map.containsKey(symKey)) {
            return map.get(symKey);
        } else if (outerEnv != null) {
            return outerEnv.get(symKey);
        }
        throw new Exception();
    }

    @Contract(mutates = "this")
    public void put(@NotNull @Flow(targetIsContainer = true, target = "this.map") Symbol symKey,
                    @NotNull @Flow(targetIsContainer = true, target = "this.map") T tVal) throws Exception {
        if (map.containsKey(symKey)) {
            throw new Exception();
        }
        map.put(symKey, tVal);
    }

    @Contract(mutates = "this")
    public T update(@NotNull @Flow(targetIsContainer = true) Symbol symKey,
                    @NotNull @Flow(targetIsContainer = true) T tVal) throws Exception {
        Environment<T> envPointer = this;
        while (envPointer != null) {
            if (envPointer.map.containsKey(symKey)) {
                return envPointer.map.put(symKey, tVal);
            }
            envPointer = envPointer.outerEnv;
        }
        throw new Exception();
    }

    @Contract(pure = true)
    public boolean containsKey(@NotNull Symbol symKey) {
        if (map.containsKey(symKey)) {
            return true;
        }
        return outerEnv != null && outerEnv.containsKey(symKey);
    }

    @Contract(pure = true)
    public @NotNull Set<Symbol> keySet() {
        return map.keySet();
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        Environment<T> envPointer = this;
        String result = "";
        while (envPointer != null) {
            StringBuilder sb = new StringBuilder(getClass().getSimpleName()).append("{");
            for (Symbol s : envPointer.map.keySet()) {
                sb.append("\n\t").append(s).append("=").append(envPointer.map.get(s));
            }
            if (!result.equals("")) {
                sb.append("\n").append(Format.addIndent(result));
            }
            sb.append("\n}");
            result = sb.toString();
            envPointer = envPointer.outerEnv;
        }
        return result;
    }
}
