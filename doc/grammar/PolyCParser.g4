grammar PolyCParser;

import PolyCLexer;

/* parser */
parse
    :   program? EOF
    ;

/* Expressions */
primaryExpression
    :   constant
    |   LeftParen expression RightParen
    |   Identifier
    ;

postfixExpression
    :   primaryExpression
    |   postfixExpression LeftBracket expression RightBracket
    |   postfixExpression LeftParen initializerList? RightParen
    |   postfixExpression (PlusPlus | MinusMinus)
    |   postfixExpression Dot Identifier
    ;

unaryExpression
    :   postfixExpression
    |   unaryOperator unaryExpression
    |   functionOperator LeftParen assignmentExpression RightParen
    ;

unaryOperator
    :   PlusPlus
    |   MinusMinus
    |   Plus
    |   Minus
    |   BitNot
    |   LogicalNot
    ;

functionOperator
    :   Size
    |   Int
    |   String
    |   Array
    |   Print
    ;

multiplicativeExpression
    :   unaryExpression
    |   multiplicativeExpression (Div | Mod)   unaryExpression
	;

additiveExpression
    :   multiplicativeExpression
    |   additiveExpression (Plus | Minus) multiplicativeExpression
	;



shiftExpression
    :   additiveExpression
    |   shiftExpression Greater Greater additiveExpression
	;



relationExpression
    :   shiftExpression
    |   relationExpression relationOperator shiftExpression
    ;



relationOperator
    :   Greater
    |   Less
    |   GreaterEqual
    |   LessEqual
    ;



equalityExpression
    :   relationExpression
    |   equalityExpression equalityOperator relationExpression
    ;



equalityOperator
    :   Equal
    |   NotEqual
    ;



andExpression
    :   equalityExpression (BitAnd equalityExpression)*
    ;



xorExpression
    :   andExpression (BitXor andExpression)*
    ;



orExpression
    :   xorExpression (BitOr xorExpression)*
    ;



logicalAndExpression
    :   orExpression (LogicalAnd orExpression)*
    ;



logicalOrExpression
    :   logicalAndExpression (LogicalOr logicalAndExpression)*
	;



conditionalExpression
    :   logicalOrExpression
    (
		Question expression Colon expression
	)?
	;




assignmentExpression
    :   conditionalExpression
	|   logicalOrExpression assignmentOperator assignmentExpression
	;



assignmentOperator
    :   Assign
    |   DivAssign
    |   ModAssign
    |   PlusAssign
    |   MinusAssign
    |   RightShiftAssign
    |   AndAssign
    |   XorAssign
    |   OrAssign
    ;



expression
    :   assignmentExpression (Comma assignmentExpression)*
    ;



constantExpression
    :   conditionalExpression
    ;

/* Statements */
statement
    :   labeledStatement
    |   declarationStatement
    |   expressionStatement
    |   blockStatement
    |   ifStatement
    |   loopStatement
    |   jumpStatement
    ;




labeledStatement
    :   (   Case constantExpression
		|   Default
	    )   Colon statement
	;



declarationStatement
    :   simpleDeclaration
    ;



expressionStatement
    :   expression? Semi
    ;



blockStatement
    :   LeftBrace sequentialStatement? RightBrace
    ;



sequentialStatement
    :   statement+
    ;




ifStatement
    :   If LeftParen condition RightParen statement (Else statement)?
    |   Switch LeftParen condition RightParen statement
    ;



condition
    :   expression
	;




loopStatement
    :   While LeftParen loopSpecifier RightParen statement
    |   Do statement While LeftParen loopSpecifier RightParen Semi
    ;

loopSpecifier
    :   Identifier Less (   Size LeftParen expression RightParen
                        |   IntegerConstant
                        )
    ;



jumpStatement
    :   (   Break
        |   Continue
        |   Return expression?
        )   Semi
    ;

/* Declarations */
declaration
    :   simpleDeclaration
    |   functionDeclaration
    |   emptyDeclaration
    ;



simpleDeclaration
    :   declSpecifier initDeclaratorList Semi
    ;



declSpecifier
    :   Iterable? typeSpecifier
    ;




typeSpecifier
    :   Array Less typeSpecifier Greater
    |   Dict Less typeSpecifier Comma typeSpecifier Greater
    |   Int
    |   Void
    |   String
    |   Boolean
    ;



initDeclaratorList
    :   initDeclarator (Comma initDeclarator)*
    ;




initDeclarator
    :   declarator initializer?
    ;



declarator
    :   Identifier
    ;





initializer
    :   Assign initializerClause
    |   LeftParen initializerList RightParen
    ;




initializerClause
    :   assignmentExpression
    |   bracketInitList
    |   braceInitList
    ;



bracketInitList
    :   LeftBracket (initializerList)? RightBracket
    ;



initializerList
    :   initializerClause (Comma initializerClause)*
    ;



braceInitList
    :   LeftBrace (colonInitializerList)? RightBrace
    ;



colonInitializerList
    :   assignmentExpression Colon initializerClause (Comma assignmentExpression Colon initializerClause)*
    ;




functionDeclaration
    :   declSpecifier declarator LeftParen parameterList? RightParen functionBody
    ;



parameterList
    :   parameterDeclaration (Comma parameterDeclaration)*
    ;




parameterDeclaration
    :   declSpecifier declarator (Assign assignmentExpression)?
	;



functionBody
    :   blockStatement
    ;



emptyDeclaration
    :   Semi
    ;

/* program */
program
    :   declaration+
    ;

/* Vocabulary */
constant
    :   IntegerConstant
    |   StringConstant
    |   BooleanConstant
    ;