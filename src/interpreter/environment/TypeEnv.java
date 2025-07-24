package interpreter.environment;

import interpreter.error.TypeError;
import interpreter.type.Assignable;
import interpreter.type.Iterable;
import interpreter.type.Type;
import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeEnv extends Environment<Type> {

    private final boolean insideLoop;
    private final boolean insideSwitch;
    private final boolean insideFunction;
    private final boolean isMain;

    TypeEnv(@Nullable TypeEnv outerEnv, boolean insideLoop, boolean insideSwitch, boolean insideFunction, boolean isMain) {
        super(outerEnv);
        this.insideLoop = insideLoop;
        this.insideSwitch = insideSwitch;
        this.insideFunction = insideFunction;
        this.isMain = isMain;
    }

    @Contract("_ -> new")
    public static @NotNull TypeEnv fromOuter(@NotNull TypeEnv env) {
        return new TypeEnv(env, env.insideLoop, env.insideSwitch, env.insideFunction, env.isMain);
    }

    @Contract("_ -> new")
    public static @NotNull TypeEnv fromOuterToLoop(@NotNull TypeEnv env) {
        return new TypeEnv(env, true, env.insideSwitch, env.insideFunction, env.isMain);
    }

    @Contract("_ -> new")
    public static @NotNull TypeEnv fromOuterToSwitch(@NotNull TypeEnv env) {
        return new TypeEnv(env, env.insideLoop, true, env.insideFunction, env.isMain);
    }

    @Contract("_ -> new")
    public static @NotNull TypeEnv fromOuterToFunction(@NotNull TypeEnv env) {
        return new TypeEnv(env, env.insideLoop, env.insideSwitch, true, env.isMain);
    }

    @Contract("_ -> new")
    public static @NotNull TypeEnv fromOuterToMain(@NotNull TypeEnv env) {
        return new TypeEnv(env, env.insideLoop, env.insideSwitch, true, true);
    }

    @Contract(" -> new")
    public static @NotNull TypeEnv createGlobalTypeEnv() {
        return new TypeEnv(null, false, false, false, false);
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type get(@NotNull Symbol symKey) throws TypeError {
        try {
            return super.get(symKey);
        } catch (Exception e) {
            throw TypeError.SYMBOL_UNDEFINED;
        }
    }

    @Contract(mutates = "this")
    public void putAndCheck(@NotNull @Flow(targetIsContainer = true, target = "this.map") Symbol symKey,
                            @NotNull @Flow(targetIsContainer = true, target = "this.map") Type typeVal) throws TypeError {
        if (typeVal instanceof Iterable && iterableNotAssignable()) {
            throw TypeError.ITERABLE_NOT_ASSIGNABLE;
        }
        put(symKey, typeVal);
    }

    @Override
    @Contract(mutates = "this")
    public void put(@NotNull @Flow(targetIsContainer = true, target = "this.map") Symbol symKey,
                    @NotNull @Flow(targetIsContainer = true, target = "this.map") Type typeVal) throws TypeError {
        if (typeVal.isInvalidInEnv()) {
            throw TypeError.INVALID_TYPE;
        }
        try {
            super.put(symKey, typeVal);
        } catch (Exception e) {
            throw TypeError.REDECLARATION;
        }
    }

    @Override
    public @NotNull Type update(@NotNull Symbol symKey, @NotNull Type typeVal) throws TypeError {
        if (typeVal.isInvalidInEnv()) {
            throw TypeError.INVALID_TYPE;
        }
        if (typeVal instanceof Iterable && iterableNotAssignable()) {
            throw TypeError.ITERABLE_NOT_ASSIGNABLE;
        }
        Type t = get(symKey);
        if (t instanceof Assignable assignable && assignable.isAssignableFrom(typeVal)) {
            return t;
        }
        throw TypeError.TYPE_MISMATCH;
    }

    @Contract(pure = true)
    public boolean isInsideLoop() {
        return insideLoop;
    }

    @Contract(pure = true)
    public boolean isInsideSwitch() {
        return insideSwitch;
    }

    @Contract(pure = true)
    public boolean isInsideFunction() {
        return insideFunction;
    }

    @Contract(pure = true)
    public boolean isMain() {
        return isMain;
    }

    @Contract(pure = true)
    public boolean iterableNotAssignable() {
        return insideLoop || insideFunction && !isMain;
    }
}
