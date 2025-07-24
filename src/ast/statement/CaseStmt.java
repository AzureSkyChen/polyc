package ast.statement;

import ast.expression.Expr;
import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.type.VoidType;
import interpreter.type.equality.EqualityType;
import interpreter.value.UnitValue;
import interpreter.value.Value;
import interpreter.value.equality.BooleanValue;
import interpreter.value.equality.EqualityValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class CaseStmt extends Stmt {
    private final @NotNull Expr expr;
    private final @NotNull Stmt stmt;

    public CaseStmt(@NotNull Expr exp, @NotNull Stmt stmt) {
        this.expr = exp;
        this.stmt = stmt;
    }

    @Contract(mutates = "this, param")
    public @NotNull Value getLabelVal(ValEnv env) throws RuntimeError {
        return expr.eval(env).deref();
    }

    @Override
    @Contract(value = "_ -> fail", mutates = "param")
    public @NotNull UnitValue eval(@NotNull ValEnv env) throws RuntimeError {
        return stmt.eval(env);
    }

    @Override
    @Contract(value = "_ -> fail", mutates = "this")
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) throws TypeError {
        throw TypeError.CASE_ERROR;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(expr) +
                "\n" + Format.addIndent(stmt) +
                "\n%s</%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE);
    }

    @Override
    @Contract(mutates = "this, param")
    public @NotNull UnitValue evalSwitch(@NotNull ValEnv env, @NotNull Value valLabel) throws RuntimeError {
        Value label = expr.eval(env).deref();
        if (!(label instanceof EqualityValue)) {
            throw RuntimeError.SHOULD_NOT_HAPPEN;
        }
        BooleanValue b = ((EqualityValue) label).implOfEq(valLabel);
        if (b.toBoolean()) {
            return eval(env);
        }
        return UnitValue.UNIT;
    }

    @Override
    @Contract(pure = true)
    public @NotNull VoidType checkSwitch(@NotNull TypeEnv env, @NotNull Type typeLabel) throws TypeError {
        Type t = expr.typeCheck(env).deref();
        if (t instanceof EqualityType equalityType && equalityType.isEqualTo(typeLabel)) {
            return stmt.typeCheck(env);
        }
        throw TypeError.TYPE_MISMATCH;
    }
}
