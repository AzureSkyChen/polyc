package ast.statement;

import ast.expression.Expr;
import console.Format;
import interpreter.error.RuntimeError;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.TypeError;
import interpreter.type.VoidType;
import interpreter.value.UnitValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class ExprStmt extends Stmt {
    private final @NotNull Expr expr;

    public ExprStmt(@NotNull Expr expr) {
        this.expr = expr;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull UnitValue eval(@NotNull ValEnv env) throws RuntimeError {
        expr.eval(env).deref();
        return UnitValue.UNIT;
    }

    @Override
    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Contract(pure = true)
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) throws TypeError {
        expr.typeCheck(env).deref();
        return VoidType.VOID;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(expr) +
                "\n%s</%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE);
    }
}
