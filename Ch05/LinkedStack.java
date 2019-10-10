package Ch05;

class StackNode {
    char data;
    StackNode link;
}

class LinkedStack implements Stack {
    private StackNode top;

    @Override
    public boolean isEmpty() {
        return (top == null);
    }

    @Override
    public void push(char item) {
        StackNode newNode = new StackNode();
        newNode.data = item;
        newNode.link = top;
        top = newNode;
    }

    @Override
    public char pop() {
        if (isEmpty()) {
            System.out.println("Deleting fail! Linked Stack is empty!! ");
        } else {
            char item = top.data;
            top = top.link;
            return item;
        }
        return 0;
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            System.out.println("Deleting fail! Linked Stack is empty!!");
        } else {
            top = top.link;
        }

    }

    @Override
    public char peek() {
        if (isEmpty()) {
            System.out.println("Peeking fail! Linked Stack is empty!!");
            return 0;
        } else {
            return top.data;
        }
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.printf("Linked stack is empty!! %n %n");
        } else {
            StackNode temp = top;
            System.out.println("Linked Stack>>");
            while (temp != null) {
                System.out.printf("\t %c \n", temp.data);
                temp = temp.link;
            }
            System.out.println();
        }
    }
}

