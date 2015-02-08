package vm;

import static vm.Bytecode.*;

/**
 * Created by newmen on 2/8/15.
 */
public class Test {
    static final int[] simpleAdd = {
            CONST, 2,
            CONST, 3,
            ADD,
            PRINT,
            HALT
    };

    static final int[] checkLt = {
            CONST, 2,
            CONST, 3,
            LT,         // TRUE
            PRINT,
            CONST, 3,
            CONST, 2,
            LT,         // FALSE
            PRINT,
            HALT
    };

    static final int[] checkJump = {
            CONST, 2,     // 0, 1
            PRINT,        // 2
            JUMP, 8,      // 3, 4
            CONST, 555,   // 5, 6
            PRINT,        // 7
            CONST, 100,   // 8, 9
            PRINT,        // 10
            HALT          // 11
    };

    static final int[] checkStore = {
            CONST, 1,
            CONST, 33,
            STORE, 0,
            PRINT,
            HALT
    };

    static final int[] checkGlobal = {
            CONST, 42,
            GSTORE, 0,
            GLOAD, 0,
            PRINT,
            HALT
    };

    static final int[] recursiveFactorial = {
    // def fact(x):
    //   if x < 2: return 1
            LOAD, -3,     // 0, 1
            CONST, 2,     // 2, 3
            LT,           // 4
            JUMPF, 10,    // 5, 6
            CONST, 1,     // 7, 8
            RET,          // 9
    //   return x * fact(x - 1);
            LOAD, -3,     // 10, 11
            LOAD, -3,     // 12, 13
            CONST, 1,     // 14, 15
            SUB,          // 16
            CALL, 0, 1,   // 17, 18, 19
            MUL,          // 20
            RET,          // 21
    // def main:
    //   print(fact(_))
            CONST, 5,     // 22, 23
            CALL, 0, 1,   // 24, 25, 26
            PRINT,        // 27
            HALT          // 28
    };

    static final int[] iterativeFactorial = {
    // def factit(x, n, r):
    //   if x < n:
    //     return r
            LOAD, -5,     // 0, 1
            LOAD, -4,     // 2, 3
            LT,           // 4
            JUMPF, 10,    // 5, 6
            LOAD, -3,     // 7, 8
            RET,          // 9
    //   else:
    //     return factit(x, n + 1, r * n)
            LOAD, -5,     // 10, 11
            LOAD, -4,     // 12, 13
            CONST, 1,     // 14, 15
            ADD,          // 16
            LOAD, -3,     // 17, 18
            LOAD, -4,     // 19, 20
            MUL,          // 21
            CALL, 0, 3,   // 22, 23, 24
            RET,          // 25
    // def fact(x):
    //   return factit(x, 1, 1)
            LOAD, -3,     // 26, 27
            CONST, 1,     // 28, 29
            CONST, 1,     // 30, 31
            CALL, 0, 3,   // 32, 33, 34
            RET,          // 35
    // def main:
    //   print(fact(_))
            CONST, 5,     // 36, 37
            CALL, 26, 1,  // 38, 39, 40
            PRINT,        // 41
            HALT          // 42
    };

    public static void main(String[] args) throws Exception {
        VM vm = new VM(iterativeFactorial, 36, 0);
        vm.trace = true;
        vm.exec();
    }
}
