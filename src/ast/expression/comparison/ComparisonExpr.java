package ast.expression.comparison;

import ast.expression.BinaryExpr;
import ast.expression.Expr;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.type.equality.BooleanType;
import interpreter.type.Comparable;
import interpreter.type.Type;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract sealed class ComparisonExpr extends BinaryExpr permits
        GreatEqExpr,
        GreatExpr,
        LessEqExpr,
        LessExpr {
    protected ComparisonExpr(@NotNull Expr le, @NotNull Expr re) {
        super(le, re);
    }

    @Override
    @Contract(pure = true)
    public @NotNull BooleanType typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type lt = le.typeCheck(env).deref();
        Type rt = re.typeCheck(env).deref();
        if (lt instanceof Comparable && ((Comparable) lt).isComparableWith(rt)) {
            return BooleanType.getIterableInstance();
        }
        throw TypeError.TYPE_NOT_COMPARABLE;
    }

    protected static final class CastUtils {
        @Contract(mutates = "param2")
        @SuppressWarnings("unchecked")
        public static <T> @NotNull T castEval(@NotNull Expr expr, @NotNull ValEnv env) throws RuntimeError {
            return (T) expr.eval(env).deref();
        }
    }
}
