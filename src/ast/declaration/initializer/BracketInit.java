package ast.declaration.initializer;

import ast.expression.Expr;
import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.ArrayType;
import interpreter.type.Type;
import interpreter.value.ArrayValue;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class BracketInit extends Expr {
    private final @NotNull Expr initList;

    private static final @NotNull BracketInit EMPTY_BRACKET_INIT = new BracketInit(Expr.valueOfEmpty());

    private BracketInit(@NotNull Expr expr) {
        this.initList = expr;
    }

    @Contract(pure = true)
    public static @NotNull BracketInit fromEmpty() {
        return EMPTY_BRACKET_INIT;
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull BracketInit from(@NotNull CommaInitList expr) {
        return new BracketInit(expr);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        if (initList.isEmpty()) {
            return ArrayValue.valueOfEmpty();
        }
        return initList.eval(env);
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        if (initList.isEmpty()) {
            return ArrayType.fromEmpty();
        }
        return initList.typeCheck(env);
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        if (initList.isEmpty()) {
            return "%s<EmptyList/>%s".formatted(Format.PURPLE, Format.NONE);
        }
        return "%s<%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(initList) +
                "\n%s</%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE);
    }
}
