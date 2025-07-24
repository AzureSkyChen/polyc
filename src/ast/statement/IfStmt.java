package ast.statement;

import ast.expression.Expr;
import console.Format;
import interpreter.error.RuntimeError;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.type.VoidType;
import interpreter.type.equality.BooleanType;
import interpreter.value.UnitValue;
import interpreter.value.equality.BooleanValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class IfStmt extends Stmt {

    private final @NotNull Expr condition;
    private final @NotNull Stmt thenStmt;
    private final @NotNull Stmt elseStmt;

    private IfStmt(@NotNull Expr condition, @NotNull Stmt thenStmt, @NotNull Stmt elseStmt) {
        this.condition = condition;
        this.thenStmt = thenStmt;
        this.elseStmt = elseStmt;
    }

    @Contract("_, _, _ -> new")
    public static @NotNull IfStmt fromThenElse(@NotNull Expr condition, @NotNull Stmt thenStmt, @NotNull Stmt elseStmt) {
        return new IfStmt(condition, thenStmt, elseStmt);
    }

    @Contract("_, _ -> new")
    public static @NotNull IfStmt fromThen(@NotNull Expr condition, @NotNull Stmt thenStmt) {
        return new IfStmt(condition, thenStmt, EmptyStmt.getInstance());
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull UnitValue eval(@NotNull ValEnv env) throws RuntimeError {
        BooleanValue b = (BooleanValue) condition.eval(env).deref();
        if (b.toBoolean()) {
            return thenStmt.eval(env);
        } else {
            return elseStmt.eval(env);
        }
    }

    @Override
    @Contract(pure = true)
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type t = condition.typeCheck(env).deref();
        if (t instanceof BooleanType) {
            VoidType thenType = thenStmt.typeCheck(TypeEnv.fromOuter(env));
            VoidType elseType = elseStmt.typeCheck(TypeEnv.fromOuter(env));
            return VoidType.merge(thenType, elseType);
        }
        throw TypeError.TYPE_MISMATCH;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(condition) +
                "\n" + Format.addIndent(thenStmt) +
                "\n" + Format.addIndent(elseStmt) +
                "\n%s</%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE);
    }
}
