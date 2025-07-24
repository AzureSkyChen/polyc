package ast.expression.arithmetic;

import ast.expression.Expr;
import interpreter.environment.TypeEnv;
import interpreter.error.RuntimeError;
import interpreter.environment.ValEnv;
import interpreter.error.TypeError;
import interpreter.type.Iterable;
import interpreter.type.Type;
import interpreter.type.equality.IntegerType;
import interpreter.type.equality.StringType;
import interpreter.value.equality.IntegerValue;
import interpreter.value.Value;
import interpreter.value.equality.StringValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class AddExpr extends ArithmeticBinExpr {

    public AddExpr(@NotNull Expr le, @NotNull Expr re) {
        super(le, re);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        Value lv = le.eval(env).deref();
        Value rv = re.eval(env).deref();
        if (lv instanceof IntegerValue) {
            return ((IntegerValue) lv).implOfAdd((IntegerValue) rv);
        } else if (lv instanceof StringValue) {
            return StringValue.implOfConcat((StringValue) lv, (StringValue) rv);
        } else {
            throw RuntimeError.SHOULD_NOT_HAPPEN;
        }
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type lt = le.typeCheck(env).deref();
        Type rt = re.typeCheck(env).deref();
        if (lt instanceof IntegerType && rt instanceof IntegerType) {
            return Type.min((IntegerType) lt, (IntegerType) rt);
        }
        if (lt instanceof StringType && rt == StringType.getIterableInstance()) {
            return lt;
        }
        throw TypeError.TYPE_MISMATCH;
    }

}
