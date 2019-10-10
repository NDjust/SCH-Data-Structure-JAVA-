package Ch05;

interface Stack {
    boolean isEmpty();
    void push(char item);
    char pop();
    void delete();
    char peek();
}

class ArrayStack implements Stack {
    private int top;
    private int stackSize;
    private char itemArray[];

    public ArrayStack(int stackSize) {
        top = -1;
        this.stackSize = stackSize;
        itemArray = new char[this.stackSize];
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull(){
        return (top == this.stackSize - 1);
    }

    @Override
    public void push(char item) {
        if (isFull()) {
            System.out.println("Inserting full array stack is full!");
        } else {
            itemArray[++top] = item;
        }

    }

    @Override
    public char pop() {
        if (isEmpty()) {
            System.out.println("Deleting array stack is Empty!!");
            return 0;
        } else {
            return itemArray[top--];
        }
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            System.out.println("Deleting Array stack is empty!!");
        } else {
            top--;
        }

    }

    @Override
    public char peek() {
        if (isEmpty()) {
            System.out.println("peeking full Array stack is empty!!");
            return 0;
        } else {
            return itemArray[top];
        }
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.printf("Array Stack is empty!! %n %n");
        } else {
            System.out.printf("Array Stack>> ");
            for (int i = 0; i <= top; i++) {
                System.out.printf("%c ", itemArray[i]);
            }
            System.out.println();
            System.out.println();
        }
    }
}
