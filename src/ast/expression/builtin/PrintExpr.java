package ast.expression.builtin;

import ast.expression.Expr;
import ast.expression.UnaryExpr;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.type.VoidType;
import interpreter.type.equality.StringType;
import interpreter.value.UnitValue;
import interpreter.value.Value;
import interpreter.value.equality.StringValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class PrintExpr extends UnaryExpr {

    public PrintExpr(@NotNull Expr expr) {
        super(expr);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        StringValue v = (StringValue) expr.eval(env).deref();
        v.implOfPrint();
        return UnitValue.UNIT;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type t = expr.typeCheck(env).deref();
        if (t instanceof StringType) {
            return VoidType.VOID;
        }
        throw TypeError.TYPE_MISMATCH;
    }
}
