package ast.statement;

import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.type.VoidType;
import interpreter.value.UnitValue;
import interpreter.value.Value;
import interpreter.value.equality.BooleanValue;
import interpreter.value.equality.EqualityValue;
import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class SeqStmt extends Stmt {

    private final @NotNull Stmt @NotNull [] stmtList;

    public SeqStmt(int size) {
        this.stmtList = new Stmt[size];
    }

    @Contract(mutates = "this")
    public void addStmt(int index, @NotNull @Flow(targetIsContainer = true, target = "this.stmtList") Stmt stmt) {
        stmtList[index] = stmt;
    }

    @Override
    public @NotNull UnitValue eval(@NotNull ValEnv env) throws RuntimeError {
        for (Stmt stmt : stmtList) {
            UnitValue val = stmt.eval(env);
            if (val != UnitValue.UNIT) {
                return val;
            }
        }
        return UnitValue.UNIT;
    }

    @Override
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) throws TypeError {
        VoidType type = VoidType.VOID;
        for (@NotNull Stmt stmt : stmtList) {
            type = VoidType.merge(type, stmt.typeCheck(env));
        }
        return type;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        StringBuilder sb = new StringBuilder("%s<SeqStmt>%s".formatted(Format.YELLOW, Format.NONE));
        for (@NotNull Stmt stmt : stmtList) {
            sb.append("\n").append(Format.addIndent(stmt));
        }
        sb.append("\n%s</SeqStmt>%s".formatted(Format.YELLOW, Format.NONE));
        return sb.toString();
    }

    @Override
    @Contract(mutates = "param1")
    public @NotNull UnitValue evalSwitch(@NotNull ValEnv env, @NotNull Value valLabel) throws RuntimeError {
        boolean matched = false;
        for (@NotNull Stmt stmt : stmtList) {
            if (!matched) {
                if (stmt instanceof CaseStmt caseStmt) {
                    BooleanValue b = ((EqualityValue) caseStmt.getLabelVal(env)).implOfEq(valLabel);
                    if (b.toBoolean()) {
                        matched = true;
                    }
                } else if (stmt instanceof DefaultStmt) {
                    matched = true;
                }
            }
            if (matched) {
                UnitValue val = stmt.eval(env);
                if (val == UnitValue.CONTINUE) {
                    throw RuntimeError.SHOULD_NOT_HAPPEN;
                } else if (val != UnitValue.UNIT) {
                    return val;
                }
            }
        }
        return UnitValue.UNIT;
    }

    @Override
    @Contract(pure = true)
    public @NotNull VoidType checkSwitch(@NotNull TypeEnv env, @NotNull Type typeLabel) throws TypeError {
        VoidType res = VoidType.VOID;
        for (@NotNull Stmt stmt : stmtList) {
            res = VoidType.merge(res, stmt.checkSwitch(env, typeLabel));
        }
        return res;
    }
}
