package ast.statement;

import ast.expression.Expr;
import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.VoidType;
import interpreter.value.UnitValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class ReturnStmt extends Stmt {
    private final @NotNull Expr expr;

    private static final ReturnStmt EMPTY_RETURN_STMT = new ReturnStmt(Expr.valueOfEmpty());

    public ReturnStmt(@NotNull Expr expr) {
        this.expr = expr;
    }

    @Contract(pure = true)
    public static @NotNull ReturnStmt valueOfEmpty() {
        return EMPTY_RETURN_STMT;
    }

    @Override
    public @NotNull UnitValue eval(@NotNull ValEnv env) throws RuntimeError {
        return UnitValue.from(expr.eval(env).deref());
    }

    @Override
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) throws TypeError {
        if (env.isInsideFunction()) {
            return VoidType.from(expr.typeCheck(env).deref());
        }
        throw TypeError.CONTINUE_BREAK_RETURN_ERROR;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(expr) +
                "\n%s</%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE);
    }
}
