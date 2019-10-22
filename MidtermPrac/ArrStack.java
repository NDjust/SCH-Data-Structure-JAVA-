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
        top = -1;
        this.stackSize = stackSize;
        itemArray = new char[stackSize];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return (top == this.stackSize - 1);
    }

    public void push (char item) {
        if (isFull()) {
            System.out.println("넣을 수 없습니다.");
        } else {
            itemArray[++top] = item;
            System.out.println("Inserted Item : " + item);
        }
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("뺄 수 없습니다.");
            return 0;
        } else {
            return itemArray[top--];
        }
    }

    public void delete() {
        if (isEmpty()) {
            System.out.println("뺄 수 없습니다.");
        } else {
            top--;
        }
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("보여줄게 없엉");
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
