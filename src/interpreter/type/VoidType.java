package interpreter.type;

import console.Format;
import interpreter.error.TypeError;
import interpreter.value.UnitValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class VoidType extends Type {
    private VoidType() {
    }

    public static final @NotNull VoidType VOID = new VoidType() {
        @Override
        @Contract(pure = true)
        public @NotNull String toString() {
            return "%s(VoidType)%s".formatted(Format.BLACK, Format.NONE);
        }
    };

    private static class ReturnType extends VoidType {
        private final @NotNull Assignable type;

        private ReturnType(@NotNull Assignable type) {
            this.type = type;
        }

        @Contract(pure = true)
        public @NotNull Assignable getType() {
            return type;
        }

        @Override
        @Contract(pure = true)
        public @NotNull String toString() {
            return "%s(Return:%s%s%s)%s".formatted(Format.BLACK, Format.NONE, type, Format.BLACK, Format.NONE);
        }
    }

    @Contract("_ -> new")
    public static @NotNull VoidType from(Type t) throws TypeError {
        if (t == VOID) {
            return VOID;
        }
        if (t instanceof Assignable) {
            return new ReturnType((Assignable) t);
        }
        throw TypeError.SHOULD_NOT_HAPPEN;
    }

    @Contract(pure = true)
    public static @NotNull Type mergeReturnType(@NotNull VoidType returnType, @NotNull Type declType) throws TypeError {
        if (returnType == VOID) {
            if (declType == VOID) {
                return VOID;
            }
        } else if (returnType instanceof ReturnType) {
            Assignable innerType = ((ReturnType) returnType).type;
            if (innerType.isAssignableFrom(declType) && Type.ge(innerType, declType)) {
                return declType;
            }
        }
        throw TypeError.RETURN_ERROR;
    }

    @Contract(pure = true)
    public static @NotNull VoidType merge(VoidType t1, VoidType t2) throws TypeError {
        if (t1 == VOID) {
            return t2;
        }
        if (t2 == VOID) {
            return t1;
        }
        if (t1 instanceof ReturnType && t2 instanceof ReturnType) {
            Assignable rt1 = ((ReturnType) t1).getType();
            Assignable rt2 = ((ReturnType) t2).getType();
            if (rt2 instanceof Type && rt1.isAssignableFrom((Type) rt2)) {
                return t1;
            }
        }
        throw TypeError.TYPE_MISMATCH;
    }

    @Override
    @Contract(pure = true)
    public boolean isValidInSpecifier() {
        return this == VOID;
    }

    @Override
    public boolean isInvalidInEnv() {
        return true;
    }

    @Override
    @Contract(pure = true)
    public @NotNull UnitValue getDefault() {
        return UnitValue.UNIT;
    }
}
