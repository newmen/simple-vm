package vm;

/**
 * Created by newmen on 2/8/15.
 */
public class Bytecode {
    public static final int HALT = 0;
    public static final int CONST = 1;
    public static final int ADD = 2;
    public static final int SUB = 3;
    public static final int MUL = 4;
    public static final int LT = 5;
    public static final int EQ = 6;
    public static final int JUMP = 7;
    public static final int JUMPT = 8;
    public static final int JUMPF = 9;
    public static final int LOAD = 10;
    public static final int STORE = 11;
    public static final int GLOAD = 12;
    public static final int GSTORE = 13;
    public static final int CALL = 14;
    public static final int RET = 15;
    public static final int PRINT = 16;

    static class Instruction {
        String name;
        int nargs;

        public Instruction(String name) {
            this(name, 0);
        }

        public Instruction(String name, int nargs) {
            this.name = name;
            this.nargs = nargs;
        }
    }

    static Instruction[] instructions = {
            new Instruction("halt"),
            new Instruction("const", 1),
            new Instruction("add"),
            new Instruction("sub"),
            new Instruction("mul"),
            new Instruction("lt"),
            new Instruction("eq"),
            new Instruction("jump", 1),
            new Instruction("jumpt", 1),
            new Instruction("jumpf", 1),
            new Instruction("load", 1),
            new Instruction("store", 1),
            new Instruction("gload", 1),
            new Instruction("gstore", 1),
            new Instruction("call", 2),
            new Instruction("ret"),
            new Instruction("print")
    };
}
