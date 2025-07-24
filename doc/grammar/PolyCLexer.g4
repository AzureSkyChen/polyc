lexer grammar PolyCLexer;

IntegerConstant
    :   DecimalInteger
    |   BinaryInteger
    |   '0'
    ;



StringConstant
    :   '"' Character* '"'
    ;

BooleanConstant
    :   True
    |   False
    ;



Array: 'array';
Boolean: 'bool';
Break: 'break';
Case: 'case';


Continue: 'continue';
Default: 'default';

Dict: 'dict';
Do: 'do';
Dot: '.';
Else: 'else';

False: 'false';


If: 'if';
Int: 'int';
Iterable: 'iterable';
Print: 'print';
Return: 'return';

Size: 'size';
String: 'string';
Switch: 'switch';

True: 'true';

Void: 'void';
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
    :   NonzeroDigit Digit*
    ;

fragment
BinaryInteger
    :   ('0b' | '0B') ('0' | '1' )+
    ;


fragment
NonzeroDigit
    :   [1-9]
    ;


fragment
Character
    :   ~["\\\r\n]
    |   EscapeSequence
    ;


fragment
EscapeSequence
    :   '\\' ['"?bfnrst\\]
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

