package ast.expression;

import ast.Node;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.type.VoidType;
import interpreter.value.UnitValue;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract class Expr extends Node {
    private static final @NotNull Expr EMPTY_EXPR = new Expr() {
        @Override
        @Contract(pure = true)
        public @NotNull UnitValue eval(@NotNull ValEnv env) {
            return UnitValue.UNIT;
        }

        @Override
        @Contract(pure = true)
        public @NotNull VoidType typeCheck(@NotNull TypeEnv env) {
            return VoidType.VOID;
        }
    };

    @Contract(pure = true)
    public static @NotNull Expr valueOfEmpty() {
        return EMPTY_EXPR;
    }

    @Contract(pure = true)
    public boolean isEmpty() {
        return this == EMPTY_EXPR;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        throw RuntimeError.SHOULD_NOT_HAPPEN;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        throw TypeError.SHOULD_NOT_HAPPEN;
    }
}
