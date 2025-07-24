package ast.statement;

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

public abstract sealed class Stmt extends Node permits
        BlockStmt,
        BreakStmt,
        CaseStmt,
        ContinueStmt,
        DeclStmt,
        DefaultStmt,
        DoStmt,
        EmptyStmt,
        ExprStmt,
        IfStmt,
        SeqStmt,
        SwitchStmt,
        WhileStmt,
        ReturnStmt {
    @Override
    @Contract(mutates = "param")
    public abstract @NotNull UnitValue eval(@NotNull ValEnv env) throws RuntimeError;

    @Override
    @Contract(pure = true)
    public abstract @NotNull VoidType typeCheck(@NotNull TypeEnv env) throws TypeError;

    @Contract(mutates = "param1")
    public @NotNull UnitValue evalSwitch(@NotNull ValEnv env, @NotNull Value valLabel) throws RuntimeError {
        return UnitValue.UNIT;
    }

    @Contract(pure = true)
    public @NotNull VoidType checkSwitch(@NotNull TypeEnv env, @NotNull Type typeLabel) throws TypeError {
        return typeCheck(env);
    }
}
