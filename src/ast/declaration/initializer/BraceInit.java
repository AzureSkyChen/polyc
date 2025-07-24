package ast.declaration.initializer;

import ast.expression.Expr;
import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.DictType;
import interpreter.type.Type;
import interpreter.value.DictValue;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class BraceInit extends Expr {
    private final @NotNull Expr colonInitList;

    private static final @NotNull BraceInit EMPTY_BRACE_INIT = new BraceInit(Expr.valueOfEmpty());

    private BraceInit(@NotNull Expr colonInitList) {
        this.colonInitList = colonInitList;
    }

    public static @NotNull BraceInit from(@NotNull ColonInitList colonInitList) {
        return new BraceInit(colonInitList);
    }

    @Contract(pure = true)
    public static @NotNull BraceInit fromEmpty() {
        return EMPTY_BRACE_INIT;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        if (colonInitList.isEmpty()) {
            return DictValue.valueOfEmpty();
        }
        return colonInitList.eval(env);
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        if (colonInitList.isEmpty()) {
            return DictType.fromEmpty();
        }
        return colonInitList.typeCheck(env);
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        if (colonInitList.isEmpty()) {
            return "%s<EmptyDict%s/>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE);
        }
        return "%s<%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(colonInitList) +
                "\n%s</%s>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE);
    }
}
