package ast.declaration.declarator;

import ast.Node;
import console.Format;
import interpreter.environment.TypeEnv;
import interpreter.environment.ValEnv;
import interpreter.error.RuntimeError;
import interpreter.error.TypeError;
import interpreter.type.Type;
import interpreter.value.Value;
import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class InitDeclaratorList extends Node {

    private final @NotNull Declarator @NotNull [] declarators;

    public InitDeclaratorList(int size) {
        this.declarators = new Declarator[size];
    }

    public void add(int index,
                    @NotNull @Flow(targetIsContainer = true, target = "this.declarators") Declarator initDeclarator) {
        declarators[index] = initDeclarator;
    }

    @Contract(mutates = "param2")
    public void evalFor(@NotNull Value defaultVal, @NotNull ValEnv env) throws RuntimeError {
        for (@NotNull Declarator declarator : declarators) {
            declarator.evalFor(defaultVal, env);
        }
    }

    @Contract(mutates = "param2")
    public void typeCheckFor(@NotNull Type declType, @NotNull TypeEnv env) throws TypeError {
        for (@NotNull Declarator declarator : declarators) {
            declarator.typeCheckFor(declType, env);
        }
    }

    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        StringBuilder sb = new StringBuilder("%s<%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE));
        for (Declarator initDeclarator : declarators) {
            sb.append("\n").append(Format.addIndent(initDeclarator));
        }
        sb.append("\n%s</%s>%s".formatted(Format.YELLOW, getClass().getSimpleName(), Format.NONE));
        return sb.toString();
    }
}
