package ast.expression.equality;

import ast.expression.BinaryExpr;
import ast.expression.Expr;
import interpreter.error.TypeError;
import interpreter.environment.TypeEnv;
import interpreter.type.Type;
import interpreter.type.equality.BooleanType;
import interpreter.type.equality.EqualityType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract sealed class EqualityExpr extends BinaryExpr permits EqExpr, NeqExpr {
    protected EqualityExpr(@NotNull Expr le, @NotNull Expr re) {
        super(le, re);
    }

    @Override
    @Contract(pure = true)
    public @NotNull BooleanType typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type lt = le.typeCheck(env).deref();
        Type rt = re.typeCheck(env).deref();
        if (lt instanceof EqualityType && ((EqualityType) lt).isEqualTo(rt)) {
            return BooleanType.getIterableInstance();
        }
        throw TypeError.TYPE_NOT_EQUAL;
    }
}
