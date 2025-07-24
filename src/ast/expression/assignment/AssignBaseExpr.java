package ast.expression.assignment;

import ast.expression.BinaryExpr;
import ast.expression.Expr;
import interpreter.error.TypeError;
import interpreter.environment.TypeEnv;
import interpreter.type.Iterable;
import interpreter.type.RefType;
import interpreter.type.Type;
import interpreter.type.equality.IntegerType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract sealed class AssignBaseExpr extends BinaryExpr permits
        AssignExpr,
        BitAndAssignExpr,
        BitOrAssignExpr,
        BitXorAssignExpr,
        DivAssignExpr,
        MinusAssignExpr,
        ModAssignExpr,
        PlusAssignExpr,
        ShiftAssignExpr {
    protected AssignBaseExpr(@NotNull Expr le, @NotNull Expr re) {
        super(le, re);
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type typeOfId = le.typeCheck(env);
        if (!(typeOfId instanceof RefType)) {
            throw TypeError.TYPE_NOT_ASSIGNABLE;
        }
        Type typeOfExpr = re.typeCheck(env).deref();
        if (env.iterableNotAssignable() && typeOfId.deref() instanceof Iterable) {
            throw TypeError.ITERABLE_NOT_ASSIGNABLE;
        }
        if (typeOfId.deref() instanceof IntegerType && typeOfExpr instanceof IntegerType) {
            return RefType.valueOf(Type.min((IntegerType) typeOfId.deref(), (IntegerType) typeOfExpr));
        }
        throw TypeError.TYPE_MISMATCH;
    }
}
