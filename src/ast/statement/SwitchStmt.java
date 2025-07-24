package ast.statement;

import ast.expression.Expr;
import console.Format;
import interpreter.error.RuntimeError;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.type.VoidType;
import interpreter.type.equality.EqualityType;
import interpreter.value.UnitValue;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class SwitchStmt extends Stmt {

    private final @NotNull Expr condition;
    private final @NotNull Stmt stmt;

    public SwitchStmt(@NotNull Expr condition, @NotNull Stmt stmt) {
        this.condition = condition;
        this.stmt = stmt;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull UnitValue eval(@NotNull ValEnv env) throws RuntimeError {
        Value valLabel = condition.eval(env).deref();
        UnitValue val = stmt.evalSwitch(env, valLabel);
        if (val.isReturnValue()) {
            return val;
        }
        return UnitValue.UNIT;
    }

    @Override
    @Contract(pure = true)
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type valType = condition.typeCheck(env).deref();
        if (valType instanceof EqualityType) {
            return stmt.checkSwitch(TypeEnv.fromOuterToSwitch(env), valType);
        }
        throw TypeError.TYPE_NOT_EQUAL;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(condition) +
                "\n" + Format.addIndent(stmt) +
                "\n%s</%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE);
    }
}
