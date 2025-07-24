package interpreter.value;

import ast.statement.Stmt;
import console.Format;
import interpreter.environment.Symbol;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class FuncValue extends Value implements Callable {
    private final @NotNull Stmt body;
    private final @NotNull ValEnv capturedEnv;
    private final @NotNull Symbol @NotNull [] symDecls;

    public FuncValue(@NotNull Symbol @NotNull [] symDecls, @NotNull Stmt body, @NotNull ValEnv env) {
        this.body = body;
        this.symDecls = symDecls;
        this.capturedEnv = env;
    }

    @Override
    public @NotNull Value implOfApply(@NotNull Value @NotNull [] valParams) throws RuntimeError {
        ValEnv bodyEnv = ValEnv.copyCurrentScopeFrom(capturedEnv);
        for (int i = 0; i < valParams.length; ++i) {
            bodyEnv.update(symDecls[i], valParams[i]);
        }
        UnitValue returnVal = body.eval(bodyEnv);
        return returnVal.getReturnValue();
    }

    @Contract(pure = true)
    public int getParamCnt() {
        return symDecls.length;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s(Func)%s".formatted(Format.RED, Format.NONE);
    }
}
