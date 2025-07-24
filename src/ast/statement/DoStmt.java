package ast.statement;

import console.Format;
import interpreter.error.RuntimeError;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.TypeError;
import interpreter.type.VoidType;
import interpreter.value.equality.IntegerValue;
import interpreter.value.UnitValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import interpreter.environment.Symbol;

public final class DoStmt extends Stmt {

    private final @NotNull LoopPair loopPair;
    private final @NotNull Stmt stmt;

    public DoStmt(@NotNull LoopPair loopPair, @NotNull Stmt stmt) {
        this.loopPair = loopPair;
        this.stmt = stmt;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull UnitValue eval(@NotNull ValEnv env) throws RuntimeError {
        IntegerValue upperBound = (IntegerValue) loopPair.eval(env).deref();
        Symbol s = loopPair.getSymbol();
        ValEnv loopEnv = ValEnv.fromOuter(env);
        loopEnv.put(s, IntegerValue.ZERO);
        IntegerValue i;
        while (true) {
            i = (IntegerValue) loopEnv.get(s);
            UnitValue val = stmt.eval(loopEnv);
            if (val == UnitValue.BREAK) {
                break;
            } else if (val.isReturnValue()) {
                return val;
            }
            loopEnv.update(s, i.implOfInc());
            if (!i.implOfLess(upperBound).toBoolean()) {
                break;
            }
        }
        return UnitValue.UNIT;
    }

    @Override
    @Contract(pure = true)
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) throws TypeError {
        TypeEnv loopEnv = TypeEnv.fromOuterToLoop(env);
        loopEnv.put(loopPair.getSymbol(), loopPair.typeCheck(env).deref());
        return stmt.typeCheck(loopEnv);
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(loopPair) +
                "\n" + Format.addIndent(stmt) +
                "\n%s</%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE);
    }
}
