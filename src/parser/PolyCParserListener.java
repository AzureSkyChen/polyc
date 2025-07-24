// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PolyCParserParser}.
 */
public interface PolyCParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(PolyCParserParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(PolyCParserParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(PolyCParserParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(PolyCParserParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(PolyCParserParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(PolyCParserParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(PolyCParserParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(PolyCParserParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(PolyCParserParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(PolyCParserParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#functionOperator}.
	 * @param ctx the parse tree
	 */
	void enterFunctionOperator(PolyCParserParser.FunctionOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#functionOperator}.
	 * @param ctx the parse tree
	 */
	void exitFunctionOperator(PolyCParserParser.FunctionOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(PolyCParserParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(PolyCParserParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(PolyCParserParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(PolyCParserParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(PolyCParserParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(PolyCParserParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#relationExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationExpression(PolyCParserParser.RelationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#relationExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationExpression(PolyCParserParser.RelationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#relationOperator}.
	 * @param ctx the parse tree
	 */
	void enterRelationOperator(PolyCParserParser.RelationOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#relationOperator}.
	 * @param ctx the parse tree
	 */
	void exitRelationOperator(PolyCParserParser.RelationOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(PolyCParserParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(PolyCParserParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#equalityOperator}.
	 * @param ctx the parse tree
	 */
	void enterEqualityOperator(PolyCParserParser.EqualityOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#equalityOperator}.
	 * @param ctx the parse tree
	 */
	void exitEqualityOperator(PolyCParserParser.EqualityOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(PolyCParserParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(PolyCParserParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#xorExpression}.
	 * @param ctx the parse tree
	 */
	void enterXorExpression(PolyCParserParser.XorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#xorExpression}.
	 * @param ctx the parse tree
	 */
	void exitXorExpression(PolyCParserParser.XorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(PolyCParserParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(PolyCParserParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(PolyCParserParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(PolyCParserParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(PolyCParserParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(PolyCParserParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(PolyCParserParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(PolyCParserParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(PolyCParserParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(PolyCParserParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(PolyCParserParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(PolyCParserParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PolyCParserParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PolyCParserParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(PolyCParserParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(PolyCParserParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PolyCParserParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PolyCParserParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatement(PolyCParserParser.LabeledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatement(PolyCParserParser.LabeledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#declarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationStatement(PolyCParserParser.DeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#declarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationStatement(PolyCParserParser.DeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(PolyCParserParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(PolyCParserParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(PolyCParserParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(PolyCParserParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#sequentialStatement}.
	 * @param ctx the parse tree
	 */
	void enterSequentialStatement(PolyCParserParser.SequentialStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#sequentialStatement}.
	 * @param ctx the parse tree
	 */
	void exitSequentialStatement(PolyCParserParser.SequentialStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(PolyCParserParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(PolyCParserParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(PolyCParserParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(PolyCParserParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(PolyCParserParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(PolyCParserParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#loopSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterLoopSpecifier(PolyCParserParser.LoopSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#loopSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitLoopSpecifier(PolyCParserParser.LoopSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement(PolyCParserParser.JumpStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement(PolyCParserParser.JumpStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(PolyCParserParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(PolyCParserParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#simpleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSimpleDeclaration(PolyCParserParser.SimpleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#simpleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSimpleDeclaration(PolyCParserParser.SimpleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#declSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterDeclSpecifier(PolyCParserParser.DeclSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#declSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitDeclSpecifier(PolyCParserParser.DeclSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(PolyCParserParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(PolyCParserParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclaratorList(PolyCParserParser.InitDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclaratorList(PolyCParserParser.InitDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclarator(PolyCParserParser.InitDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclarator(PolyCParserParser.InitDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclarator(PolyCParserParser.DeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclarator(PolyCParserParser.DeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(PolyCParserParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(PolyCParserParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#initializerClause}.
	 * @param ctx the parse tree
	 */
	void enterInitializerClause(PolyCParserParser.InitializerClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#initializerClause}.
	 * @param ctx the parse tree
	 */
	void exitInitializerClause(PolyCParserParser.InitializerClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#bracketInitList}.
	 * @param ctx the parse tree
	 */
	void enterBracketInitList(PolyCParserParser.BracketInitListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#bracketInitList}.
	 * @param ctx the parse tree
	 */
	void exitBracketInitList(PolyCParserParser.BracketInitListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#initializerList}.
	 * @param ctx the parse tree
	 */
	void enterInitializerList(PolyCParserParser.InitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#initializerList}.
	 * @param ctx the parse tree
	 */
	void exitInitializerList(PolyCParserParser.InitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#braceInitList}.
	 * @param ctx the parse tree
	 */
	void enterBraceInitList(PolyCParserParser.BraceInitListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#braceInitList}.
	 * @param ctx the parse tree
	 */
	void exitBraceInitList(PolyCParserParser.BraceInitListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#colonInitializerList}.
	 * @param ctx the parse tree
	 */
	void enterColonInitializerList(PolyCParserParser.ColonInitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#colonInitializerList}.
	 * @param ctx the parse tree
	 */
	void exitColonInitializerList(PolyCParserParser.ColonInitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(PolyCParserParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(PolyCParserParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(PolyCParserParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(PolyCParserParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclaration(PolyCParserParser.ParameterDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclaration(PolyCParserParser.ParameterDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(PolyCParserParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(PolyCParserParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#emptyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEmptyDeclaration(PolyCParserParser.EmptyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#emptyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEmptyDeclaration(PolyCParserParser.EmptyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PolyCParserParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PolyCParserParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolyCParserParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(PolyCParserParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolyCParserParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(PolyCParserParser.ConstantContext ctx);
}