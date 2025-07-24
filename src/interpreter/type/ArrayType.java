package interpreter.type;

import console.Format;
import interpreter.environment.Symbol;
import interpreter.environment.TypeEnv;
import interpreter.error.TypeError;
import interpreter.type.equality.IntegerType;
import interpreter.value.ArrayValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public sealed class ArrayType extends Type implements StringLike, Assignable, Sizeable permits
        ArrayType.IterableArrayType {
    private final @NotNull Type typeVal;

    private static final @NotNull ArrayType DUMMY_TYPE_FOR_EMPTY_ARRAY = ArrayType.fromType(VoidType.VOID);

    private ArrayType(@NotNull Type typeVal) {
        this.typeVal = typeVal;
    }

    @Contract(pure = true)
    public static @NotNull ArrayType fromEmpty() {
        return DUMMY_TYPE_FOR_EMPTY_ARRAY;
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull ArrayType fromType(@NotNull Type typeVal) {
        return new ArrayType(typeVal);
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull IterableArrayType fromTypeIterable(@NotNull Type typeVal) {
        return new IterableArrayType(typeVal);
    }

    @Override
    @Contract(pure = true)
    public ArrowType getMethodType(@NotNull Symbol methodName, @NotNull TypeEnv env) throws TypeError {
        if (methodName == Symbol.symbol("append")) {
            checkIterable(env);
            return new ArrowType(new Type[]{typeVal.getNotIterable()}, VoidType.VOID, 1);
        } else if (methodName == Symbol.symbol("pop")) {
            checkIterable(env);
            return new ArrowType(new Type[0], typeVal, 0);
        } else if (methodName == Symbol.symbol("len")) {
            if (this instanceof Iterable) {
                return new ArrowType(new Type[0], IntegerType.getIterableInstance(), 0);
            } else {
                return new ArrowType(new Type[0], IntegerType.getInstance(), 0);
            }
        } else if (methodName == Symbol.symbol("get")) {
            return new ArrowType(new Type[]{IntegerType.getInstance()}, typeVal, 1);
        } else if (methodName == Symbol.symbol("set")) {
            checkIterable(env);
            return new ArrowType(new Type[]{IntegerType.getInstance(), typeVal.getNotIterable()}, VoidType.VOID, 2);
        }
        throw TypeError.NO_SUCH_METHOD;
    }

    static final class IterableArrayType extends ArrayType implements Iterable {
        private IterableArrayType(@NotNull Type typeVal) {
            super(typeVal);
        }

        @Override
        @Contract(pure = true)
        public @NotNull Type getIterable() {
            return this;
        }

        @Override
        @Contract(pure = true)
        public @NotNull Type getNotIterable() {
            return ArrayType.fromType(getTypeVal().getNotIterable());
        }

        @Override
        @Contract(pure = true)
        public @NotNull String toString() {
            return "%s[Iterable ArrayType<%s%s%s>]%s".formatted(
                    Format.DARK_GREEN,
                    Format.NONE,
                    getTypeVal(),
                    Format.DARK_GREEN,
                    Format.NONE
            );

        }

    }

    @Contract(pure = true)
    public static boolean isIndexType(Type t) {
        return t instanceof IntegerType;
    }

    @Contract(pure = true)
    public @NotNull Type getTypeVal() {
        return typeVal;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s[ArrayType<%s%s%s>]%s".formatted(
                Format.DARK_GREEN,
                Format.NONE,
                typeVal,
                Format.DARK_GREEN,
                Format.NONE
        );
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type getIterable() {
        return ArrayType.fromTypeIterable(typeVal.getIterable());
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type getNotIterable() {
        return this;
    }

    @Override
    @Contract(pure = true)
    public boolean isAssignableFrom(@NotNull Type t) {
        if (t instanceof ArrayType that) {
            if (this == DUMMY_TYPE_FOR_EMPTY_ARRAY || that == DUMMY_TYPE_FOR_EMPTY_ARRAY) {
                return true;
            }
            if (typeVal instanceof Assignable && that.typeVal instanceof Assignable) {
                return ((Assignable) typeVal).isAssignableFrom(that.typeVal);
            }
        }
        return false;
    }

    @Override
    @Contract(pure = true)
    public boolean isValidInSpecifier() {
        return typeVal != VoidType.VOID;
    }

    @Override
    @Contract(pure = true)
    public @NotNull ArrayValue getDefault() {
        return ArrayValue.valueOfEmpty();
    }
}
