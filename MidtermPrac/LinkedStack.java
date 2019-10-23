package MidtermPrac;

public class LinkedStack {

    public static void main(String[] args) {
        char deletedItem;
        Stack LS = new Stack();

        LS.push('A');
        LS.printStack();

        LS.push('B');
        LS.printStack();

        LS.push('C');
        LS.printStack();

        deletedItem = LS.pop();

        if (deletedItem != 0) {
            System.out.println("deleted item : " + deletedItem);
        }

        LS.printStack();

    }
}

class StackNode {
    char data;
    StackNode next;

    public StackNode() {
        this.data = 0;
        this.next = null;
    }

    public StackNode(char data) {
        this.data = data;
        this.next = null;
    }

    public StackNode(char data, StackNode next) {
        this.data = data;
        this.next = next;
    }
}



class Stack {
    StackNode top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(char data) {
        StackNode newNode = new StackNode(data);

        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("비어 있어여 ㅠㅠ");
            return 0;
        } else {
            char data = top.data;
            top = top.next;
            return data;
        }
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("비어 있어요 ㅠㅠ");
            return 0;
        } else {
            return top.data;
        }
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.printf("Array Stack is empty!! %n %n");
        } else {

            StackNode temp = top;
            System.out.println("Array Stack>> ");
            while (temp != null) {
                System.out.printf("\t %c \n", temp.data);
                temp = temp.next;
            }
            System.out.println();
        }
    }
}