package ast.statement;

import ast.declaration.Decl;
import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.VoidType;
import interpreter.value.UnitValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class DeclStmt extends Stmt {
    private final @NotNull Decl decl;

    public DeclStmt(@NotNull Decl decl) {
        this.decl = decl;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull UnitValue eval(@NotNull ValEnv env) throws RuntimeError {
        decl.eval(env);
        return UnitValue.UNIT;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) throws TypeError {
        decl.typeCheck(env);
        return VoidType.VOID;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(decl) +
                "\n%s</%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE);
    }
}
