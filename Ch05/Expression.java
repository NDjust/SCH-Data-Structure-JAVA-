package Ch05;

import java.util.Scanner;

public class Expression {
    public static void main(String[] args) {

        Scanner input_str = new Scanner(System.in);
        String str = input_str.nextLine();
        ArrayStack stack = new ArrayStack(str.length());

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '(' ) {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ']' || str.charAt(i) == '}' || str.charAt(i) == ')') {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }
}
