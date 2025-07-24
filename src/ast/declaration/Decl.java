package ast.declaration;

import ast.Node;

public abstract sealed class Decl extends Node permits EmptyDecl, FuncDecl,  Program, SimpleDecl {
}
