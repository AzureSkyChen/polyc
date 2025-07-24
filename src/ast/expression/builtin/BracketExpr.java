package ast.expression.builtin;

import ast.expression.BinaryExpr;
import ast.expression.Expr;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.ArrayType;
import interpreter.type.DictType;
import interpreter.type.RefType;
import interpreter.type.Type;
import interpreter.type.equality.IntegerType;
import interpreter.type.equality.StringType;
import interpreter.value.RefValue;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class BracketExpr extends BinaryExpr {

    public BracketExpr(@NotNull Expr le, @NotNull Expr re) {
        super(le, re);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        RefValue rv = (RefValue) le.eval(env);
        Value index = re.eval(env).deref();
        return rv.implOfIndexing(index);
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type lt = le.typeCheck(env).deref();
        Type rt = re.typeCheck(env).deref();
        if (lt instanceof ArrayType arrayType && ArrayType.isIndexType(rt)) {
            return RefType.valueOf(arrayType.getTypeVal());
        } else if (lt instanceof DictType dictType && dictType.isIndexType(rt)) {
            return RefType.valueOf(dictType.getTypeVal());
        } else if (lt instanceof StringType && rt instanceof IntegerType) {
            return StringType.getIterableInstance();
        }
        throw TypeError.TYPE_MISMATCH;
    }
}
