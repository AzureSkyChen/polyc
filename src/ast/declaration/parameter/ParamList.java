package ast.declaration.parameter;

import ast.expression.Expr;
import console.Format;
import interpreter.environment.Symbol;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.type.equality.IntegerType;
import interpreter.value.Value;
import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ParamList extends Expr {
    private final @NotNull ParamDecl @NotNull [] paramList;

    public ParamList(int size) {
        this.paramList = new ParamDecl[size];
    }

    private static final ParamList EMPTY_PARAM_LIST = new ParamList(0) {
        @Override
        public String toString() {
            return "%s<EmptyParamList/>%s".formatted(Format.PURPLE, Format.NONE);
        }
    };

    @Contract(pure = true)
    public static @NotNull ParamList valueOfEmpty() {
        return EMPTY_PARAM_LIST;
    }

    public void addParamDecl(int index,
                             @NotNull @Flow(targetIsContainer = true, target = "this.paramList") ParamDecl paramDecl) {
        paramList[index] = paramDecl;
    }

    public @NotNull Symbol @NotNull [] evalAsParams(@NotNull ValEnv env) throws RuntimeError {
        final @NotNull Symbol @NotNull [] symbols = new Symbol[paramList.length];
        final @NotNull Value @NotNull [] values = new Value[paramList.length];
        for (int i = 0; i < paramList.length; ++i) {
            symbols[i] = paramList[i].getSymbol();
            values[i] = paramList[i].eval(env).deref();
        }
        for (int i = 0; i < paramList.length; ++i) {
            env.put(symbols[i], values[i]);
        }
        return symbols;
    }

    @Contract(mutates = "param")
    public @NotNull Type @NotNull [] typeCheckAsParams(@NotNull TypeEnv env) throws TypeError {
        final @NotNull Symbol @NotNull [] symbols = new Symbol[paramList.length];
        final @NotNull Type @NotNull [] types = new Type[paramList.length];
        for (int i = 0; i < paramList.length; ++i) {
            symbols[i] = paramList[i].getSymbol();
            types[i] = paramList[i].typeCheck(env).deref();
            if (env.isMain() && types[i] != IntegerType.getInstance()) {
                throw TypeError.TYPE_MISMATCH;
            }
        }
        for (int i = 0; i < paramList.length; ++i) {
            env.put(symbols[i], types[i]);
        }
        return types;
    }

    public int cntOfDeclWithoutDefault() throws TypeError {
        int cnt = 0;
        boolean hasDefaultValue = false;
        for (@NotNull ParamDecl paramDecl : paramList) {
            if (hasDefaultValue && !paramDecl.hasDefaultValue()) {
                throw TypeError.PARAMETER_ERROR;
            }
            if (paramDecl.hasDefaultValue()) {
                hasDefaultValue = true;
            } else {
                cnt += 1;
            }
        }
        return cnt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("%s<ParamList>%s".formatted(Format.PURPLE, Format.NONE));
        for (@NotNull ParamDecl d : paramList) {
            sb.append("\n").append(Format.addIndent(d));
        }
        sb.append("\n%s</ParamList>%s".formatted(Format.PURPLE, Format.NONE));
        return sb.toString();
    }
}
