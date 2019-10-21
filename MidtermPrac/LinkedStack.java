package MidtermPrac;

public class LinkedStack {
    public static void main(String[] args) {

    }
}

class StackNode {
    int data;
     StackNode next;

    public StackNode() {
        this.data = 0;
        this.next = null;
    }

    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }

    public StackNode(int data, StackNode next) {
        this.data = data;
        this.next = next;
    }
}



class Stack {
    StackNode top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        StackNode newNode = new StackNode(data);

        top.next = newNode;
        newNode = top;
    }

    public int pop() {
        if (top == null) {
            return 0;
        } else {
            int data = top.data;
            top = top.next;
            return data;
        }
    }

    public int peek() {
        return top.data;
    }

}