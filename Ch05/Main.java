package Ch05;

public class Main {
    public static void main(String[] args) {
        int stacksize = 5;
        char deletedItem;
        ArrayStack S = new ArrayStack(stacksize);

        S.push('A');
        S.printStack();

        S.push('B');
        S.printStack();

        S.push('C');
        S.printStack();

        deletedItem = S.pop();
        if (deletedItem != 0) {
            System.out.println("deleted item : " + deletedItem);
        }
        S.printStack();

        char deleted_item;
        LinkedStack LS = new LinkedStack();

        LS.push('A');
        LS.printStack();

        LS.push('B');
        LS.printStack();

        LS.push('C');
        LS.printStack();

        deleted_item = LS.pop();
        if (deleted_item != 0) {
            System.out.println("deleted Item : " + deleted_item);
        }
        LS.printStack();

    }
}
