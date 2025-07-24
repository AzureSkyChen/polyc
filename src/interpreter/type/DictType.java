package interpreter.type;

import console.Format;
import interpreter.environment.Symbol;
import interpreter.environment.TypeEnv;
import interpreter.error.TypeError;
import interpreter.type.equality.BooleanType;
import interpreter.value.DictValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public sealed class DictType extends Type implements StringLike, Assignable, Sizeable permits
        DictType.IterableDictType {
    private final @NotNull Type typeKey;
    private final @NotNull Type typeVal;

    private static final @NotNull DictType DUMMY_TYPE_FOR_EMPTY_DICT = DictType.fromType(VoidType.VOID, VoidType.VOID);

    @Contract(pure = true)
    public static @NotNull DictType fromEmpty() {
        return DUMMY_TYPE_FOR_EMPTY_DICT;
    }

    private DictType(@NotNull Type typeKey, @NotNull Type typeVal) {
        this.typeKey = typeKey;
        this.typeVal = typeVal;
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull DictType fromType(@NotNull Type typeKey, @NotNull Type typeVal) {
        return new DictType(typeKey, typeVal);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull IterableDictType fromTypeIterable(@NotNull Type typeKey, @NotNull Type typeVal) {
        return new IterableDictType(typeKey, typeVal);
    }

    @Override
    @Contract(pure = true)
    public ArrowType getMethodType(@NotNull Symbol methodName, @NotNull TypeEnv env) throws TypeError {
        if (methodName == Symbol.symbol("get")) {
            return new ArrowType(new Type[]{typeKey}, typeVal, 1);
        } else if (methodName == Symbol.symbol("put")) {
            checkIterable(env);
            return new ArrowType(new Type[]{typeKey, typeVal}, VoidType.VOID, 2);
        } else if (methodName == Symbol.symbol("remove")) {
            checkIterable(env);
            return new ArrowType(new Type[]{typeVal.getNotIterable()}, typeVal, 1);
        } else if (methodName == Symbol.symbol("isEmpty")) {
            return new ArrowType(new Type[0], BooleanType.getIterableInstance(), 0);
        } else if (methodName == Symbol.symbol("containsKey")) {
            return new ArrowType(new Type[]{typeKey.getNotIterable()}, BooleanType.getIterableInstance(), 1);
        }
        throw TypeError.NO_SUCH_METHOD;
    }

    static final class IterableDictType extends DictType implements Iterable {
        private IterableDictType(@NotNull Type typeKey, @NotNull Type typeVal) {
            super(typeKey, typeVal);
        }

        @Override
        @Contract(pure = true)
        public @NotNull Type getIterable() {
            return this;
        }

        @Override
        @Contract(pure = true)
        public @NotNull Type getNotIterable() {
            return DictType.fromType(getTypeKey().getNotIterable(), getTypeVal().getNotIterable());
        }

        @Override
        @Contract(pure = true)
        public @NotNull String toString() {
            return "%s[Iterable DictType<%s%s,%s%s>]%s".formatted(
                    Format.BLUE,
                    Format.NONE,
                    getTypeKey(),
                    getTypeVal(),
                    Format.BLUE,
                    Format.NONE
            );
        }
    }

    @Contract(pure = true)
    public @NotNull Type getTypeKey() {
        return typeKey;
    }

    @Contract(pure = true)
    public @NotNull Type getTypeVal() {
        return typeVal;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s[DictType<%s%s,%s%s>]%s".formatted(
                Format.BLUE,
                Format.NONE,
                typeKey,
                typeVal,
                Format.BLUE,
                Format.NONE
        );
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type getIterable() {
        return DictType.fromTypeIterable(typeKey.getIterable(), typeVal.getIterable());
    }

    @Override
    @Contract(pure = true)
    public @NotNull Type getNotIterable() {
        return this;
    }

    @Override
    @Contract(pure = true)
    public boolean isAssignableFrom(@NotNull Type t) {
        if (t instanceof DictType that) {
            if (this == DUMMY_TYPE_FOR_EMPTY_DICT) {
                return true;
            }
            if (typeKey instanceof Assignable && that.typeKey instanceof Assignable) {
                if (((Assignable) typeKey).isAssignableFrom(that.typeKey)) {
                    if (typeVal instanceof Assignable && that.typeVal instanceof Assignable) {
                        return ((Assignable) typeVal).isAssignableFrom(that.typeVal);
                    }
                }
            } else {
                return that == DUMMY_TYPE_FOR_EMPTY_DICT;
            }
        }
        return false;
    }

    @Contract(pure = true)
    public DictType isAssignableFrom(@NotNull Type typeKey_, @NotNull Type typeVal_) throws TypeError {
        if (this == DUMMY_TYPE_FOR_EMPTY_DICT) {
            return fromType(typeKey_, typeVal_);
        }
        if (typeKey instanceof Assignable && typeKey_ instanceof Assignable) {
            if (((Assignable) typeKey).isAssignableFrom(typeKey_)) {
                if (typeVal == DUMMY_TYPE_FOR_EMPTY_DICT) {
                    return fromType(typeKey_, typeVal_);
                }
                if (typeVal instanceof Assignable && typeVal_ instanceof Assignable) {
                    if (((Assignable) typeVal).isAssignableFrom(typeVal_)) {
                        return this;
                    }
                }
            }
        }
        throw TypeError.DICT_INCONSISTENCY;
    }

    @Contract(pure = true)
    public boolean isIndexType(@NotNull Type typeKey_) throws TypeError {
        if (this == DUMMY_TYPE_FOR_EMPTY_DICT) {
            throw TypeError.SHOULD_NOT_HAPPEN;
        }
        if (typeKey instanceof Assignable && typeKey_ instanceof Assignable) {
            return ((Assignable) typeKey).isAssignableFrom(typeKey_);
        }
        return false;
    }

    @Override
    @Contract(pure = true)
    public boolean isValidInSpecifier() {
        return !(typeKey instanceof DictType) && !(typeKey instanceof ArrayType) &&
                typeKey != VoidType.VOID && typeVal != VoidType.VOID;
    }

    @Override
    @Contract(pure = true)
    public @NotNull DictValue getDefault() {
        return DictValue.valueOfEmpty();
    }
}
