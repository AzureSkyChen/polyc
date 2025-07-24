package interpreter;

import ast.Node;
import ast.declaration.*;
import ast.declaration.declarator.DeclSpec;
import ast.declaration.declarator.Declarator;
import ast.declaration.declarator.InitDeclarator;
import ast.declaration.declarator.InitDeclaratorList;
import ast.declaration.initializer.*;
import ast.declaration.parameter.ParamDecl;
import ast.declaration.parameter.ParamList;
import ast.expression.*;
import ast.expression.arithmetic.*;
import ast.expression.builtin.BracketExpr;
import ast.expression.builtin.DotExpr;
import ast.expression.builtin.SizeExpr;
import ast.expression.logical.LogicalAndExpr;
import ast.expression.logical.LogicalOrExpr;
import ast.expression.terminal.ConstantExpr;
import ast.expression.terminal.IdExpr;
import ast.operator.binary.BinaryOperator;
import ast.operator.Operator;
import ast.operator.unary.UnaryOperator;
import ast.statement.*;
import interpreter.environment.Symbol;
import interpreter.type.ArrayType;
import interpreter.type.DictType;
import interpreter.type.VoidType;
import interpreter.type.equality.BooleanType;
import interpreter.type.equality.IntegerType;
import interpreter.type.equality.StringType;
import interpreter.value.equality.BooleanValue;
import interpreter.value.equality.IntegerValue;
import interpreter.value.equality.StringValue;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.intellij.lang.annotations.Identifier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import parser.PolyCParserParser;
import parser.PolyCParserVisitor;

import java.util.Objects;

public final class PolyCVisitor extends AbstractParseTreeVisitor<Node> implements PolyCParserVisitor<Node> {

    @Override
    @Contract(pure = true)
    public @NotNull Node visitParse(@NotNull PolyCParserParser.ParseContext ctx) {
        if (ctx.program() != null) {
            return visit(ctx.program());
        }
        return Program.valueOfEmpty();
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitPrimaryExpression(@NotNull PolyCParserParser.PrimaryExpressionContext ctx) {
        if (ctx.expression() != null) {
            return new ParenExpr((Expr) visit(ctx.expression()));
        } else if (ctx.constant() != null) {
            return visit(ctx.constant());
        } else if (ctx.Identifier() != null) {
            return new IdExpr(Symbol.symbol(ctx.getText()));
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitPostfixExpression(@NotNull PolyCParserParser.PostfixExpressionContext ctx) {
        if (ctx.LeftBracket() != null) {
            return new BracketExpr((Expr) visit(ctx.postfixExpression()), (Expr) visit(ctx.expression()));
        } else if (ctx.PlusPlus() != null) {
            return new PlusPlusExpr((Expr) visit(ctx.postfixExpression()));
        } else if (ctx.MinusMinus() != null) {
            return new MinusMinusExpr((Expr) visit(ctx.postfixExpression()));
        } else if (ctx.primaryExpression() != null) {
            return visit(ctx.primaryExpression());
        } else if (ctx.LeftParen() != null) {
            if (ctx.initializerList() == null) {
                return new ApplyExpr((Expr) visit(ctx.postfixExpression()));
            }
            return new ApplyExpr((Expr) visit(ctx.postfixExpression()), (CommaInitList) visit(ctx.initializerList()));
        } else if (ctx.Dot() != null) {
            return new DotExpr((Expr) visit(ctx.postfixExpression()), Symbol.symbol(ctx.Identifier().getText()));
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitUnaryExpression(@NotNull PolyCParserParser.UnaryExpressionContext ctx) {
        if (ctx.unaryOperator() != null) {
            UnaryOperator op = (UnaryOperator) visit(ctx.unaryOperator());
            return op.applyTo((Expr) visit(ctx.unaryExpression()));
        } else if (ctx.LeftParen() != null) {
            UnaryOperator op = (UnaryOperator) visit(ctx.functionOperator());
            return op.applyTo((Expr) visit(ctx.assignmentExpression()));
        } else if (ctx.postfixExpression() != null) {
            return visit(ctx.postfixExpression());
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitUnaryOperator(@NotNull PolyCParserParser.UnaryOperatorContext ctx) {
        return Operator.fromOpName(ctx.getText());
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitFunctionOperator(@NotNull PolyCParserParser.FunctionOperatorContext ctx) {
        return Operator.fromOpName(ctx.getText());
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitMultiplicativeExpression(@NotNull PolyCParserParser.MultiplicativeExpressionContext ctx) {
        if (ctx.unaryExpression() != null) {
            Expr unaryExpr = (Expr) visit(ctx.unaryExpression());
            if (ctx.multiplicativeExpression() != null) {
                Expr multiExpr = (Expr) visit(ctx.multiplicativeExpression());
                if (ctx.Div() != null) {
                    return new DivExpr(multiExpr, unaryExpr);
                } else if (ctx.Mod() != null) {
                    return new ModExpr(multiExpr, unaryExpr);
                }
                return null;
            } else {
                return unaryExpr;
            }
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitAdditiveExpression(@NotNull PolyCParserParser.AdditiveExpressionContext ctx) {
        if (ctx.multiplicativeExpression() != null) {
            Expr multiExpr = (Expr) visit(ctx.multiplicativeExpression());
            if (ctx.additiveExpression() != null) {
                Expr addExpr = (Expr) visit(ctx.additiveExpression());
                if (ctx.Plus() != null) {
                    return new AddExpr(addExpr, multiExpr);
                } else if (ctx.Minus() != null) {
                    return new SubExpr(addExpr, multiExpr);
                }
                return null;
            }
            return multiExpr;
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitShiftExpression(@NotNull PolyCParserParser.ShiftExpressionContext ctx) {
        if (ctx.Greater().size() != 0) {
            return new ShiftExpr((Expr) visit(ctx.shiftExpression()), (Expr) visit(ctx.additiveExpression()));
        } else if (ctx.additiveExpression() != null) {
            return visit(ctx.additiveExpression());
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitRelationExpression(@NotNull PolyCParserParser.RelationExpressionContext ctx) {
        if (ctx.relationOperator() != null) {
            BinaryOperator op = (BinaryOperator) visit(ctx.relationOperator());
            return op.applyTo((Expr) visit(ctx.relationExpression()), (Expr) visit(ctx.shiftExpression()));
        } else if (ctx.shiftExpression() != null) {
            return visit(ctx.shiftExpression());
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitRelationOperator(@NotNull PolyCParserParser.RelationOperatorContext ctx) {
        return Operator.fromOpName(ctx.getText());
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitEqualityExpression(@NotNull PolyCParserParser.EqualityExpressionContext ctx) {
        if (ctx.equalityOperator() != null) {
            BinaryOperator op = (BinaryOperator) visit(ctx.equalityOperator());
            Expr le = (Expr) visit(ctx.equalityExpression());
            Expr re = (Expr) visit(ctx.relationExpression());
            return op.applyTo(le, re);
        } else if (ctx.relationExpression() != null) {
            return visit(ctx.relationExpression());
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitEqualityOperator(@NotNull PolyCParserParser.EqualityOperatorContext ctx) {
        return Operator.fromOpName(ctx.getText());
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitAndExpression(@NotNull PolyCParserParser.AndExpressionContext ctx) {
        Expr expr = null;
        for (@NotNull PolyCParserParser.EqualityExpressionContext c : ctx.equalityExpression()) {
            if (expr == null) {
                expr = (Expr) visit(c);
            } else {
                expr = new BitAndExpr(expr, (Expr) visit(c));
            }
        }
        return expr;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitXorExpression(@NotNull PolyCParserParser.XorExpressionContext ctx) {
        Expr expr = null;
        for (@NotNull PolyCParserParser.AndExpressionContext c : ctx.andExpression()) {
            if (expr == null) {
                expr = (Expr) visit(c);
            } else {
                expr = new BitXorExpr(expr, (Expr) visit(c));
            }
        }
        return expr;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitOrExpression(@NotNull PolyCParserParser.OrExpressionContext ctx) {
        Expr expr = null;
        for (@NotNull PolyCParserParser.XorExpressionContext c : ctx.xorExpression()) {
            if (expr == null) {
                expr = (Expr) visit(c);
            } else {
                expr = new BitOrExpr(expr, (Expr) visit(c));
            }
        }
        return expr;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitLogicalAndExpression(@NotNull PolyCParserParser.LogicalAndExpressionContext ctx) {
        Expr expr = null;
        for (@NotNull PolyCParserParser.OrExpressionContext c : ctx.orExpression()) {
            if (expr == null) {
                expr = (Expr) visit(c);
            } else {
                expr = new LogicalAndExpr(expr, (Expr) visit(c));
            }
        }
        return expr;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitLogicalOrExpression(@NotNull PolyCParserParser.LogicalOrExpressionContext ctx) {
        Expr expr = null;
        for (@NotNull PolyCParserParser.LogicalAndExpressionContext c : ctx.logicalAndExpression()) {
            if (expr == null) {
                expr = (Expr) visit(c);
            } else {
                expr = new LogicalOrExpr(expr, (Expr) visit(c));
            }
        }
        return expr;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitConditionalExpression(@NotNull PolyCParserParser.ConditionalExpressionContext ctx) {
        if (ctx.Question() != null) {
            Expr cond = (Expr) visit(ctx.logicalOrExpression());
            Expr le = (Expr) visit(ctx.expression(0));
            Expr re = (Expr) visit(ctx.expression(1));
            return new QuestionExpr(cond, le, re);
        } else if (ctx.logicalOrExpression() != null) {
            return visit(ctx.logicalOrExpression());
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitAssignmentExpression(@NotNull PolyCParserParser.AssignmentExpressionContext ctx) {
        if (ctx.conditionalExpression() != null) {
            return visit(ctx.conditionalExpression());
        } else if (ctx.assignmentOperator() != null) {
            BinaryOperator op = (BinaryOperator) visit(ctx.assignmentOperator());
            Expr le = (Expr) visit(ctx.logicalOrExpression());
            Expr re = (Expr) visit(ctx.assignmentExpression());
            return op.applyTo(le, re);
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitAssignmentOperator(@NotNull PolyCParserParser.AssignmentOperatorContext ctx) {
        return Operator.fromOpName(ctx.getText());
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitExpression(@NotNull PolyCParserParser.ExpressionContext ctx) {
        if (ctx.assignmentExpression().size() == 1) {
            return visit(ctx.assignmentExpression(0));
        }
        int cntOfExpr = ctx.assignmentExpression().size();
        CommaExpr commaExpr = new CommaExpr(cntOfExpr);
        for (int i = 0; i < cntOfExpr; ++i) {
            commaExpr.addExpr(i, (Expr) visit(ctx.assignmentExpression(i)));
        }
        return commaExpr;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitConstantExpression(@NotNull PolyCParserParser.ConstantExpressionContext ctx) {
        return visit(ctx.conditionalExpression());
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitStatement(@NotNull PolyCParserParser.StatementContext ctx) {
        if (ctx.labeledStatement() != null) {
            return visit(ctx.labeledStatement());
        } else if (ctx.declarationStatement() != null) {
            return visit(ctx.declarationStatement());
        } else if (ctx.expressionStatement() != null) {
            return visit(ctx.expressionStatement());
        } else if (ctx.blockStatement() != null) {
            return visit(ctx.blockStatement());
        } else if (ctx.ifStatement() != null) {
            return visit(ctx.ifStatement());
        } else if (ctx.loopStatement() != null) {
            return visit(ctx.loopStatement());
        } else if (ctx.jumpStatement() != null) {
            return visit(ctx.jumpStatement());
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitLabeledStatement(@NotNull PolyCParserParser.LabeledStatementContext ctx) {
        if (ctx.statement() != null) {
            Stmt stmt = (Stmt) visit(ctx.statement());
            if (ctx.Case() != null) {
                return new CaseStmt((Expr) visit(ctx.constantExpression()), stmt);
            } else if (ctx.Default() != null) {
                return new DefaultStmt(stmt);
            }
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitDeclarationStatement(@NotNull PolyCParserParser.DeclarationStatementContext ctx) {
        return new DeclStmt((Decl) visit(ctx.simpleDeclaration()));
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitExpressionStatement(@NotNull PolyCParserParser.ExpressionStatementContext ctx) {
        if (ctx.expression() != null) {
            return new ExprStmt((Expr) visit(ctx.expression()));
        }
        return EmptyStmt.getInstance();
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitBlockStatement(@NotNull PolyCParserParser.BlockStatementContext ctx) {
        if (ctx.LeftBrace() != null) {
            if (ctx.sequentialStatement() != null) {
                return new BlockStmt((Stmt) visit(ctx.sequentialStatement()));
            }
            return new BlockStmt(EmptyStmt.getInstance());
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitSequentialStatement(@NotNull PolyCParserParser.SequentialStatementContext ctx) {
        if (ctx.statement().size() == 1) {
            return visit(ctx.statement(0));
        }
        int size = ctx.statement().size();
        SeqStmt seqStmt = new SeqStmt(size);
        for (int i = 0; i < size; ++i) {
            seqStmt.addStmt(i, (Stmt) visit(ctx.statement(i)));
        }
        return seqStmt;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitIfStatement(@NotNull PolyCParserParser.IfStatementContext ctx) {
        if (ctx.If() != null) {
            if (ctx.statement().size() == 2) {
                Expr condition = (Expr) visit(ctx.condition());
                Stmt thenStmt = (Stmt) visit(ctx.statement(0));
                Stmt elseStmt = (Stmt) visit(ctx.statement(1));
                return IfStmt.fromThenElse(condition, thenStmt, elseStmt);
            } else if (ctx.statement().size() == 1) {
                Expr condition = (Expr) visit(ctx.condition());
                Stmt thenStmt = (Stmt) visit(ctx.statement(0));
                return IfStmt.fromThen(condition, thenStmt);
            }
            return null;
        } else if (ctx.Switch() != null) {
            if (ctx.statement().size() == 1) {
                return new SwitchStmt((Expr) visit(ctx.condition()), (Stmt) visit(ctx.statement(0)));
            }
            return null;
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitCondition(@NotNull PolyCParserParser.ConditionContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitLoopStatement(@NotNull PolyCParserParser.LoopStatementContext ctx) {
        if (ctx.While() != null) {
            if (ctx.Do() == null) {
                return new WhileStmt((LoopPair) visit(ctx.loopSpecifier()), (Stmt) visit(ctx.statement()));
            } else {
                return new DoStmt((LoopPair) visit(ctx.loopSpecifier()), (Stmt) visit(ctx.statement()));
            }
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitLoopSpecifier(@NotNull PolyCParserParser.LoopSpecifierContext ctx) {
        if (ctx.expression() != null) {
            Expr upperBound = new SizeExpr((Expr) visit(ctx.expression()));
            return new LoopPair(Symbol.symbol(ctx.Identifier().getText()), upperBound);
        } else if (ctx.IntegerConstant() != null) {
            IntegerValue integerValue = IntegerValue.valueOf(ctx.IntegerConstant().getText());
            return new LoopPair(Symbol.symbol(ctx.Identifier().getText()), new ConstantExpr(integerValue));
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitJumpStatement(@NotNull PolyCParserParser.JumpStatementContext ctx) {
        if (ctx.Break() != null) {
            return BreakStmt.getInstance();
        } else if (ctx.Continue() != null) {
            return ContinueStmt.getInstance();
        } else if (ctx.Return() != null) {
            if (ctx.expression() != null) {
                return new ReturnStmt((Expr) visit(ctx.expression()));
            }
            return ReturnStmt.valueOfEmpty();
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitDeclaration(@NotNull PolyCParserParser.DeclarationContext ctx) {
        if (ctx.simpleDeclaration() != null) {
            return visit(ctx.simpleDeclaration());
        } else if (ctx.functionDeclaration() != null) {
            return visit(ctx.functionDeclaration());
        } else if (ctx.emptyDeclaration() != null) {
            return visit(ctx.emptyDeclaration());
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitSimpleDeclaration(@NotNull PolyCParserParser.SimpleDeclarationContext ctx) {
        DeclSpec declSpec = (DeclSpec) visit(ctx.declSpecifier());
        InitDeclaratorList initDeclaratorList = (InitDeclaratorList) visit(ctx.initDeclaratorList());
        return new SimpleDecl(declSpec, initDeclaratorList);
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitDeclSpecifier(@NotNull PolyCParserParser.DeclSpecifierContext ctx) {
        if (ctx.typeSpecifier() != null) {
            DeclSpec declSpec = (DeclSpec) visit(ctx.typeSpecifier());
            if (ctx.Iterable() != null) {
                return declSpec.toIterable();
            } else {
                return declSpec;
            }
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitTypeSpecifier(@NotNull PolyCParserParser.TypeSpecifierContext ctx) {
        if (ctx.Int() != null) {
            return new DeclSpec(IntegerType.getInstance());
        } else if (ctx.Boolean() != null) {
            return new DeclSpec(BooleanType.getInstance());
        } else if (ctx.String() != null) {
            return new DeclSpec(StringType.getInstance());
        } else if (ctx.Void() != null) {
            return new DeclSpec(VoidType.VOID);
        } else if (ctx.Array() != null && ctx.typeSpecifier().size() == 1) {
            DeclSpec inner = (DeclSpec) visit(ctx.typeSpecifier(0));
            if (inner != null) {
                return new DeclSpec(ArrayType.fromType(inner.getType()));
            } else {
                return null;
            }
        } else if (ctx.Dict() != null && ctx.typeSpecifier().size() == 2) {
            DeclSpec typeKey = (DeclSpec) visit(ctx.typeSpecifier(0));
            DeclSpec typeVal = (DeclSpec) visit(ctx.typeSpecifier(1));
            return new DeclSpec(DictType.fromType(typeKey.getType(), typeVal.getType()));
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitInitDeclaratorList(@NotNull PolyCParserParser.InitDeclaratorListContext ctx) {
        int size = ctx.initDeclarator().size();
        InitDeclaratorList initDeclaratorList = new InitDeclaratorList(size);
        for (int i = 0; i < size; ++i) {
            initDeclaratorList.add(i, (Declarator) visit(ctx.initDeclarator(i)));
        }
        return initDeclaratorList;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitInitDeclarator(@NotNull PolyCParserParser.InitDeclaratorContext ctx) {
        Declarator declarator = (Declarator) visitDeclarator(ctx.declarator());
        assert declarator != null;
        if (ctx.initializer() != null) {
            return new InitDeclarator(declarator.getSymbol(), (Initializer) visit(ctx.initializer()));
        }
        return declarator;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitDeclarator(@NotNull PolyCParserParser.DeclaratorContext ctx) {
        if (ctx.Identifier() != null) {
            return new Declarator(Symbol.symbol(ctx.Identifier().getText()));
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitInitializer(@NotNull PolyCParserParser.InitializerContext ctx) {
        if (ctx.initializerClause() != null) {
            return new Initializer((Expr) visit(ctx.initializerClause()));
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitInitializerClause(@NotNull PolyCParserParser.InitializerClauseContext ctx) {
        if (ctx.assignmentExpression() != null) {
            return visit(ctx.assignmentExpression());
        } else if (ctx.braceInitList() != null) {
            return visit(ctx.braceInitList());
        } else if (ctx.bracketInitList() != null) {
            return visit(ctx.bracketInitList());
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitBracketInitList(@NotNull PolyCParserParser.BracketInitListContext ctx) {
        if (ctx.initializerList() != null) {
            return BracketInit.from((CommaInitList) visit(ctx.initializerList()));
        }
        return BracketInit.fromEmpty();
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitInitializerList(@NotNull PolyCParserParser.InitializerListContext ctx) {
        int size = ctx.initializerClause().size();
        CommaInitList initList = new CommaInitList(size);
        for (int i = 0; i < size; ++i) {
            initList.add(i, (Expr) visit(ctx.initializerClause(i)));
        }
        return initList;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitBraceInitList(@NotNull PolyCParserParser.BraceInitListContext ctx) {
        if (ctx.colonInitializerList() != null) {
            return BraceInit.from((ColonInitList) visit(ctx.colonInitializerList()));
        }
        return BraceInit.fromEmpty();
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitColonInitializerList(@NotNull PolyCParserParser.ColonInitializerListContext ctx) {
        int size = ctx.assignmentExpression().size();
        ColonInitList colonInitList = new ColonInitList(size);
        for (int i = 0; i < size; ++i) {
            Expr exprKey = (Expr) visit(ctx.assignmentExpression(i));
            Expr exprVal = (Expr) visit(ctx.initializerClause(i));
            colonInitList.put(i, exprKey, exprVal);
        }
        return colonInitList;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitFunctionDeclaration(@NotNull PolyCParserParser.FunctionDeclarationContext ctx) {
        if (ctx.parameterList() != null) {
            return new FuncDecl((DeclSpec) visit(ctx.declSpecifier()), (Declarator) visit(ctx.declarator()),
                    (ParamList) visit(ctx.parameterList()), (BlockStmt) visit(ctx.functionBody()));
        }
        return new FuncDecl((DeclSpec) visit(ctx.declSpecifier()), (Declarator) visit(ctx.declarator()),
                ParamList.valueOfEmpty(), (BlockStmt) visit(ctx.functionBody()));
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitParameterList(@NotNull PolyCParserParser.ParameterListContext ctx) {
        int size = ctx.parameterDeclaration().size();
        ParamList paramList = new ParamList(size);
        for (int i = 0; i < size; ++i) {
            paramList.addParamDecl(i, (ParamDecl) visit(ctx.parameterDeclaration(i)));
        }
        return paramList;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitParameterDeclaration(@NotNull PolyCParserParser.ParameterDeclarationContext ctx) {
        if (ctx.declSpecifier() != null) {
            if (ctx.assignmentExpression() != null) {
                return ParamDecl.from((DeclSpec) visit(ctx.declSpecifier()),
                        (Declarator) visit(ctx.declarator()),
                        (Expr) visit(ctx.assignmentExpression()));
            } else {
                return ParamDecl.from((DeclSpec) visit(ctx.declSpecifier()),
                        (Declarator) visit(ctx.declarator()));
            }
        }
        return null;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitFunctionBody(@NotNull PolyCParserParser.FunctionBodyContext ctx) {
        return visit(ctx.blockStatement());
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitEmptyDeclaration(@NotNull PolyCParserParser.EmptyDeclarationContext ctx) {
        return EmptyDecl.getInstance();
    }

    @Override
    @Contract(pure = true)
    public @NotNull Node visitProgram(@NotNull PolyCParserParser.ProgramContext ctx) {
        int size = ctx.declaration().size();
        Program program = new Program(size);
        for (int i = 0; i < size; ++i) {
            program.add(i, (Decl) visit(ctx.declaration(i)));
        }
        return program;
    }

    @Override
    @Contract(pure = true)
    public @Nullable Node visitConstant(@NotNull PolyCParserParser.ConstantContext ctx) {
        String text = ctx.getText();
        if (ctx.IntegerConstant() != null) {
            if (text.charAt(0) == '0') {
                if (text.length() == 1) {
                    return new ConstantExpr(IntegerValue.valueOf(0));
                }
                return new ConstantExpr(IntegerValue.valueOfBinary(text));
            }
            return new ConstantExpr(IntegerValue.valueOf(text));
        } else if (ctx.BooleanConstant() != null) {
            return new ConstantExpr(BooleanValue.valueOf(text));
        } else if (ctx.StringConstant() != null) {
            return new ConstantExpr(StringValue.valueOfQuotation(text.translateEscapes()));
        };
        return null;
    }
}
