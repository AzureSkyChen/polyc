grammar simplifiedPolyCParser;

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

unaryExpression
    :   primaryExpression
    |   unaryOperator unaryExpression
    |   Size LeftParen expression RightParen
    ;



unaryOperator
    :   Plus
    |   Minus
    |   LogicalNot
    ;



multiplicativeExpression
    :   unaryExpression
    |   multiplicativeExpression (Div | Mod)   unaryExpression
	;



additiveExpression
    :   multiplicativeExpression
    |   additiveExpression (Plus | Minus) multiplicativeExpression
	;



relationExpression
    :   additiveExpression
    |   relationExpression relationOperator additiveExpression
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



logicalAndExpression
    :   equalityExpression (LogicalAnd equalityExpression)*
    ;



logicalOrExpression
    :   logicalAndExpression (LogicalOr logicalAndExpression)*
	;




assignmentExpression
    :   logicalOrExpression
	|   logicalOrExpression assignmentOperator assignmentExpression
	;



assignmentOperator
    :   Assign
    ;



expression
    :   assignmentExpression
    ;



constantExpression
    :   logicalOrExpression
    ;

/* Statements */
statement
    :   declarationStatement
    |   expressionStatement
    |   blockStatement
    |   ifStatement
    |   loopStatement
    ;



declarationStatement
    :   simpleDeclaration
    ;



expressionStatement
    :   expression Semi
    ;



blockStatement
    :   LeftBrace sequentialStatement? RightBrace
    ;



sequentialStatement
    :   statement+
    ;




ifStatement
    :   If LeftParen condition RightParen statement (Else statement)?
    ;



condition
    :   expression
	;




loopStatement
    :   While LeftParen loopSpecifier RightParen statement
    ;

loopSpecifier
    :   Identifier Less (   Size LeftParen expression RightParen
                        |   IntegerConstant
                        )
    ;

/* Declarations */
declaration
    :   simpleDeclaration
    |   emptyDeclaration
    ;



simpleDeclaration
    :   declSpecifier Identifier Semi
    ;



declSpecifier
    :   Iterable? typeSpecifier
    ;




typeSpecifier
    :   Int
    |   Boolean
    ;



parameterList
    :   parameterDeclaration (Comma parameterDeclaration)*
    ;




parameterDeclaration
    :   declSpecifier Identifier
	;



emptyDeclaration
    :   Semi
    ;

/* program */
program
    :   Int Identifier LeftParen parameterList? RightParen LeftBrace sequentialStatement? Return expression Semi RightBrace
    ;

/* Vocabulary */
constant
    :   IntegerConstant
    |   BooleanConstant
    ;