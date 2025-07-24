// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PolyCParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IntegerConstant=1, StringConstant=2, BooleanConstant=3, Array=4, Boolean=5, 
		Break=6, Case=7, Continue=8, Default=9, Dict=10, Do=11, Dot=12, Else=13, 
		False=14, If=15, Int=16, Iterable=17, Print=18, Return=19, Size=20, String=21, 
		Switch=22, True=23, Void=24, While=25, LeftParen=26, RightParen=27, LeftBracket=28, 
		RightBracket=29, LeftBrace=30, RightBrace=31, Plus=32, Minus=33, Div=34, 
		Mod=35, BitXor=36, BitAnd=37, BitOr=38, BitNot=39, LogicalAnd=40, LogicalOr=41, 
		LogicalNot=42, Assign=43, PlusAssign=44, MinusAssign=45, DivAssign=46, 
		ModAssign=47, XorAssign=48, AndAssign=49, OrAssign=50, RightShiftAssign=51, 
		PlusPlus=52, MinusMinus=53, Less=54, Greater=55, Equal=56, NotEqual=57, 
		LessEqual=58, GreaterEqual=59, Comma=60, Question=61, Colon=62, Semi=63, 
		Identifier=64, Newline=65, Whitespace=66, BlockComment=67, LineComment=68;
	public static final int
		RULE_parse = 0, RULE_primaryExpression = 1, RULE_postfixExpression = 2, 
		RULE_unaryExpression = 3, RULE_unaryOperator = 4, RULE_functionOperator = 5, 
		RULE_multiplicativeExpression = 6, RULE_additiveExpression = 7, RULE_shiftExpression = 8, 
		RULE_relationExpression = 9, RULE_relationOperator = 10, RULE_equalityExpression = 11, 
		RULE_equalityOperator = 12, RULE_andExpression = 13, RULE_xorExpression = 14, 
		RULE_orExpression = 15, RULE_logicalAndExpression = 16, RULE_logicalOrExpression = 17, 
		RULE_conditionalExpression = 18, RULE_assignmentExpression = 19, RULE_assignmentOperator = 20, 
		RULE_expression = 21, RULE_constantExpression = 22, RULE_statement = 23, 
		RULE_labeledStatement = 24, RULE_declarationStatement = 25, RULE_expressionStatement = 26, 
		RULE_blockStatement = 27, RULE_sequentialStatement = 28, RULE_ifStatement = 29, 
		RULE_condition = 30, RULE_loopStatement = 31, RULE_loopSpecifier = 32, 
		RULE_jumpStatement = 33, RULE_declaration = 34, RULE_simpleDeclaration = 35, 
		RULE_declSpecifier = 36, RULE_typeSpecifier = 37, RULE_initDeclaratorList = 38, 
		RULE_initDeclarator = 39, RULE_declarator = 40, RULE_initializer = 41, 
		RULE_initializerClause = 42, RULE_bracketInitList = 43, RULE_initializerList = 44, 
		RULE_braceInitList = 45, RULE_colonInitializerList = 46, RULE_functionDeclaration = 47, 
		RULE_parameterList = 48, RULE_parameterDeclaration = 49, RULE_functionBody = 50, 
		RULE_emptyDeclaration = 51, RULE_program = 52, RULE_constant = 53;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "primaryExpression", "postfixExpression", "unaryExpression", 
			"unaryOperator", "functionOperator", "multiplicativeExpression", "additiveExpression", 
			"shiftExpression", "relationExpression", "relationOperator", "equalityExpression", 
			"equalityOperator", "andExpression", "xorExpression", "orExpression", 
			"logicalAndExpression", "logicalOrExpression", "conditionalExpression", 
			"assignmentExpression", "assignmentOperator", "expression", "constantExpression", 
			"statement", "labeledStatement", "declarationStatement", "expressionStatement", 
			"blockStatement", "sequentialStatement", "ifStatement", "condition", 
			"loopStatement", "loopSpecifier", "jumpStatement", "declaration", "simpleDeclaration", 
			"declSpecifier", "typeSpecifier", "initDeclaratorList", "initDeclarator", 
			"declarator", "initializer", "initializerClause", "bracketInitList", 
			"initializerList", "braceInitList", "colonInitializerList", "functionDeclaration", 
			"parameterList", "parameterDeclaration", "functionBody", "emptyDeclaration", 
			"program", "constant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'array'", "'bool'", "'break'", "'case'", "'continue'", 
			"'default'", "'dict'", "'do'", "'.'", "'else'", "'false'", "'if'", "'int'", 
			"'iterable'", "'print'", "'return'", "'size'", "'string'", "'switch'", 
			"'true'", "'void'", "'while'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			"'+'", "'-'", "'/'", "'%'", "'^'", "'&'", "'|'", "'~'", null, null, null, 
			"'='", "'+='", "'-='", "'/='", "'%='", "'^='", "'&='", "'|='", "'>>='", 
			"'++'", "'--'", "'<'", "'>'", "'=='", "'!='", "'<='", "'>='", "','", 
			"'?'", "':'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IntegerConstant", "StringConstant", "BooleanConstant", "Array", 
			"Boolean", "Break", "Case", "Continue", "Default", "Dict", "Do", "Dot", 
			"Else", "False", "If", "Int", "Iterable", "Print", "Return", "Size", 
			"String", "Switch", "True", "Void", "While", "LeftParen", "RightParen", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Plus", "Minus", 
			"Div", "Mod", "BitXor", "BitAnd", "BitOr", "BitNot", "LogicalAnd", "LogicalOr", 
			"LogicalNot", "Assign", "PlusAssign", "MinusAssign", "DivAssign", "ModAssign", 
			"XorAssign", "AndAssign", "OrAssign", "RightShiftAssign", "PlusPlus", 
			"MinusMinus", "Less", "Greater", "Equal", "NotEqual", "LessEqual", "GreaterEqual", 
			"Comma", "Question", "Colon", "Semi", "Identifier", "Newline", "Whitespace", 
			"BlockComment", "LineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PolyCParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PolyCParserParser.EOF, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & -9223372036835703760L) != 0) {
				{
				setState(108);
				program();
				}
			}

			setState(111);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(PolyCParserParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(PolyCParserParser.RightParen, 0); }
		public TerminalNode Identifier() { return getToken(PolyCParserParser.Identifier, 0); }
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitPrimaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitPrimaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_primaryExpression);
		try {
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerConstant:
			case StringConstant:
			case BooleanConstant:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				constant();
				}
				break;
			case LeftParen:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(LeftParen);
				setState(115);
				expression();
				setState(116);
				match(RightParen);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(PolyCParserParser.LeftBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(PolyCParserParser.RightBracket, 0); }
		public TerminalNode LeftParen() { return getToken(PolyCParserParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(PolyCParserParser.RightParen, 0); }
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode PlusPlus() { return getToken(PolyCParserParser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(PolyCParserParser.MinusMinus, 0); }
		public TerminalNode Dot() { return getToken(PolyCParserParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(PolyCParserParser.Identifier, 0); }
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterPostfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitPostfixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitPostfixExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		return postfixExpression(0);
	}

	private PostfixExpressionContext postfixExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, _parentState);
		PostfixExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_postfixExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(122);
			primaryExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(140);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(124);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(125);
						match(LeftBracket);
						setState(126);
						expression();
						setState(127);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(129);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(130);
						match(LeftParen);
						setState(132);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -9216614156363726833L) != 0) {
							{
							setState(131);
							initializerList();
							}
						}

						setState(134);
						match(RightParen);
						}
						break;
					case 3:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(135);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(136);
						_la = _input.LA(1);
						if ( !(_la==PlusPlus || _la==MinusMinus) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 4:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(137);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(138);
						match(Dot);
						setState(139);
						match(Identifier);
						}
						break;
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExpressionContext extends ParserRuleContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public FunctionOperatorContext functionOperator() {
			return getRuleContext(FunctionOperatorContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(PolyCParserParser.LeftParen, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(PolyCParserParser.RightParen, 0); }
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_unaryExpression);
		try {
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerConstant:
			case StringConstant:
			case BooleanConstant:
			case LeftParen:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				postfixExpression(0);
				}
				break;
			case Plus:
			case Minus:
			case BitNot:
			case LogicalNot:
			case PlusPlus:
			case MinusMinus:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				unaryOperator();
				setState(147);
				unaryExpression();
				}
				break;
			case Array:
			case Int:
			case Print:
			case Size:
			case String:
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				functionOperator();
				setState(150);
				match(LeftParen);
				setState(151);
				assignmentExpression();
				setState(152);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOperatorContext extends ParserRuleContext {
		public TerminalNode PlusPlus() { return getToken(PolyCParserParser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(PolyCParserParser.MinusMinus, 0); }
		public TerminalNode Plus() { return getToken(PolyCParserParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(PolyCParserParser.Minus, 0); }
		public TerminalNode BitNot() { return getToken(PolyCParserParser.BitNot, 0); }
		public TerminalNode LogicalNot() { return getToken(PolyCParserParser.LogicalNot, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitUnaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 13515759569338368L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionOperatorContext extends ParserRuleContext {
		public TerminalNode Size() { return getToken(PolyCParserParser.Size, 0); }
		public TerminalNode Int() { return getToken(PolyCParserParser.Int, 0); }
		public TerminalNode String() { return getToken(PolyCParserParser.String, 0); }
		public TerminalNode Array() { return getToken(PolyCParserParser.Array, 0); }
		public TerminalNode Print() { return getToken(PolyCParserParser.Print, 0); }
		public FunctionOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterFunctionOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitFunctionOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitFunctionOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionOperatorContext functionOperator() throws RecognitionException {
		FunctionOperatorContext _localctx = new FunctionOperatorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 3473424L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public TerminalNode Div() { return getToken(PolyCParserParser.Div, 0); }
		public TerminalNode Mod() { return getToken(PolyCParserParser.Mod, 0); }
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		return multiplicativeExpression(0);
	}

	private MultiplicativeExpressionContext multiplicativeExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, _parentState);
		MultiplicativeExpressionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_multiplicativeExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(161);
			unaryExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
					setState(163);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(164);
					_la = _input.LA(1);
					if ( !(_la==Div || _la==Mod) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(165);
					unaryExpression();
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExpressionContext extends ParserRuleContext {
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public TerminalNode Plus() { return getToken(PolyCParserParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(PolyCParserParser.Minus, 0); }
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		return additiveExpression(0);
	}

	private AdditiveExpressionContext additiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, _parentState);
		AdditiveExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_additiveExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(172);
			multiplicativeExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(179);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
					setState(174);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(175);
					_la = _input.LA(1);
					if ( !(_la==Plus || _la==Minus) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(176);
					multiplicativeExpression(0);
					}
					} 
				}
				setState(181);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShiftExpressionContext extends ParserRuleContext {
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public List<TerminalNode> Greater() { return getTokens(PolyCParserParser.Greater); }
		public TerminalNode Greater(int i) {
			return getToken(PolyCParserParser.Greater, i);
		}
		public ShiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterShiftExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitShiftExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitShiftExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftExpressionContext shiftExpression() throws RecognitionException {
		return shiftExpression(0);
	}

	private ShiftExpressionContext shiftExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ShiftExpressionContext _localctx = new ShiftExpressionContext(_ctx, _parentState);
		ShiftExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_shiftExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(183);
			additiveExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ShiftExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_shiftExpression);
					setState(185);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(186);
					match(Greater);
					setState(187);
					match(Greater);
					setState(188);
					additiveExpression(0);
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationExpressionContext extends ParserRuleContext {
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public RelationExpressionContext relationExpression() {
			return getRuleContext(RelationExpressionContext.class,0);
		}
		public RelationOperatorContext relationOperator() {
			return getRuleContext(RelationOperatorContext.class,0);
		}
		public RelationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterRelationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitRelationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitRelationExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationExpressionContext relationExpression() throws RecognitionException {
		return relationExpression(0);
	}

	private RelationExpressionContext relationExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationExpressionContext _localctx = new RelationExpressionContext(_ctx, _parentState);
		RelationExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_relationExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(195);
			shiftExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(203);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RelationExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relationExpression);
					setState(197);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(198);
					relationOperator();
					setState(199);
					shiftExpression(0);
					}
					} 
				}
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationOperatorContext extends ParserRuleContext {
		public TerminalNode Greater() { return getToken(PolyCParserParser.Greater, 0); }
		public TerminalNode Less() { return getToken(PolyCParserParser.Less, 0); }
		public TerminalNode GreaterEqual() { return getToken(PolyCParserParser.GreaterEqual, 0); }
		public TerminalNode LessEqual() { return getToken(PolyCParserParser.LessEqual, 0); }
		public RelationOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterRelationOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitRelationOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitRelationOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationOperatorContext relationOperator() throws RecognitionException {
		RelationOperatorContext _localctx = new RelationOperatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_relationOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 918734323983581184L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExpressionContext extends ParserRuleContext {
		public RelationExpressionContext relationExpression() {
			return getRuleContext(RelationExpressionContext.class,0);
		}
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public EqualityOperatorContext equalityOperator() {
			return getRuleContext(EqualityOperatorContext.class,0);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		return equalityExpression(0);
	}

	private EqualityExpressionContext equalityExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, _parentState);
		EqualityExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_equalityExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(209);
			relationExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqualityExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
					setState(211);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(212);
					equalityOperator();
					setState(213);
					relationExpression(0);
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityOperatorContext extends ParserRuleContext {
		public TerminalNode Equal() { return getToken(PolyCParserParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(PolyCParserParser.NotEqual, 0); }
		public EqualityOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterEqualityOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitEqualityOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitEqualityOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityOperatorContext equalityOperator() throws RecognitionException {
		EqualityOperatorContext _localctx = new EqualityOperatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_equalityOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_la = _input.LA(1);
			if ( !(_la==Equal || _la==NotEqual) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AndExpressionContext extends ParserRuleContext {
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> BitAnd() { return getTokens(PolyCParserParser.BitAnd); }
		public TerminalNode BitAnd(int i) {
			return getToken(PolyCParserParser.BitAnd, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			equalityExpression(0);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BitAnd) {
				{
				{
				setState(223);
				match(BitAnd);
				setState(224);
				equalityExpression(0);
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class XorExpressionContext extends ParserRuleContext {
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public List<TerminalNode> BitXor() { return getTokens(PolyCParserParser.BitXor); }
		public TerminalNode BitXor(int i) {
			return getToken(PolyCParserParser.BitXor, i);
		}
		public XorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterXorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitXorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitXorExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XorExpressionContext xorExpression() throws RecognitionException {
		XorExpressionContext _localctx = new XorExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_xorExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			andExpression();
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BitXor) {
				{
				{
				setState(231);
				match(BitXor);
				setState(232);
				andExpression();
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OrExpressionContext extends ParserRuleContext {
		public List<XorExpressionContext> xorExpression() {
			return getRuleContexts(XorExpressionContext.class);
		}
		public XorExpressionContext xorExpression(int i) {
			return getRuleContext(XorExpressionContext.class,i);
		}
		public List<TerminalNode> BitOr() { return getTokens(PolyCParserParser.BitOr); }
		public TerminalNode BitOr(int i) {
			return getToken(PolyCParserParser.BitOr, i);
		}
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			xorExpression();
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BitOr) {
				{
				{
				setState(239);
				match(BitOr);
				setState(240);
				xorExpression();
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalAndExpressionContext extends ParserRuleContext {
		public List<OrExpressionContext> orExpression() {
			return getRuleContexts(OrExpressionContext.class);
		}
		public OrExpressionContext orExpression(int i) {
			return getRuleContext(OrExpressionContext.class,i);
		}
		public List<TerminalNode> LogicalAnd() { return getTokens(PolyCParserParser.LogicalAnd); }
		public TerminalNode LogicalAnd(int i) {
			return getToken(PolyCParserParser.LogicalAnd, i);
		}
		public LogicalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterLogicalAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitLogicalAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitLogicalAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalAndExpressionContext logicalAndExpression() throws RecognitionException {
		LogicalAndExpressionContext _localctx = new LogicalAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_logicalAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			orExpression();
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LogicalAnd) {
				{
				{
				setState(247);
				match(LogicalAnd);
				setState(248);
				orExpression();
				}
				}
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOrExpressionContext extends ParserRuleContext {
		public List<LogicalAndExpressionContext> logicalAndExpression() {
			return getRuleContexts(LogicalAndExpressionContext.class);
		}
		public LogicalAndExpressionContext logicalAndExpression(int i) {
			return getRuleContext(LogicalAndExpressionContext.class,i);
		}
		public List<TerminalNode> LogicalOr() { return getTokens(PolyCParserParser.LogicalOr); }
		public TerminalNode LogicalOr(int i) {
			return getToken(PolyCParserParser.LogicalOr, i);
		}
		public LogicalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterLogicalOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitLogicalOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitLogicalOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOrExpressionContext logicalOrExpression() throws RecognitionException {
		LogicalOrExpressionContext _localctx = new LogicalOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_logicalOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			logicalAndExpression();
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LogicalOr) {
				{
				{
				setState(255);
				match(LogicalOr);
				setState(256);
				logicalAndExpression();
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalExpressionContext extends ParserRuleContext {
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public TerminalNode Question() { return getToken(PolyCParserParser.Question, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Colon() { return getToken(PolyCParserParser.Colon, 0); }
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitConditionalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitConditionalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_conditionalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			logicalOrExpression();
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Question) {
				{
				setState(263);
				match(Question);
				setState(264);
				expression();
				setState(265);
				match(Colon);
				setState(266);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentExpressionContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitAssignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assignmentExpression);
		try {
			setState(275);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				conditionalExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(271);
				logicalOrExpression();
				setState(272);
				assignmentOperator();
				setState(273);
				assignmentExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentOperatorContext extends ParserRuleContext {
		public TerminalNode Assign() { return getToken(PolyCParserParser.Assign, 0); }
		public TerminalNode DivAssign() { return getToken(PolyCParserParser.DivAssign, 0); }
		public TerminalNode ModAssign() { return getToken(PolyCParserParser.ModAssign, 0); }
		public TerminalNode PlusAssign() { return getToken(PolyCParserParser.PlusAssign, 0); }
		public TerminalNode MinusAssign() { return getToken(PolyCParserParser.MinusAssign, 0); }
		public TerminalNode RightShiftAssign() { return getToken(PolyCParserParser.RightShiftAssign, 0); }
		public TerminalNode AndAssign() { return getToken(PolyCParserParser.AndAssign, 0); }
		public TerminalNode XorAssign() { return getToken(PolyCParserParser.XorAssign, 0); }
		public TerminalNode OrAssign() { return getToken(PolyCParserParser.OrAssign, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitAssignmentOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitAssignmentOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 4494803534348288L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public List<AssignmentExpressionContext> assignmentExpression() {
			return getRuleContexts(AssignmentExpressionContext.class);
		}
		public AssignmentExpressionContext assignmentExpression(int i) {
			return getRuleContext(AssignmentExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PolyCParserParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PolyCParserParser.Comma, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			assignmentExpression();
			setState(284);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(280);
					match(Comma);
					setState(281);
					assignmentExpression();
					}
					} 
				}
				setState(286);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantExpressionContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ConstantExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterConstantExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitConstantExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitConstantExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			conditionalExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public LabeledStatementContext labeledStatement() {
			return getRuleContext(LabeledStatementContext.class,0);
		}
		public DeclarationStatementContext declarationStatement() {
			return getRuleContext(DeclarationStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_statement);
		try {
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				labeledStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				declarationStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(291);
				expressionStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(292);
				blockStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(293);
				ifStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(294);
				loopStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(295);
				jumpStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LabeledStatementContext extends ParserRuleContext {
		public TerminalNode Colon() { return getToken(PolyCParserParser.Colon, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Case() { return getToken(PolyCParserParser.Case, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode Default() { return getToken(PolyCParserParser.Default, 0); }
		public LabeledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterLabeledStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitLabeledStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitLabeledStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabeledStatementContext labeledStatement() throws RecognitionException {
		LabeledStatementContext _localctx = new LabeledStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_labeledStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Case:
				{
				setState(298);
				match(Case);
				setState(299);
				constantExpression();
				}
				break;
			case Default:
				{
				setState(300);
				match(Default);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(303);
			match(Colon);
			setState(304);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationStatementContext extends ParserRuleContext {
		public SimpleDeclarationContext simpleDeclaration() {
			return getRuleContext(SimpleDeclarationContext.class,0);
		}
		public DeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationStatementContext declarationStatement() throws RecognitionException {
		DeclarationStatementContext _localctx = new DeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_declarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			simpleDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(PolyCParserParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -9216614157034815473L) != 0) {
				{
				setState(308);
				expression();
				}
			}

			setState(311);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(PolyCParserParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(PolyCParserParser.RightBrace, 0); }
		public SequentialStatementContext sequentialStatement() {
			return getRuleContext(SequentialStatementContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(LeftBrace);
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -4604928138042947585L) != 0) {
				{
				setState(314);
				sequentialStatement();
				}
			}

			setState(317);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SequentialStatementContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SequentialStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequentialStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterSequentialStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitSequentialStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitSequentialStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequentialStatementContext sequentialStatement() throws RecognitionException {
		SequentialStatementContext _localctx = new SequentialStatementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_sequentialStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(319);
				statement();
				}
				}
				setState(322); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -4604928138042947585L) != 0 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(PolyCParserParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(PolyCParserParser.LeftParen, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(PolyCParserParser.RightParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(PolyCParserParser.Else, 0); }
		public TerminalNode Switch() { return getToken(PolyCParserParser.Switch, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_ifStatement);
		try {
			setState(339);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If:
				enterOuterAlt(_localctx, 1);
				{
				setState(324);
				match(If);
				setState(325);
				match(LeftParen);
				setState(326);
				condition();
				setState(327);
				match(RightParen);
				setState(328);
				statement();
				setState(331);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(329);
					match(Else);
					setState(330);
					statement();
					}
					break;
				}
				}
				break;
			case Switch:
				enterOuterAlt(_localctx, 2);
				{
				setState(333);
				match(Switch);
				setState(334);
				match(LeftParen);
				setState(335);
				condition();
				setState(336);
				match(RightParen);
				setState(337);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(PolyCParserParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(PolyCParserParser.LeftParen, 0); }
		public LoopSpecifierContext loopSpecifier() {
			return getRuleContext(LoopSpecifierContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(PolyCParserParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Do() { return getToken(PolyCParserParser.Do, 0); }
		public TerminalNode Semi() { return getToken(PolyCParserParser.Semi, 0); }
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_loopStatement);
		try {
			setState(357);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				enterOuterAlt(_localctx, 1);
				{
				setState(343);
				match(While);
				setState(344);
				match(LeftParen);
				setState(345);
				loopSpecifier();
				setState(346);
				match(RightParen);
				setState(347);
				statement();
				}
				break;
			case Do:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				match(Do);
				setState(350);
				statement();
				setState(351);
				match(While);
				setState(352);
				match(LeftParen);
				setState(353);
				loopSpecifier();
				setState(354);
				match(RightParen);
				setState(355);
				match(Semi);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopSpecifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PolyCParserParser.Identifier, 0); }
		public TerminalNode Less() { return getToken(PolyCParserParser.Less, 0); }
		public TerminalNode Size() { return getToken(PolyCParserParser.Size, 0); }
		public TerminalNode LeftParen() { return getToken(PolyCParserParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(PolyCParserParser.RightParen, 0); }
		public TerminalNode IntegerConstant() { return getToken(PolyCParserParser.IntegerConstant, 0); }
		public LoopSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterLoopSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitLoopSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitLoopSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopSpecifierContext loopSpecifier() throws RecognitionException {
		LoopSpecifierContext _localctx = new LoopSpecifierContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_loopSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			match(Identifier);
			setState(360);
			match(Less);
			setState(367);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Size:
				{
				setState(361);
				match(Size);
				setState(362);
				match(LeftParen);
				setState(363);
				expression();
				setState(364);
				match(RightParen);
				}
				break;
			case IntegerConstant:
				{
				setState(366);
				match(IntegerConstant);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JumpStatementContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(PolyCParserParser.Semi, 0); }
		public TerminalNode Break() { return getToken(PolyCParserParser.Break, 0); }
		public TerminalNode Continue() { return getToken(PolyCParserParser.Continue, 0); }
		public TerminalNode Return() { return getToken(PolyCParserParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterJumpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitJumpStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitJumpStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_jumpStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Break:
				{
				setState(369);
				match(Break);
				}
				break;
			case Continue:
				{
				setState(370);
				match(Continue);
				}
				break;
			case Return:
				{
				setState(371);
				match(Return);
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -9216614157034815473L) != 0) {
					{
					setState(372);
					expression();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(377);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public SimpleDeclarationContext simpleDeclaration() {
			return getRuleContext(SimpleDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public EmptyDeclarationContext emptyDeclaration() {
			return getRuleContext(EmptyDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_declaration);
		try {
			setState(382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(379);
				simpleDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(380);
				functionDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(381);
				emptyDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleDeclarationContext extends ParserRuleContext {
		public DeclSpecifierContext declSpecifier() {
			return getRuleContext(DeclSpecifierContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public TerminalNode Semi() { return getToken(PolyCParserParser.Semi, 0); }
		public SimpleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterSimpleDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitSimpleDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitSimpleDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleDeclarationContext simpleDeclaration() throws RecognitionException {
		SimpleDeclarationContext _localctx = new SimpleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_simpleDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			declSpecifier();
			setState(385);
			initDeclaratorList();
			setState(386);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclSpecifierContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode Iterable() { return getToken(PolyCParserParser.Iterable, 0); }
		public DeclSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterDeclSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitDeclSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitDeclSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclSpecifierContext declSpecifier() throws RecognitionException {
		DeclSpecifierContext _localctx = new DeclSpecifierContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_declSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Iterable) {
				{
				setState(388);
				match(Iterable);
				}
			}

			setState(391);
			typeSpecifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSpecifierContext extends ParserRuleContext {
		public TerminalNode Array() { return getToken(PolyCParserParser.Array, 0); }
		public TerminalNode Less() { return getToken(PolyCParserParser.Less, 0); }
		public List<TypeSpecifierContext> typeSpecifier() {
			return getRuleContexts(TypeSpecifierContext.class);
		}
		public TypeSpecifierContext typeSpecifier(int i) {
			return getRuleContext(TypeSpecifierContext.class,i);
		}
		public TerminalNode Greater() { return getToken(PolyCParserParser.Greater, 0); }
		public TerminalNode Dict() { return getToken(PolyCParserParser.Dict, 0); }
		public TerminalNode Comma() { return getToken(PolyCParserParser.Comma, 0); }
		public TerminalNode Int() { return getToken(PolyCParserParser.Int, 0); }
		public TerminalNode Void() { return getToken(PolyCParserParser.Void, 0); }
		public TerminalNode String() { return getToken(PolyCParserParser.String, 0); }
		public TerminalNode Boolean() { return getToken(PolyCParserParser.Boolean, 0); }
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitTypeSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitTypeSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_typeSpecifier);
		try {
			setState(409);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Array:
				enterOuterAlt(_localctx, 1);
				{
				setState(393);
				match(Array);
				setState(394);
				match(Less);
				setState(395);
				typeSpecifier();
				setState(396);
				match(Greater);
				}
				break;
			case Dict:
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
				match(Dict);
				setState(399);
				match(Less);
				setState(400);
				typeSpecifier();
				setState(401);
				match(Comma);
				setState(402);
				typeSpecifier();
				setState(403);
				match(Greater);
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 3);
				{
				setState(405);
				match(Int);
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 4);
				{
				setState(406);
				match(Void);
				}
				break;
			case String:
				enterOuterAlt(_localctx, 5);
				{
				setState(407);
				match(String);
				}
				break;
			case Boolean:
				enterOuterAlt(_localctx, 6);
				{
				setState(408);
				match(Boolean);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitDeclaratorListContext extends ParserRuleContext {
		public List<InitDeclaratorContext> initDeclarator() {
			return getRuleContexts(InitDeclaratorContext.class);
		}
		public InitDeclaratorContext initDeclarator(int i) {
			return getRuleContext(InitDeclaratorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PolyCParserParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PolyCParserParser.Comma, i);
		}
		public InitDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterInitDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitInitDeclaratorList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitInitDeclaratorList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitDeclaratorListContext initDeclaratorList() throws RecognitionException {
		InitDeclaratorListContext _localctx = new InitDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_initDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			initDeclarator();
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(412);
				match(Comma);
				setState(413);
				initDeclarator();
				}
				}
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitDeclaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public InitDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterInitDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitInitDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitInitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitDeclaratorContext initDeclarator() throws RecognitionException {
		InitDeclaratorContext _localctx = new InitDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_initDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			declarator();
			setState(421);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftParen || _la==Assign) {
				{
				setState(420);
				initializer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PolyCParserParser.Identifier, 0); }
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_declarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerContext extends ParserRuleContext {
		public TerminalNode Assign() { return getToken(PolyCParserParser.Assign, 0); }
		public InitializerClauseContext initializerClause() {
			return getRuleContext(InitializerClauseContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(PolyCParserParser.LeftParen, 0); }
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(PolyCParserParser.RightParen, 0); }
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_initializer);
		try {
			setState(431);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Assign:
				enterOuterAlt(_localctx, 1);
				{
				setState(425);
				match(Assign);
				setState(426);
				initializerClause();
				}
				break;
			case LeftParen:
				enterOuterAlt(_localctx, 2);
				{
				setState(427);
				match(LeftParen);
				setState(428);
				initializerList();
				setState(429);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerClauseContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public BracketInitListContext bracketInitList() {
			return getRuleContext(BracketInitListContext.class,0);
		}
		public BraceInitListContext braceInitList() {
			return getRuleContext(BraceInitListContext.class,0);
		}
		public InitializerClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterInitializerClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitInitializerClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitInitializerClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerClauseContext initializerClause() throws RecognitionException {
		InitializerClauseContext _localctx = new InitializerClauseContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_initializerClause);
		try {
			setState(436);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerConstant:
			case StringConstant:
			case BooleanConstant:
			case Array:
			case Int:
			case Print:
			case Size:
			case String:
			case LeftParen:
			case Plus:
			case Minus:
			case BitNot:
			case LogicalNot:
			case PlusPlus:
			case MinusMinus:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(433);
				assignmentExpression();
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(434);
				bracketInitList();
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 3);
				{
				setState(435);
				braceInitList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BracketInitListContext extends ParserRuleContext {
		public TerminalNode LeftBracket() { return getToken(PolyCParserParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(PolyCParserParser.RightBracket, 0); }
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public BracketInitListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketInitList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterBracketInitList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitBracketInitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitBracketInitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketInitListContext bracketInitList() throws RecognitionException {
		BracketInitListContext _localctx = new BracketInitListContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_bracketInitList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			match(LeftBracket);
			setState(440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -9216614156363726833L) != 0) {
				{
				setState(439);
				initializerList();
				}
			}

			setState(442);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerListContext extends ParserRuleContext {
		public List<InitializerClauseContext> initializerClause() {
			return getRuleContexts(InitializerClauseContext.class);
		}
		public InitializerClauseContext initializerClause(int i) {
			return getRuleContext(InitializerClauseContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PolyCParserParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PolyCParserParser.Comma, i);
		}
		public InitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitInitializerList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitInitializerList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerListContext initializerList() throws RecognitionException {
		InitializerListContext _localctx = new InitializerListContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_initializerList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			initializerClause();
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(445);
				match(Comma);
				setState(446);
				initializerClause();
				}
				}
				setState(451);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BraceInitListContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(PolyCParserParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(PolyCParserParser.RightBrace, 0); }
		public ColonInitializerListContext colonInitializerList() {
			return getRuleContext(ColonInitializerListContext.class,0);
		}
		public BraceInitListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_braceInitList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterBraceInitList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitBraceInitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitBraceInitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BraceInitListContext braceInitList() throws RecognitionException {
		BraceInitListContext _localctx = new BraceInitListContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_braceInitList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			match(LeftBrace);
			setState(454);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -9216614157034815473L) != 0) {
				{
				setState(453);
				colonInitializerList();
				}
			}

			setState(456);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColonInitializerListContext extends ParserRuleContext {
		public List<AssignmentExpressionContext> assignmentExpression() {
			return getRuleContexts(AssignmentExpressionContext.class);
		}
		public AssignmentExpressionContext assignmentExpression(int i) {
			return getRuleContext(AssignmentExpressionContext.class,i);
		}
		public List<TerminalNode> Colon() { return getTokens(PolyCParserParser.Colon); }
		public TerminalNode Colon(int i) {
			return getToken(PolyCParserParser.Colon, i);
		}
		public List<InitializerClauseContext> initializerClause() {
			return getRuleContexts(InitializerClauseContext.class);
		}
		public InitializerClauseContext initializerClause(int i) {
			return getRuleContext(InitializerClauseContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PolyCParserParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PolyCParserParser.Comma, i);
		}
		public ColonInitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colonInitializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterColonInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitColonInitializerList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitColonInitializerList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColonInitializerListContext colonInitializerList() throws RecognitionException {
		ColonInitializerListContext _localctx = new ColonInitializerListContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_colonInitializerList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			assignmentExpression();
			setState(459);
			match(Colon);
			setState(460);
			initializerClause();
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(461);
				match(Comma);
				setState(462);
				assignmentExpression();
				setState(463);
				match(Colon);
				setState(464);
				initializerClause();
				}
				}
				setState(470);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public DeclSpecifierContext declSpecifier() {
			return getRuleContext(DeclSpecifierContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(PolyCParserParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(PolyCParserParser.RightParen, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			declSpecifier();
			setState(472);
			declarator();
			setState(473);
			match(LeftParen);
			setState(475);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 19072048L) != 0) {
				{
				setState(474);
				parameterList();
				}
			}

			setState(477);
			match(RightParen);
			setState(478);
			functionBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PolyCParserParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PolyCParserParser.Comma, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			parameterDeclaration();
			setState(485);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(481);
				match(Comma);
				setState(482);
				parameterDeclaration();
				}
				}
				setState(487);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterDeclarationContext extends ParserRuleContext {
		public DeclSpecifierContext declSpecifier() {
			return getRuleContext(DeclSpecifierContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(PolyCParserParser.Assign, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterParameterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitParameterDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitParameterDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_parameterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			declSpecifier();
			setState(489);
			declarator();
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(490);
				match(Assign);
				setState(491);
				assignmentExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionBodyContext extends ParserRuleContext {
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterFunctionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitFunctionBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitFunctionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_functionBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			blockStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EmptyDeclarationContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(PolyCParserParser.Semi, 0); }
		public EmptyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterEmptyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitEmptyDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitEmptyDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyDeclarationContext emptyDeclaration() throws RecognitionException {
		EmptyDeclarationContext _localctx = new EmptyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_emptyDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(498);
				declaration();
				}
				}
				setState(501); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & -9223372036835703760L) != 0 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode IntegerConstant() { return getToken(PolyCParserParser.IntegerConstant, 0); }
		public TerminalNode StringConstant() { return getToken(PolyCParserParser.StringConstant, 0); }
		public TerminalNode BooleanConstant() { return getToken(PolyCParserParser.BooleanConstant, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolyCParserListener ) ((PolyCParserListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolyCParserVisitor ) return ((PolyCParserVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 14L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return postfixExpression_sempred((PostfixExpressionContext)_localctx, predIndex);
		case 6:
			return multiplicativeExpression_sempred((MultiplicativeExpressionContext)_localctx, predIndex);
		case 7:
			return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 8:
			return shiftExpression_sempred((ShiftExpressionContext)_localctx, predIndex);
		case 9:
			return relationExpression_sempred((RelationExpressionContext)_localctx, predIndex);
		case 11:
			return equalityExpression_sempred((EqualityExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean postfixExpression_sempred(PostfixExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplicativeExpression_sempred(MultiplicativeExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additiveExpression_sempred(AdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean shiftExpression_sempred(ShiftExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relationExpression_sempred(RelationExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equalityExpression_sempred(EqualityExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001D\u01fa\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u0001\u0000\u0003\u0000"+
		"n\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001x\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0085\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002\u008d\b\u0002\n\u0002\f\u0002\u0090\t\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003\u009b\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006\u00a7\b\u0006\n\u0006\f\u0006\u00aa\t\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007\u00b2\b\u0007\n\u0007\f\u0007\u00b5\t\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00be\b\b\n\b\f\b\u00c1"+
		"\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00ca"+
		"\b\t\n\t\f\t\u00cd\t\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00d8\b\u000b"+
		"\n\u000b\f\u000b\u00db\t\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r"+
		"\u0005\r\u00e2\b\r\n\r\f\r\u00e5\t\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u00ea\b\u000e\n\u000e\f\u000e\u00ed\t\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0005\u000f\u00f2\b\u000f\n\u000f\f\u000f\u00f5\t\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00fa\b\u0010\n\u0010"+
		"\f\u0010\u00fd\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011"+
		"\u0102\b\u0011\n\u0011\f\u0011\u0105\t\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u010d\b\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0114"+
		"\b\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0005"+
		"\u0015\u011b\b\u0015\n\u0015\f\u0015\u011e\t\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0003\u0017\u0129\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u012e\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0003\u001a\u0136\b\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001b\u0001\u001b\u0003\u001b\u013c\b\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0004\u001c\u0141\b\u001c\u000b\u001c\f\u001c\u0142\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0003\u001d\u014c\b\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0154\b\u001d\u0001\u001e\u0001"+
		"\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u0166\b\u001f\u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u0170\b \u0001!\u0001"+
		"!\u0001!\u0001!\u0003!\u0176\b!\u0003!\u0178\b!\u0001!\u0001!\u0001\""+
		"\u0001\"\u0001\"\u0003\"\u017f\b\"\u0001#\u0001#\u0001#\u0001#\u0001$"+
		"\u0003$\u0186\b$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0003%\u019a\b%\u0001&\u0001&\u0001&\u0005&\u019f\b&\n&\f&\u01a2\t&"+
		"\u0001\'\u0001\'\u0003\'\u01a6\b\'\u0001(\u0001(\u0001)\u0001)\u0001)"+
		"\u0001)\u0001)\u0001)\u0003)\u01b0\b)\u0001*\u0001*\u0001*\u0003*\u01b5"+
		"\b*\u0001+\u0001+\u0003+\u01b9\b+\u0001+\u0001+\u0001,\u0001,\u0001,\u0005"+
		",\u01c0\b,\n,\f,\u01c3\t,\u0001-\u0001-\u0003-\u01c7\b-\u0001-\u0001-"+
		"\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0005.\u01d3"+
		"\b.\n.\f.\u01d6\t.\u0001/\u0001/\u0001/\u0001/\u0003/\u01dc\b/\u0001/"+
		"\u0001/\u0001/\u00010\u00010\u00010\u00050\u01e4\b0\n0\f0\u01e7\t0\u0001"+
		"1\u00011\u00011\u00011\u00031\u01ed\b1\u00012\u00012\u00013\u00013\u0001"+
		"4\u00044\u01f4\b4\u000b4\f4\u01f5\u00015\u00015\u00015\u0000\u0006\u0004"+
		"\f\u000e\u0010\u0012\u00166\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR"+
		"TVXZ\\^`bdfhj\u0000\t\u0001\u000045\u0004\u0000 !\'\'**45\u0004\u0000"+
		"\u0004\u0004\u0010\u0010\u0012\u0012\u0014\u0015\u0001\u0000\"#\u0001"+
		"\u0000 !\u0002\u000067:;\u0001\u000089\u0001\u0000+3\u0001\u0000\u0001"+
		"\u0003\u0200\u0000m\u0001\u0000\u0000\u0000\u0002w\u0001\u0000\u0000\u0000"+
		"\u0004y\u0001\u0000\u0000\u0000\u0006\u009a\u0001\u0000\u0000\u0000\b"+
		"\u009c\u0001\u0000\u0000\u0000\n\u009e\u0001\u0000\u0000\u0000\f\u00a0"+
		"\u0001\u0000\u0000\u0000\u000e\u00ab\u0001\u0000\u0000\u0000\u0010\u00b6"+
		"\u0001\u0000\u0000\u0000\u0012\u00c2\u0001\u0000\u0000\u0000\u0014\u00ce"+
		"\u0001\u0000\u0000\u0000\u0016\u00d0\u0001\u0000\u0000\u0000\u0018\u00dc"+
		"\u0001\u0000\u0000\u0000\u001a\u00de\u0001\u0000\u0000\u0000\u001c\u00e6"+
		"\u0001\u0000\u0000\u0000\u001e\u00ee\u0001\u0000\u0000\u0000 \u00f6\u0001"+
		"\u0000\u0000\u0000\"\u00fe\u0001\u0000\u0000\u0000$\u0106\u0001\u0000"+
		"\u0000\u0000&\u0113\u0001\u0000\u0000\u0000(\u0115\u0001\u0000\u0000\u0000"+
		"*\u0117\u0001\u0000\u0000\u0000,\u011f\u0001\u0000\u0000\u0000.\u0128"+
		"\u0001\u0000\u0000\u00000\u012d\u0001\u0000\u0000\u00002\u0132\u0001\u0000"+
		"\u0000\u00004\u0135\u0001\u0000\u0000\u00006\u0139\u0001\u0000\u0000\u0000"+
		"8\u0140\u0001\u0000\u0000\u0000:\u0153\u0001\u0000\u0000\u0000<\u0155"+
		"\u0001\u0000\u0000\u0000>\u0165\u0001\u0000\u0000\u0000@\u0167\u0001\u0000"+
		"\u0000\u0000B\u0177\u0001\u0000\u0000\u0000D\u017e\u0001\u0000\u0000\u0000"+
		"F\u0180\u0001\u0000\u0000\u0000H\u0185\u0001\u0000\u0000\u0000J\u0199"+
		"\u0001\u0000\u0000\u0000L\u019b\u0001\u0000\u0000\u0000N\u01a3\u0001\u0000"+
		"\u0000\u0000P\u01a7\u0001\u0000\u0000\u0000R\u01af\u0001\u0000\u0000\u0000"+
		"T\u01b4\u0001\u0000\u0000\u0000V\u01b6\u0001\u0000\u0000\u0000X\u01bc"+
		"\u0001\u0000\u0000\u0000Z\u01c4\u0001\u0000\u0000\u0000\\\u01ca\u0001"+
		"\u0000\u0000\u0000^\u01d7\u0001\u0000\u0000\u0000`\u01e0\u0001\u0000\u0000"+
		"\u0000b\u01e8\u0001\u0000\u0000\u0000d\u01ee\u0001\u0000\u0000\u0000f"+
		"\u01f0\u0001\u0000\u0000\u0000h\u01f3\u0001\u0000\u0000\u0000j\u01f7\u0001"+
		"\u0000\u0000\u0000ln\u0003h4\u0000ml\u0001\u0000\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000no\u0001\u0000\u0000\u0000op\u0005\u0000\u0000\u0001p\u0001"+
		"\u0001\u0000\u0000\u0000qx\u0003j5\u0000rs\u0005\u001a\u0000\u0000st\u0003"+
		"*\u0015\u0000tu\u0005\u001b\u0000\u0000ux\u0001\u0000\u0000\u0000vx\u0005"+
		"@\u0000\u0000wq\u0001\u0000\u0000\u0000wr\u0001\u0000\u0000\u0000wv\u0001"+
		"\u0000\u0000\u0000x\u0003\u0001\u0000\u0000\u0000yz\u0006\u0002\uffff"+
		"\uffff\u0000z{\u0003\u0002\u0001\u0000{\u008e\u0001\u0000\u0000\u0000"+
		"|}\n\u0004\u0000\u0000}~\u0005\u001c\u0000\u0000~\u007f\u0003*\u0015\u0000"+
		"\u007f\u0080\u0005\u001d\u0000\u0000\u0080\u008d\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\n\u0003\u0000\u0000\u0082\u0084\u0005\u001a\u0000\u0000\u0083"+
		"\u0085\u0003X,\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0084\u0085\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u008d\u0005"+
		"\u001b\u0000\u0000\u0087\u0088\n\u0002\u0000\u0000\u0088\u008d\u0007\u0000"+
		"\u0000\u0000\u0089\u008a\n\u0001\u0000\u0000\u008a\u008b\u0005\f\u0000"+
		"\u0000\u008b\u008d\u0005@\u0000\u0000\u008c|\u0001\u0000\u0000\u0000\u008c"+
		"\u0081\u0001\u0000\u0000\u0000\u008c\u0087\u0001\u0000\u0000\u0000\u008c"+
		"\u0089\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e"+
		"\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f"+
		"\u0005\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091"+
		"\u009b\u0003\u0004\u0002\u0000\u0092\u0093\u0003\b\u0004\u0000\u0093\u0094"+
		"\u0003\u0006\u0003\u0000\u0094\u009b\u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0003\n\u0005\u0000\u0096\u0097\u0005\u001a\u0000\u0000\u0097\u0098\u0003"+
		"&\u0013\u0000\u0098\u0099\u0005\u001b\u0000\u0000\u0099\u009b\u0001\u0000"+
		"\u0000\u0000\u009a\u0091\u0001\u0000\u0000\u0000\u009a\u0092\u0001\u0000"+
		"\u0000\u0000\u009a\u0095\u0001\u0000\u0000\u0000\u009b\u0007\u0001\u0000"+
		"\u0000\u0000\u009c\u009d\u0007\u0001\u0000\u0000\u009d\t\u0001\u0000\u0000"+
		"\u0000\u009e\u009f\u0007\u0002\u0000\u0000\u009f\u000b\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a1\u0006\u0006\uffff\uffff\u0000\u00a1\u00a2\u0003\u0006"+
		"\u0003\u0000\u00a2\u00a8\u0001\u0000\u0000\u0000\u00a3\u00a4\n\u0001\u0000"+
		"\u0000\u00a4\u00a5\u0007\u0003\u0000\u0000\u00a5\u00a7\u0003\u0006\u0003"+
		"\u0000\u00a6\u00a3\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000"+
		"\u0000\u00a9\r\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0006\u0007\uffff\uffff\u0000\u00ac\u00ad\u0003\f\u0006\u0000"+
		"\u00ad\u00b3\u0001\u0000\u0000\u0000\u00ae\u00af\n\u0001\u0000\u0000\u00af"+
		"\u00b0\u0007\u0004\u0000\u0000\u00b0\u00b2\u0003\f\u0006\u0000\u00b1\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000\u0000\u00b3\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u000f"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b7"+
		"\u0006\b\uffff\uffff\u0000\u00b7\u00b8\u0003\u000e\u0007\u0000\u00b8\u00bf"+
		"\u0001\u0000\u0000\u0000\u00b9\u00ba\n\u0001\u0000\u0000\u00ba\u00bb\u0005"+
		"7\u0000\u0000\u00bb\u00bc\u00057\u0000\u0000\u00bc\u00be\u0003\u000e\u0007"+
		"\u0000\u00bd\u00b9\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000\u0000"+
		"\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c0\u0011\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0006\t\uffff\uffff\u0000\u00c3\u00c4\u0003\u0010\b"+
		"\u0000\u00c4\u00cb\u0001\u0000\u0000\u0000\u00c5\u00c6\n\u0001\u0000\u0000"+
		"\u00c6\u00c7\u0003\u0014\n\u0000\u00c7\u00c8\u0003\u0010\b\u0000\u00c8"+
		"\u00ca\u0001\u0000\u0000\u0000\u00c9\u00c5\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb"+
		"\u00cc\u0001\u0000\u0000\u0000\u00cc\u0013\u0001\u0000\u0000\u0000\u00cd"+
		"\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cf\u0007\u0005\u0000\u0000\u00cf"+
		"\u0015\u0001\u0000\u0000\u0000\u00d0\u00d1\u0006\u000b\uffff\uffff\u0000"+
		"\u00d1\u00d2\u0003\u0012\t\u0000\u00d2\u00d9\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d4\n\u0001\u0000\u0000\u00d4\u00d5\u0003\u0018\f\u0000\u00d5\u00d6"+
		"\u0003\u0012\t\u0000\u00d6\u00d8\u0001\u0000\u0000\u0000\u00d7\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u0017\u0001"+
		"\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u00dd\u0007"+
		"\u0006\u0000\u0000\u00dd\u0019\u0001\u0000\u0000\u0000\u00de\u00e3\u0003"+
		"\u0016\u000b\u0000\u00df\u00e0\u0005%\u0000\u0000\u00e0\u00e2\u0003\u0016"+
		"\u000b\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000"+
		"\u0000\u0000\u00e4\u001b\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e6\u00eb\u0003\u001a\r\u0000\u00e7\u00e8\u0005$\u0000"+
		"\u0000\u00e8\u00ea\u0003\u001a\r\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000"+
		"\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u001d\u0001\u0000\u0000\u0000"+
		"\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00f3\u0003\u001c\u000e\u0000"+
		"\u00ef\u00f0\u0005&\u0000\u0000\u00f0\u00f2\u0003\u001c\u000e\u0000\u00f1"+
		"\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f5\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4"+
		"\u001f\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f6"+
		"\u00fb\u0003\u001e\u000f\u0000\u00f7\u00f8\u0005(\u0000\u0000\u00f8\u00fa"+
		"\u0003\u001e\u000f\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00fa\u00fd"+
		"\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fc"+
		"\u0001\u0000\u0000\u0000\u00fc!\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fe\u0103\u0003 \u0010\u0000\u00ff\u0100\u0005)\u0000"+
		"\u0000\u0100\u0102\u0003 \u0010\u0000\u0101\u00ff\u0001\u0000\u0000\u0000"+
		"\u0102\u0105\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000"+
		"\u0103\u0104\u0001\u0000\u0000\u0000\u0104#\u0001\u0000\u0000\u0000\u0105"+
		"\u0103\u0001\u0000\u0000\u0000\u0106\u010c\u0003\"\u0011\u0000\u0107\u0108"+
		"\u0005=\u0000\u0000\u0108\u0109\u0003*\u0015\u0000\u0109\u010a\u0005>"+
		"\u0000\u0000\u010a\u010b\u0003*\u0015\u0000\u010b\u010d\u0001\u0000\u0000"+
		"\u0000\u010c\u0107\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000"+
		"\u0000\u010d%\u0001\u0000\u0000\u0000\u010e\u0114\u0003$\u0012\u0000\u010f"+
		"\u0110\u0003\"\u0011\u0000\u0110\u0111\u0003(\u0014\u0000\u0111\u0112"+
		"\u0003&\u0013\u0000\u0112\u0114\u0001\u0000\u0000\u0000\u0113\u010e\u0001"+
		"\u0000\u0000\u0000\u0113\u010f\u0001\u0000\u0000\u0000\u0114\'\u0001\u0000"+
		"\u0000\u0000\u0115\u0116\u0007\u0007\u0000\u0000\u0116)\u0001\u0000\u0000"+
		"\u0000\u0117\u011c\u0003&\u0013\u0000\u0118\u0119\u0005<\u0000\u0000\u0119"+
		"\u011b\u0003&\u0013\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011b\u011e"+
		"\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011c\u011d"+
		"\u0001\u0000\u0000\u0000\u011d+\u0001\u0000\u0000\u0000\u011e\u011c\u0001"+
		"\u0000\u0000\u0000\u011f\u0120\u0003$\u0012\u0000\u0120-\u0001\u0000\u0000"+
		"\u0000\u0121\u0129\u00030\u0018\u0000\u0122\u0129\u00032\u0019\u0000\u0123"+
		"\u0129\u00034\u001a\u0000\u0124\u0129\u00036\u001b\u0000\u0125\u0129\u0003"+
		":\u001d\u0000\u0126\u0129\u0003>\u001f\u0000\u0127\u0129\u0003B!\u0000"+
		"\u0128\u0121\u0001\u0000\u0000\u0000\u0128\u0122\u0001\u0000\u0000\u0000"+
		"\u0128\u0123\u0001\u0000\u0000\u0000\u0128\u0124\u0001\u0000\u0000\u0000"+
		"\u0128\u0125\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000"+
		"\u0128\u0127\u0001\u0000\u0000\u0000\u0129/\u0001\u0000\u0000\u0000\u012a"+
		"\u012b\u0005\u0007\u0000\u0000\u012b\u012e\u0003,\u0016\u0000\u012c\u012e"+
		"\u0005\t\u0000\u0000\u012d\u012a\u0001\u0000\u0000\u0000\u012d\u012c\u0001"+
		"\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u0130\u0005"+
		">\u0000\u0000\u0130\u0131\u0003.\u0017\u0000\u01311\u0001\u0000\u0000"+
		"\u0000\u0132\u0133\u0003F#\u0000\u01333\u0001\u0000\u0000\u0000\u0134"+
		"\u0136\u0003*\u0015\u0000\u0135\u0134\u0001\u0000\u0000\u0000\u0135\u0136"+
		"\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137\u0138"+
		"\u0005?\u0000\u0000\u01385\u0001\u0000\u0000\u0000\u0139\u013b\u0005\u001e"+
		"\u0000\u0000\u013a\u013c\u00038\u001c\u0000\u013b\u013a\u0001\u0000\u0000"+
		"\u0000\u013b\u013c\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000"+
		"\u0000\u013d\u013e\u0005\u001f\u0000\u0000\u013e7\u0001\u0000\u0000\u0000"+
		"\u013f\u0141\u0003.\u0017\u0000\u0140\u013f\u0001\u0000\u0000\u0000\u0141"+
		"\u0142\u0001\u0000\u0000\u0000\u0142\u0140\u0001\u0000\u0000\u0000\u0142"+
		"\u0143\u0001\u0000\u0000\u0000\u01439\u0001\u0000\u0000\u0000\u0144\u0145"+
		"\u0005\u000f\u0000\u0000\u0145\u0146\u0005\u001a\u0000\u0000\u0146\u0147"+
		"\u0003<\u001e\u0000\u0147\u0148\u0005\u001b\u0000\u0000\u0148\u014b\u0003"+
		".\u0017\u0000\u0149\u014a\u0005\r\u0000\u0000\u014a\u014c\u0003.\u0017"+
		"\u0000\u014b\u0149\u0001\u0000\u0000\u0000\u014b\u014c\u0001\u0000\u0000"+
		"\u0000\u014c\u0154\u0001\u0000\u0000\u0000\u014d\u014e\u0005\u0016\u0000"+
		"\u0000\u014e\u014f\u0005\u001a\u0000\u0000\u014f\u0150\u0003<\u001e\u0000"+
		"\u0150\u0151\u0005\u001b\u0000\u0000\u0151\u0152\u0003.\u0017\u0000\u0152"+
		"\u0154\u0001\u0000\u0000\u0000\u0153\u0144\u0001\u0000\u0000\u0000\u0153"+
		"\u014d\u0001\u0000\u0000\u0000\u0154;\u0001\u0000\u0000\u0000\u0155\u0156"+
		"\u0003*\u0015\u0000\u0156=\u0001\u0000\u0000\u0000\u0157\u0158\u0005\u0019"+
		"\u0000\u0000\u0158\u0159\u0005\u001a\u0000\u0000\u0159\u015a\u0003@ \u0000"+
		"\u015a\u015b\u0005\u001b\u0000\u0000\u015b\u015c\u0003.\u0017\u0000\u015c"+
		"\u0166\u0001\u0000\u0000\u0000\u015d\u015e\u0005\u000b\u0000\u0000\u015e"+
		"\u015f\u0003.\u0017\u0000\u015f\u0160\u0005\u0019\u0000\u0000\u0160\u0161"+
		"\u0005\u001a\u0000\u0000\u0161\u0162\u0003@ \u0000\u0162\u0163\u0005\u001b"+
		"\u0000\u0000\u0163\u0164\u0005?\u0000\u0000\u0164\u0166\u0001\u0000\u0000"+
		"\u0000\u0165\u0157\u0001\u0000\u0000\u0000\u0165\u015d\u0001\u0000\u0000"+
		"\u0000\u0166?\u0001\u0000\u0000\u0000\u0167\u0168\u0005@\u0000\u0000\u0168"+
		"\u016f\u00056\u0000\u0000\u0169\u016a\u0005\u0014\u0000\u0000\u016a\u016b"+
		"\u0005\u001a\u0000\u0000\u016b\u016c\u0003*\u0015\u0000\u016c\u016d\u0005"+
		"\u001b\u0000\u0000\u016d\u0170\u0001\u0000\u0000\u0000\u016e\u0170\u0005"+
		"\u0001\u0000\u0000\u016f\u0169\u0001\u0000\u0000\u0000\u016f\u016e\u0001"+
		"\u0000\u0000\u0000\u0170A\u0001\u0000\u0000\u0000\u0171\u0178\u0005\u0006"+
		"\u0000\u0000\u0172\u0178\u0005\b\u0000\u0000\u0173\u0175\u0005\u0013\u0000"+
		"\u0000\u0174\u0176\u0003*\u0015\u0000\u0175\u0174\u0001\u0000\u0000\u0000"+
		"\u0175\u0176\u0001\u0000\u0000\u0000\u0176\u0178\u0001\u0000\u0000\u0000"+
		"\u0177\u0171\u0001\u0000\u0000\u0000\u0177\u0172\u0001\u0000\u0000\u0000"+
		"\u0177\u0173\u0001\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000"+
		"\u0179\u017a\u0005?\u0000\u0000\u017aC\u0001\u0000\u0000\u0000\u017b\u017f"+
		"\u0003F#\u0000\u017c\u017f\u0003^/\u0000\u017d\u017f\u0003f3\u0000\u017e"+
		"\u017b\u0001\u0000\u0000\u0000\u017e\u017c\u0001\u0000\u0000\u0000\u017e"+
		"\u017d\u0001\u0000\u0000\u0000\u017fE\u0001\u0000\u0000\u0000\u0180\u0181"+
		"\u0003H$\u0000\u0181\u0182\u0003L&\u0000\u0182\u0183\u0005?\u0000\u0000"+
		"\u0183G\u0001\u0000\u0000\u0000\u0184\u0186\u0005\u0011\u0000\u0000\u0185"+
		"\u0184\u0001\u0000\u0000\u0000\u0185\u0186\u0001\u0000\u0000\u0000\u0186"+
		"\u0187\u0001\u0000\u0000\u0000\u0187\u0188\u0003J%\u0000\u0188I\u0001"+
		"\u0000\u0000\u0000\u0189\u018a\u0005\u0004\u0000\u0000\u018a\u018b\u0005"+
		"6\u0000\u0000\u018b\u018c\u0003J%\u0000\u018c\u018d\u00057\u0000\u0000"+
		"\u018d\u019a\u0001\u0000\u0000\u0000\u018e\u018f\u0005\n\u0000\u0000\u018f"+
		"\u0190\u00056\u0000\u0000\u0190\u0191\u0003J%\u0000\u0191\u0192\u0005"+
		"<\u0000\u0000\u0192\u0193\u0003J%\u0000\u0193\u0194\u00057\u0000\u0000"+
		"\u0194\u019a\u0001\u0000\u0000\u0000\u0195\u019a\u0005\u0010\u0000\u0000"+
		"\u0196\u019a\u0005\u0018\u0000\u0000\u0197\u019a\u0005\u0015\u0000\u0000"+
		"\u0198\u019a\u0005\u0005\u0000\u0000\u0199\u0189\u0001\u0000\u0000\u0000"+
		"\u0199\u018e\u0001\u0000\u0000\u0000\u0199\u0195\u0001\u0000\u0000\u0000"+
		"\u0199\u0196\u0001\u0000\u0000\u0000\u0199\u0197\u0001\u0000\u0000\u0000"+
		"\u0199\u0198\u0001\u0000\u0000\u0000\u019aK\u0001\u0000\u0000\u0000\u019b"+
		"\u01a0\u0003N\'\u0000\u019c\u019d\u0005<\u0000\u0000\u019d\u019f\u0003"+
		"N\'\u0000\u019e\u019c\u0001\u0000\u0000\u0000\u019f\u01a2\u0001\u0000"+
		"\u0000\u0000\u01a0\u019e\u0001\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000"+
		"\u0000\u0000\u01a1M\u0001\u0000\u0000\u0000\u01a2\u01a0\u0001\u0000\u0000"+
		"\u0000\u01a3\u01a5\u0003P(\u0000\u01a4\u01a6\u0003R)\u0000\u01a5\u01a4"+
		"\u0001\u0000\u0000\u0000\u01a5\u01a6\u0001\u0000\u0000\u0000\u01a6O\u0001"+
		"\u0000\u0000\u0000\u01a7\u01a8\u0005@\u0000\u0000\u01a8Q\u0001\u0000\u0000"+
		"\u0000\u01a9\u01aa\u0005+\u0000\u0000\u01aa\u01b0\u0003T*\u0000\u01ab"+
		"\u01ac\u0005\u001a\u0000\u0000\u01ac\u01ad\u0003X,\u0000\u01ad\u01ae\u0005"+
		"\u001b\u0000\u0000\u01ae\u01b0\u0001\u0000\u0000\u0000\u01af\u01a9\u0001"+
		"\u0000\u0000\u0000\u01af\u01ab\u0001\u0000\u0000\u0000\u01b0S\u0001\u0000"+
		"\u0000\u0000\u01b1\u01b5\u0003&\u0013\u0000\u01b2\u01b5\u0003V+\u0000"+
		"\u01b3\u01b5\u0003Z-\u0000\u01b4\u01b1\u0001\u0000\u0000\u0000\u01b4\u01b2"+
		"\u0001\u0000\u0000\u0000\u01b4\u01b3\u0001\u0000\u0000\u0000\u01b5U\u0001"+
		"\u0000\u0000\u0000\u01b6\u01b8\u0005\u001c\u0000\u0000\u01b7\u01b9\u0003"+
		"X,\u0000\u01b8\u01b7\u0001\u0000\u0000\u0000\u01b8\u01b9\u0001\u0000\u0000"+
		"\u0000\u01b9\u01ba\u0001\u0000\u0000\u0000\u01ba\u01bb\u0005\u001d\u0000"+
		"\u0000\u01bbW\u0001\u0000\u0000\u0000\u01bc\u01c1\u0003T*\u0000\u01bd"+
		"\u01be\u0005<\u0000\u0000\u01be\u01c0\u0003T*\u0000\u01bf\u01bd\u0001"+
		"\u0000\u0000\u0000\u01c0\u01c3\u0001\u0000\u0000\u0000\u01c1\u01bf\u0001"+
		"\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000\u0000\u0000\u01c2Y\u0001\u0000"+
		"\u0000\u0000\u01c3\u01c1\u0001\u0000\u0000\u0000\u01c4\u01c6\u0005\u001e"+
		"\u0000\u0000\u01c5\u01c7\u0003\\.\u0000\u01c6\u01c5\u0001\u0000\u0000"+
		"\u0000\u01c6\u01c7\u0001\u0000\u0000\u0000\u01c7\u01c8\u0001\u0000\u0000"+
		"\u0000\u01c8\u01c9\u0005\u001f\u0000\u0000\u01c9[\u0001\u0000\u0000\u0000"+
		"\u01ca\u01cb\u0003&\u0013\u0000\u01cb\u01cc\u0005>\u0000\u0000\u01cc\u01d4"+
		"\u0003T*\u0000\u01cd\u01ce\u0005<\u0000\u0000\u01ce\u01cf\u0003&\u0013"+
		"\u0000\u01cf\u01d0\u0005>\u0000\u0000\u01d0\u01d1\u0003T*\u0000\u01d1"+
		"\u01d3\u0001\u0000\u0000\u0000\u01d2\u01cd\u0001\u0000\u0000\u0000\u01d3"+
		"\u01d6\u0001\u0000\u0000\u0000\u01d4\u01d2\u0001\u0000\u0000\u0000\u01d4"+
		"\u01d5\u0001\u0000\u0000\u0000\u01d5]\u0001\u0000\u0000\u0000\u01d6\u01d4"+
		"\u0001\u0000\u0000\u0000\u01d7\u01d8\u0003H$\u0000\u01d8\u01d9\u0003P"+
		"(\u0000\u01d9\u01db\u0005\u001a\u0000\u0000\u01da\u01dc\u0003`0\u0000"+
		"\u01db\u01da\u0001\u0000\u0000\u0000\u01db\u01dc\u0001\u0000\u0000\u0000"+
		"\u01dc\u01dd\u0001\u0000\u0000\u0000\u01dd\u01de\u0005\u001b\u0000\u0000"+
		"\u01de\u01df\u0003d2\u0000\u01df_\u0001\u0000\u0000\u0000\u01e0\u01e5"+
		"\u0003b1\u0000\u01e1\u01e2\u0005<\u0000\u0000\u01e2\u01e4\u0003b1\u0000"+
		"\u01e3\u01e1\u0001\u0000\u0000\u0000\u01e4\u01e7\u0001\u0000\u0000\u0000"+
		"\u01e5\u01e3\u0001\u0000\u0000\u0000\u01e5\u01e6\u0001\u0000\u0000\u0000"+
		"\u01e6a\u0001\u0000\u0000\u0000\u01e7\u01e5\u0001\u0000\u0000\u0000\u01e8"+
		"\u01e9\u0003H$\u0000\u01e9\u01ec\u0003P(\u0000\u01ea\u01eb\u0005+\u0000"+
		"\u0000\u01eb\u01ed\u0003&\u0013\u0000\u01ec\u01ea\u0001\u0000\u0000\u0000"+
		"\u01ec\u01ed\u0001\u0000\u0000\u0000\u01edc\u0001\u0000\u0000\u0000\u01ee"+
		"\u01ef\u00036\u001b\u0000\u01efe\u0001\u0000\u0000\u0000\u01f0\u01f1\u0005"+
		"?\u0000\u0000\u01f1g\u0001\u0000\u0000\u0000\u01f2\u01f4\u0003D\"\u0000"+
		"\u01f3\u01f2\u0001\u0000\u0000\u0000\u01f4\u01f5\u0001\u0000\u0000\u0000"+
		"\u01f5\u01f3\u0001\u0000\u0000\u0000\u01f5\u01f6\u0001\u0000\u0000\u0000"+
		"\u01f6i\u0001\u0000\u0000\u0000\u01f7\u01f8\u0007\b\u0000\u0000\u01f8"+
		"k\u0001\u0000\u0000\u0000-mw\u0084\u008c\u008e\u009a\u00a8\u00b3\u00bf"+
		"\u00cb\u00d9\u00e3\u00eb\u00f3\u00fb\u0103\u010c\u0113\u011c\u0128\u012d"+
		"\u0135\u013b\u0142\u014b\u0153\u0165\u016f\u0175\u0177\u017e\u0185\u0199"+
		"\u01a0\u01a5\u01af\u01b4\u01b8\u01c1\u01c6\u01d4\u01db\u01e5\u01ec\u01f5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}