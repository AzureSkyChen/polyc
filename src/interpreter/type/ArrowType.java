package interpreter.type;

import console.Format;
import interpreter.error.TypeError;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class ArrowType extends Type {
    private final @NotNull Type @NotNull [] paramTypes;
    private final @NotNull Type returnType;
    private final int leastParamCnt;

    public ArrowType(@NotNull Type @NotNull [] paramTypes, @NotNull Type returnType, int cnt) {
        this.paramTypes = paramTypes;
        this.returnType = returnType;
        this.leastParamCnt = cnt;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        StringBuilder sb = new StringBuilder("%s(ArrowType:[%s".formatted(Format.RED, Format.NONE));
        for (int i = 0; i < paramTypes.length; ++i) {
            if (i != 0) {
                sb.append("%s, %s".formatted(Format.RED, Format.NONE));
            }
            sb.append(paramTypes[i]);
        }
        if (paramTypes.length == 0) {
            sb.append(VoidType.VOID);
        }
        sb.append("%s]->%s".formatted(Format.RED, Format.NONE)).append(returnType).append("%s)%s".formatted(Format.RED, Format.NONE));
        return sb.toString();
    }

    @Override
    public boolean isInvalidInEnv() {
        for (@NotNull Type t : paramTypes) {
            if (!t.isValidInSpecifier() || t instanceof VoidType) {
                return true;
            }
        }
        return !returnType.isValidInSpecifier();
    }

    @Override
    public boolean isValidInSpecifier() {
        return false;
    }

    @Contract(pure = true)
    public void match(@NotNull Type @NotNull [] types) throws TypeError {
        if (types.length > paramTypes.length || types.length < leastParamCnt) {
            throw TypeError.PARAMETER_CNT_ERROR;
        }
        for (int i = 0; i < types.length; ++i) {
            Type t = types[i];
            Type declType = paramTypes[i];
            if (declType instanceof Assignable at && at.isAssignableFrom(t) && Type.ge(t, declType)) {
                continue;
            }
            throw TypeError.INVOCATION_ERROR;
        }
    }

    @Contract(pure = true)
    public @NotNull Type getReturnType() {
        return returnType;
    }
}
