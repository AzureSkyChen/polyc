package ast.declaration;

import ast.declaration.declarator.DeclSpec;
import ast.declaration.declarator.InitDeclaratorList;
import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.type.VoidType;
import interpreter.value.UnitValue;
import interpreter.value.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class SimpleDecl extends Decl {
    private final @NotNull DeclSpec declSpec;
    private final @NotNull InitDeclaratorList initDeclaratorList;

    public SimpleDecl(@NotNull DeclSpec declSpec, @NotNull InitDeclaratorList initDeclaratorList) {
        this.declSpec = declSpec;
        this.initDeclaratorList = initDeclaratorList;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull UnitValue eval(@NotNull ValEnv env) throws RuntimeError {
        Value defaultVal = declSpec.eval(env);
        initDeclaratorList.evalFor(defaultVal, env);
        return UnitValue.UNIT;
    }

    @Override
    @Contract(mutates = "param")
    public @NotNull VoidType typeCheck(@NotNull TypeEnv env) throws TypeError {
        Type declType = declSpec.typeCheck(env);
        initDeclaratorList.typeCheckFor(declType, env);
        return VoidType.VOID;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "%s<%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE) +
                "\n" + Format.addIndent(declSpec) +
                "\n" + Format.addIndent(initDeclaratorList) +
                "\n%s</%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE);
    }
}
