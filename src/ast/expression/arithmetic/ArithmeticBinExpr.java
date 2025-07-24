package ast.expression.arithmetic;

import ast.expression.BinaryExpr;
import ast.expression.Expr;
import interpreter.error.TypeError;
import interpreter.environment.TypeEnv;
import interpreter.type.equality.IntegerType;
import interpreter.type.Type;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract sealed class ArithmeticBinExpr extends BinaryExpr permits
        AddExpr,
        BitAndExpr,
        BitOrExpr,
        BitXorExpr,
        DivExpr,
        ModExpr,
        ShiftExpr,
        SubExpr {
    protected ArithmeticBinExpr(@NotNull Expr le, @NotNull Expr re) {
        super(le, re);
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type lt = le.typeCheck(env).deref();
        Type rt = re.typeCheck(env).deref();
        if (lt instanceof IntegerType && rt instanceof IntegerType) {
            return Type.min((IntegerType) lt, (IntegerType) rt);
        }
        throw TypeError.TYPE_MISMATCH;
    }
}
