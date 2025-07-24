package ast;

import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract class Node {
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        throw RuntimeError.SHOULD_NOT_HAPPEN;
    }

    @Contract(mutates = "param")
    public @NotNull Type typeCheck(TypeEnv env) throws TypeError {
        throw TypeError.SHOULD_NOT_HAPPEN;
    }
}
