lexer grammar simplifiedPolyCLexer;

IntegerConstant
    :   DecimalInteger
    ;

BooleanConstant
    :   True
    |   False
    ;

Boolean: 'bool';
Else: 'else';
False: 'false';
If: 'if';
Int: 'int';
Iterable: 'iterable';
Return: 'return';
Size: 'size';
True: 'true';
While: 'while';


LeftParen: '(';
RightParen: ')';
LeftBracket: '[';
RightBracket: ']';
LeftBrace: '{';
RightBrace: '}';
Plus: '+';
Minus: '-';

Div: '/';
Mod: '%';
BitXor: '^';
BitAnd: '&';
BitOr: '|';
BitNot: '~';
LogicalAnd: '&&' | 'and';
LogicalOr: '||' | 'or';
LogicalNot: '!' | 'not';
Assign: '=';
PlusAssign: '+=';
MinusAssign: '-=';

DivAssign: '/=';
ModAssign: '%=';
XorAssign: '^=';
AndAssign: '&=';
OrAssign: '|=';
RightShiftAssign: '>>=';

PlusPlus: '++';
MinusMinus: '--';
Less: '<';
Greater: '>';
Equal: '==';
NotEqual: '!=';
LessEqual: '<=';
GreaterEqual: '>=';
Comma: ',';
Question: '?';
Colon: ':';
Semi: ';';




Identifier
    :   IdentifierLetter
        (   IdentifierLetter
        |   Digit
        )*
    ;


fragment

DecimalInteger
    :   Digit+
    ;


fragment
IdentifierLetter
    :   [a-zA-Z_]
    ;


fragment
Digit
    :   [0-9]
    ;


Newline
    :   (   '\r' '\n'?
        |   '\n'
        )
        -> skip
    ;


Whitespace: [ \t]+ -> skip;



BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;



LineComment
    :   '//' ~[\r\n]*
        -> skip
    ;

