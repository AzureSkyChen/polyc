package ast.declaration.initializer;

import ast.expression.Expr;
import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.ArrayType;
import interpreter.type.Assignable;
import interpreter.type.Type;
import interpreter.value.ArrayValue;
import interpreter.value.Value;
import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class CommaInitList extends Expr {
    private final @NotNull Expr @NotNull [] exprList;

    public CommaInitList(int size) {
        this.exprList = new Expr[size];
    }

    @Contract("-> new")
    public static @NotNull CommaInitList valueOfEmpty() {
        return new CommaInitList(0);
    }

    public void add(int index, @NotNull @Flow(targetIsContainer = true, target = "this.exprList") Expr expr) {
        exprList[index] = expr;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull ArrayValue eval(@NotNull ValEnv env) throws RuntimeError {
        ArrayValue v = ArrayValue.valueOfEmpty();
        for (@NotNull Expr expr : exprList) {
            v.implOfAppend(expr.eval(env).deref());
        }
        return v;
    }

    @Contract(mutates = "param")
    public @NotNull Value @NotNull [] evalAsParams(@NotNull ValEnv env) throws RuntimeError {
        @NotNull Value @NotNull [] valParams = new Value[exprList.length];
        for (int i = 0; i < exprList.length; ++i) {
            valParams[i] = exprList[i].eval(env).deref();
        }
        return valParams;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type innerType = null;
        for (@NotNull Expr expr : exprList) {
            Type t = expr.typeCheck(env).deref();
            if (innerType == null || innerType == ArrayType.fromEmpty()) {
                innerType = t;
            } else if (!(innerType instanceof Assignable) || !((Assignable) innerType).isAssignableFrom(t)) {
                throw TypeError.ARRAY_INCONSISTENCY;
            }
        }
        if (innerType == null) {
            throw TypeError.SHOULD_NOT_HAPPEN;
        }
        return ArrayType.fromType(innerType);
    }

    @Contract(pure = true)
    public @NotNull Type @NotNull [] typeCheckAsParams(@NotNull TypeEnv env) throws TypeError {
        @NotNull Type @NotNull [] paramTypes = new Type[exprList.length];
        for (int i = 0; i < exprList.length; ++i) {
            paramTypes[i] = exprList[i].typeCheck(env).deref();
        }
        return paramTypes;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        if (exprList.length == 0) {
            return "%s<%s/>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE);
        }
        StringBuilder sb = new StringBuilder("%s<CommaInitList>%s".formatted(Format.PURPLE, Format.NONE));
        for (@NotNull Expr expr : exprList) {
            sb.append("\n").append(Format.addIndent(expr));
        }
        sb.append("\n%s</CommaInitList>%s".formatted(Format.PURPLE, Format.NONE));
        return sb.toString();
    }
}
