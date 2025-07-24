package ast.declaration;

import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.type.VoidType;
import interpreter.value.UnitValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class EmptyDecl extends Decl {
    private static final EmptyDecl EMPTY_DECL = new EmptyDecl();

    @Contract(pure = true)
    public static @NotNull EmptyDecl getInstance(){
        return EMPTY_DECL;
    }

    @Override
    @Contract(pure = true)
    public @NotNull UnitValue eval(@NotNull ValEnv env) {
        return UnitValue.UNIT;
    }

    @Override
    @Contract(pure = true)
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) {
        return VoidType.VOID;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s/>%s".formatted(Format.PURPLE, getClass().getSimpleName(), Format.NONE);
    }
}
