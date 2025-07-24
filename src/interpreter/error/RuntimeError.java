package interpreter.error;

public class RuntimeError extends Exception {
    public static final RuntimeError DIVISION_BY_ZERO = new RuntimeError("Division By Zero!");
    public static final RuntimeError LIST_INDEX_OUT_OF_RANGE = new RuntimeError("List/String Index Out Of Range!");
    public static final RuntimeError NOT_ASSIGNABLE = new RuntimeError("Not Assignable!");
    public static final RuntimeError DICT_KEY_NOT_EXISTS = new RuntimeError("Dict Key Not Exists");
    public static final RuntimeError SYMBOL_UNDEFINED = new RuntimeError("Symbol Undefined!");
    public static final RuntimeError REDECLARATION = new RuntimeError("Redeclaration!");
    public static final RuntimeError SHOULD_NOT_HAPPEN = new RuntimeError("This Error Should Not Happen!");
    public static final RuntimeError INDEX_ERROR = new RuntimeError("Not Indexable");
    public static final RuntimeError VARIABLE_UNINITIALIZED = new RuntimeError("Uninitialized!");
    public static final RuntimeError SHIFT_ERROR = new RuntimeError("The Second Operand Of >> Cannot Be Negative!");
    public static final RuntimeError INT_ERROR = new RuntimeError("Cannot Be Converted To Int!");

    private RuntimeError(String message) {
        super(message);
    }
}