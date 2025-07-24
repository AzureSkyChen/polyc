package interpreter.error;

public class SyntaxError extends Exception {
    public static final SyntaxError SHOULD_NOT_HAPPEN = new SyntaxError("This Error Should Not Happen!");
    public static final SyntaxError NO_MAIN_FUNCTION = new SyntaxError("No Main Function!");

    private SyntaxError(String message) {
        super(message);
    }
}
