package interpreter.error;

public class TypeError extends Exception {
    public static final TypeError TYPE_MISMATCH = new TypeError("Type Mismatch!");
    public static final TypeError TYPE_NOT_COMPARABLE = new TypeError("Types Not Comparable!");
    public static final TypeError TYPE_NOT_EQUAL = new TypeError("Types Not Equal!");
    public static final TypeError TYPE_NOT_INT_LIKE = new TypeError("Type Not Int-Like!");
    public static final TypeError TYPE_NOT_SIZEABLE = new TypeError("Type Not Sizeable!");
    public static final TypeError TYPE_NOT_STRING_LIKE = new TypeError("Type Not String-Like!");
    public static final TypeError TYPE_NOT_CONSTABLE = new TypeError("Type Not Constable!");
    public static final TypeError TYPE_NOT_ASSIGNABLE = new TypeError("Type Not Assignable");
    public static final TypeError SYMBOL_UNDEFINED = new TypeError("Symbol Undefined!");
    public static final TypeError REDECLARATION = new TypeError("Redeclaration!");
    public static final TypeError SHOULD_NOT_HAPPEN = new TypeError("This Error Should Not Happen!");
    public static final TypeError CASE_ERROR = new TypeError("Case Outside Switch!");
    public static final TypeError DEFAULT_ERROR = new TypeError("Default Outside Switch!");
    public static final TypeError ITERABLE_NOT_ASSIGNABLE = new TypeError("Variables Not Assignable Inside Loop/Function!");
    public static final TypeError DICT_INCONSISTENCY = new TypeError("Dict Types Inconsistent!");
    public static final TypeError ARRAY_INCONSISTENCY = new TypeError("Array Types Inconsistent!");
    public static final TypeError INVALID_TYPE = new TypeError("Invalid Type!");
    public static final TypeError LOOP_VAR_ITERABLE = new TypeError("The loop variable should be iterable!");
    public static final TypeError CONTINUE_BREAK_RETURN_ERROR = new TypeError("Misplaced Continue/Break/Return!");
    public static final TypeError PARAMETER_ERROR = new TypeError("Parameters Should Have Default Values!");
    public static final TypeError PARAMETER_CNT_ERROR = new TypeError("Too Many/Few Parameters!");
    public static final TypeError INVOCATION_ERROR = new TypeError("Parameter Types Mismatch!");
    public static final TypeError RETURN_ERROR = new TypeError("Function Return Type Mismatch!");
    public static final TypeError NO_SUCH_METHOD = new TypeError("No Such Method!");

    private TypeError(String message) {
        super(message);
    }
}
