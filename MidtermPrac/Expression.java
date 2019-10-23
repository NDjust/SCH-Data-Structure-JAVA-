package MidtermPrac;

public class Expression {
    public static void main(String[] args) {


        String exp = "3*5-6/2+3/2";

        System.out.println(exp);
        Expression e = new Expression();
        if (e.testPair(exp)) {
            System.out.println(" 괄호 맞음 !");
        } else {
            System.out.println(" 괄호 틀림 !!!");
        }

        char postfixp[] = e.post_to_fix(exp);
        System.out.println(postfixp);

    }

   public boolean testPair(String exp) {
        char ch;

        Stack stack = new Stack();
        for (int i = 0; i < exp.length(); i++) {
            ch = exp.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                case ']':
                case '}':
                char testCh = stack.pop();

                if ((ch == '(' && testCh != ')') || (ch == '[' && testCh != ']') || (ch == '{' && testCh != '}')) {
                    return false;
                } else {
                    break;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
   }

    public char[] post_to_fix(String infix) {
        char ch;

        char postfix[] = new char[infix.length() + 1];
        int j = 0;
        Stack stack = new Stack();

        for (int i = 0; i < infix.length(); i++) {
            ch = infix.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == '*' || ch == '/') {
                stack.push(ch);
            } else if (ch == '+' || ch == '-') {
                if (stack.isEmpty()) {
                    stack.push(ch);
                } else if (stack.peek() != '*' && stack.peek() != '/') {
                    stack.push(ch);
                } else if (stack.peek() == '*' || stack.peek() == '/') {
                    postfix[j++] = stack.pop();
                    stack.push(ch);
                }
            } else if (ch == ')') {
                while (stack.peek() != '(') {
                    postfix[j++] = stack.pop();
                }
                stack.pop();
             } else if (ch == ' '){
                continue;
            } else {
                postfix[j++] = ch;
            }
        }

        while (stack.isEmpty() == false) {
            stack.printStack();
            postfix[++j] = stack.pop();
        }

        return postfix;
    }


}


