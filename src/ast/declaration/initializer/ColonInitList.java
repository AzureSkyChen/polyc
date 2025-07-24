package ast.declaration.initializer;

import ast.expression.Expr;
import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.DictType;
import interpreter.type.Type;
import interpreter.value.DictValue;
import interpreter.value.Value;
import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class ColonInitList extends Expr {
    private final @NotNull Expr @NotNull [] exprKeySet;
    private final @NotNull Expr @NotNull [] exprValSet;

    public ColonInitList(int size) {
        this.exprKeySet = new Expr[size];
        this.exprValSet = new Expr[size];
    }

    public void put(int index,
                    @NotNull @Flow(targetIsContainer = true, target = "this.exprKeySet") Expr exprKey,
                    @NotNull @Flow(targetIsContainer = true, target = "this.exprValSet") Expr exprVal) {
        exprKeySet[index] = exprKey;
        exprValSet[index] = exprVal;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull Value eval(@NotNull ValEnv env) throws RuntimeError {
        DictValue v = DictValue.valueOfEmpty();
        for (int i = 0; i < exprValSet.length; ++i) {
            v.implOfPut(exprKeySet[i].eval(env).deref(), exprValSet[i].eval(env).deref());
        }
        return v;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type typeCheck(@NotNull TypeEnv env) throws TypeError {
        DictType typeResult = null;
        for (int i = 0; i < exprKeySet.length; ++i) {
            Type typeKey = exprKeySet[i].typeCheck(env).deref();
            Type typeVal = exprValSet[i].typeCheck(env).deref();
            if (typeResult == null) {
                typeResult = DictType.fromType(typeKey, typeVal);
            } else {
                typeResult = typeResult.isAssignableFrom(typeKey, typeVal);
            }
        }
        if (typeResult == null) {
            throw TypeError.SHOULD_NOT_HAPPEN;
        }
        return typeResult;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        StringBuilder sb = new StringBuilder("%s<ColonInitList>%s".formatted(Format.PURPLE, Format.NONE));
        for (int i = 0; i < exprKeySet.length; ++i) {
            sb.append("\n\t%s<Pair>%s".formatted(Format.PURPLE, Format.NONE));
            sb.append("\n\t").append(Format.addIndent(exprKeySet[i]));
            sb.append("\n\t").append(Format.addIndent(exprValSet[i]));
            sb.append("\n\t%s</Pair>%s".formatted(Format.PURPLE, Format.NONE));
        }
        sb.append("\n%s</ColonInitList>%s".formatted(Format.PURPLE, Format.NONE));
        return sb.toString();
    }
}
