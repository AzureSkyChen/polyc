// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PolyCParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PolyCParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(PolyCParserParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(PolyCParserParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(PolyCParserParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(PolyCParserParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(PolyCParserParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#functionOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionOperator(PolyCParserParser.FunctionOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(PolyCParserParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(PolyCParserParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(PolyCParserParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#relationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationExpression(PolyCParserParser.RelationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#relationOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationOperator(PolyCParserParser.RelationOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(PolyCParserParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#equalityOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityOperator(PolyCParserParser.EqualityOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(PolyCParserParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#xorExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXorExpression(PolyCParserParser.XorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(PolyCParserParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(PolyCParserParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(PolyCParserParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(PolyCParserParser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(PolyCParserParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(PolyCParserParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PolyCParserParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(PolyCParserParser.ConstantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PolyCParserParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#labeledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatement(PolyCParserParser.LabeledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#declarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationStatement(PolyCParserParser.DeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(PolyCParserParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(PolyCParserParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#sequentialStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequentialStatement(PolyCParserParser.SequentialStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(PolyCParserParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(PolyCParserParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(PolyCParserParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#loopSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopSpecifier(PolyCParserParser.LoopSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatement(PolyCParserParser.JumpStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(PolyCParserParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#simpleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleDeclaration(PolyCParserParser.SimpleDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#declSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclSpecifier(PolyCParserParser.DeclSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#typeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecifier(PolyCParserParser.TypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclaratorList(PolyCParserParser.InitDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#initDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclarator(PolyCParserParser.InitDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarator(PolyCParserParser.DeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(PolyCParserParser.InitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#initializerClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerClause(PolyCParserParser.InitializerClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#bracketInitList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketInitList(PolyCParserParser.BracketInitListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#initializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerList(PolyCParserParser.InitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#braceInitList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBraceInitList(PolyCParserParser.BraceInitListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#colonInitializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColonInitializerList(PolyCParserParser.ColonInitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(PolyCParserParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(PolyCParserParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(PolyCParserParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(PolyCParserParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#emptyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyDeclaration(PolyCParserParser.EmptyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PolyCParserParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolyCParserParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(PolyCParserParser.ConstantContext ctx);
}