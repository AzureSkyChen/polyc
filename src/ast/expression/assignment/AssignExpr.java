package ast.expression.assignment;

import ast.expression.Expr;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.Assignable;
import interpreter.type.Iterable;
import interpreter.type.RefType;
import interpreter.type.Type;
import interpreter.value.RefValue;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class AssignExpr extends AssignBaseExpr {
    public AssignExpr(@NotNull Expr le, @NotNull Expr re) {
        super(le, re);
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        RefValue rv = (RefValue) le.eval(env);
        Value v = re.eval(env).deref();
        return rv.implOfAssign(env, v);
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type typeOfId = le.typeCheck(env);
        if (!(typeOfId instanceof RefType)) {
            throw TypeError.TYPE_NOT_ASSIGNABLE;
        }
        typeOfId = typeOfId.deref();
        Type typeOfExpr = re.typeCheck(env).deref();
        if (env.iterableNotAssignable() && typeOfId instanceof Iterable) {
            throw TypeError.ITERABLE_NOT_ASSIGNABLE;
        }
        if (typeOfId instanceof Assignable && ((Assignable) typeOfId).isAssignableFrom(typeOfExpr)) {
            return RefType.valueOf(Type.min(typeOfId, typeOfExpr));
        }
        throw TypeError.TYPE_NOT_ASSIGNABLE;
    }
}
