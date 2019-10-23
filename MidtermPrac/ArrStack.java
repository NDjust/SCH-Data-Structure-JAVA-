package MidtermPrac;

public class ArrStack {
    public static void main(String[] args) {
        int StackSize = 5;

        char deletedItem;
        ArrayStack S = new ArrayStack(StackSize);

        S.push('A');
        S.printStack();

        S.push('B');
        S.printStack();

        S.push('C');
        S.printStack();

        deletedItem = S.pop();

        if (deletedItem != 0) {
            System.out.println("Deleted item: " + deletedItem);
        }
        S.printStack();

    }
}

class ArrayStack {
    private int top;
    private int stackSize;
    private char itemArray[];

    public ArrayStack(int stackSize) {
        this.top = -1;
        this.stackSize = stackSize;
        this.itemArray = new char[stackSize];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == stackSize - 1);
    }

    public void push(char data) {
        if (isFull()) {
            System.out.println("꽉차서 안들어가요 ㅠㅠ");
        } else {
            itemArray[++top] = data;
        }
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("비어 있어요 ㅠㅠ");
            return 0;
        } else {
            return itemArray[top--];
        }
    }

    public void delete() {
        if (isEmpty()) {
            System.out.println("비어 있어요 ㅠㅠ");
        } else {
            top--;
        }
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("비어 있어요 ㅠㅠ");
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
