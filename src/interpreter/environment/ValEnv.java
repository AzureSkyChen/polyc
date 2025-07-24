package interpreter.environment;

import interpreter.error.RuntimeError;
import interpreter.value.Value;
import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ValEnv extends Environment<Value> {
    ValEnv(@Nullable ValEnv outerEnv) {
        super(outerEnv);
    }

    @Contract(" -> new")
    public static @NotNull ValEnv createGlobalEnv() {
        return new ValEnv(null);
    }

    @Contract("_ -> new")
    public static @NotNull ValEnv fromOuter(@NotNull ValEnv env) {
        return new ValEnv(env);
    }

    @Override
    @Contract(pure = true)
    public @NotNull Value get(@NotNull Symbol symKey) throws RuntimeError {
        try {
            return super.get(symKey);
        } catch (Exception e) {
            throw RuntimeError.SYMBOL_UNDEFINED;
        }
    }

    @Override
    @Contract(mutates = "this")
    public void put(@NotNull @Flow(targetIsContainer = true, target = "this.map") Symbol symKey,
                    @NotNull @Flow(targetIsContainer = true, target = "this.map") Value valVal) throws RuntimeError {
        try {
            super.put(symKey, valVal);
        } catch (Exception e) {
            throw RuntimeError.REDECLARATION;
        }
    }

    @Override
    @Contract(mutates = "this")
    public @NotNull Value update(@NotNull @Flow(targetIsContainer = true) Symbol symKey,
                                 @NotNull @Flow(targetIsContainer = true) Value valVal) throws RuntimeError {
        try {
            return super.update(symKey, valVal);
        } catch (Exception e) {
            throw RuntimeError.SYMBOL_UNDEFINED;
        }
    }

    @Contract("_ -> new")
    public static @NotNull ValEnv copyCurrentScopeFrom(
            @NotNull
            @Flow(sourceIsContainer = true, targetIsContainer = true) ValEnv env
    ) throws RuntimeError {
        ValEnv outerEnv = (ValEnv) env.getOuterEnv();
        ValEnv newEnv = outerEnv == null ? createGlobalEnv() : fromOuter(outerEnv);
        for (Symbol s : env.keySet()) {
            newEnv.put(s, env.get(s));
        }
        return newEnv;
    }
}
