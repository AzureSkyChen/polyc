package test;

import interpreter.Interpreter;

public class InterpreterTest {
    public static void main(String[] args) throws Exception {
        Interpreter.interpret(new String[]{"doc/examples/fib.pc"});
        Interpreter.interpret(new String[]{"doc/examples/multiplication.pc", "-4", "18"});
        Interpreter.interpret(new String[]{"doc/examples/prime.pc"});
    }
}
