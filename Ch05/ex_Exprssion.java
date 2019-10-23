package Ch05;

public class ex_Exprssion {
    public static void main(String[] args) {
        OptExp opt = new OptExp();
        String exp = "(3*5)-(6/2) * (2 + 1)";
        char postfix[];
        int value;

        System.out.println(exp);
        if (opt.testPair(exp)) {
            System.out.println(" 괄호 맞음 !");
        } else {
            System.out.println(" 괄호 틀림 !!!");
        }
        System.out.printf("\n 후위표기식 : ");
        postfix = opt.to_post_fix(exp);
        System.out.println(postfix);
    }
}

class OptExp {
    private String exp;
    private int expSize;
    private char testCh, openPair;

    public boolean testPair(String exp) {
        this.exp = exp;
        LinkedStack S = new LinkedStack();
        expSize = this.exp.length();

        for (int i = 0; i < expSize; i++) {
            testCh = this.exp.charAt(i);
            switch (testCh) {
                case '(':
                case '[':
                case '{':
                    S.push(testCh);
                    break;
                case ')':
                case ']':
                case '}':
                    if (S.isEmpty()) {
                        return false;
                    } else {
                        openPair = S.pop();
                        if ((openPair == '(' && testCh != ')') || (openPair == '{' && testCh != '}') || (openPair == '[' && testCh != ']')) {
                            return false;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (S.isEmpty()) {
                return true;
            } else {
                return false;
            }
    }

    public char[] to_post_fix(String infix) {
        char testCh;
        exp = infix;
        int expSize = 20;
        int j = 0;
        char postfix[] = new char[expSize];
        LinkedStack S = new LinkedStack();

        for (int i = 0; i <= expSize; i++) {
            testCh = this.exp.charAt(i);
            switch (testCh) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    postfix[j++] = testCh;
                    break;
                 case '+':
                 case '-':
                 case '*':
                 case '/':
                     S.push(testCh);
                     break;
                 case ')':
                    postfix[j++] = S.pop();
                    break;
                default:
            }
        }

        while (S.isEmpty() != true) {
            postfix[j++]  = S.pop(); /* output last stack element. */
        }
        return postfix;
    }
}