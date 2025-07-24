package ast.expression.logical;

import ast.expression.BinaryExpr;
import ast.expression.Expr;
import interpreter.error.TypeError;
import interpreter.environment.TypeEnv;
import interpreter.type.Type;
import interpreter.type.equality.BooleanType;
import org.jetbrains.annotations.NotNull;

public abstract sealed class LogicalExpr extends BinaryExpr permits LogicalOrExpr, LogicalAndExpr {
    protected LogicalExpr(@NotNull Expr le, @NotNull Expr re) {
        super(le, re);
    }

    @Override
    public @NotNull BooleanType typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type lt = le.typeCheck(env).deref();
        Type rt = re.typeCheck(env).deref();
        if (lt instanceof BooleanType && rt instanceof BooleanType) {
            return BooleanType.getIterableInstance();
        }
        throw TypeError.TYPE_MISMATCH;
    }
}
