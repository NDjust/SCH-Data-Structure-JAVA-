package Ch06;

public class postfix_ex {
    public static void main(String[] args) {
        OptExp2 opt = new OptExp2();
        int result;
        String exp = "35*62/-";
        System.out.printf("\n후위표기식: %s", exp);
        result = opt.evalPostfix(exp);
        System.out.printf("\n 연산결과= %d \n", result);

    }
}

class StackNode {
    int data;
    StackNode link;
}

class LinkedStack {
    private StackNode top;

    public boolean isEmpty() {
        return (top == null);
    }

    public void push(int item) {
        StackNode newNode = new StackNode();
        newNode.data = item;
        newNode.link = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Deleting fail! Linked Stack is empty!!");
            return 0;
        } else {
            int item = top.data;
            top = top.link;
            return item;
        }
    }
}

class OptExp2 {
    private String exp;
    public int evalPostfix(String postfix) {
        LinkedStack  S = new LinkedStack();
        exp = postfix;
        int opr1, opr2, value;
        char testCh;

        for (int i = 0; i < exp.length(); i++) {
            testCh = exp.charAt(i);
            if (testCh != '+' && testCh != '-' && testCh != '*' && testCh != '/') {
                value = testCh - '0'; /* 아스키 코드 활용(cast) 0을 왜빼냐? cast 자료형 변환을 위해 (문자열을 숫자로 바꾸는 법 중 하나임.)*/
                S.push(value);
            } else {
                opr2 = S.pop();
                opr1 = S.pop();

                switch (testCh) {
                    case '+':
                        S.push(opr1 + opr2);
                        break;
                    case '-':
                        S.push(opr1 - opr2);
                        break;
                    case '*':
                        S.push(opr1 * opr2);
                        break;
                    case '/':
                        S.push(opr1 / opr2);
                        break;
                }
            }
        }
        return S.pop();
    }
}
