package MidtermPrac;

public class Dequeue {
    public static void main(String[] args) {
        char deletedItem;
        Dqueue DQ = new Dqueue();

        DQ.insertFront('A');
        DQ.printDQueue();

        DQ.insertFront('B');
        DQ.printDQueue();

        DQ.insertFront('C');
        DQ.printDQueue();

        deletedItem = DQ.deleteFront();
        if (deletedItem != 0) {
            System.out.println("Front deleted Item : " + deletedItem);
        }
        DQ.printDQueue();

        deletedItem = DQ.deleteRear();
        if (deletedItem != 0) {
            System.out.println("Rear deleted Item : " + deletedItem);
        }
        DQ.printDQueue();

        DQ.insertFront('D');
        DQ.printDQueue();

        DQ.insertFront('E');
        DQ.printDQueue();

        DQ.insertFront('F');
        DQ.printDQueue();
    }
}


class DNode {
    char data;
    DNode next;
    DNode prev;
}

class Dqueue{
    DNode front;
    DNode rear;

    public Dqueue() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void insertFront(char data) {
        DNode newNode = new DNode();
        newNode.data = data;

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            newNode.next = null;
            newNode.prev = null;
        } else {
            front.prev = newNode;
            newNode.next = front;
            front = newNode;
        }
    }

    public void insertRear(char data) {
        DNode newNode = new DNode();
        newNode.data = data;

        if (isEmpty()) {
            front = newNode;
            rear = newNode;

            newNode.next = null;
            newNode.prev = null;
        } else {
            rear.next = newNode;
            newNode.next = null;
            newNode.prev = rear;
            rear = newNode;
        }
    }

    public char deleteFront() {
        if (isEmpty()) {
            System.out.println("비어 있어용");
            return 0;
        } else {
            char data = front.data;
            if (front.next == null) {
                front = null;
                rear = null;
            } else {
                front = front.next;
                front.prev = null;
            }

            return data;
        }
    }

    public char deleteRear() {
        if (isEmpty()) {
            System.out.println("비어 있어용");
            return 0;
        } else {
            char data = rear.data;

            if (rear.prev == null) {
                front = null;
                rear = null;
            }else {
                rear = rear.prev;
                rear.next = null;
            }
            return data;
        }
    }

    public void removeFront() {
        if (isEmpty()) {
            System.out.println("비어 있어요");
        } else {
            if (front.next == null) {
                front = null;
                rear = null;
            } else {
                front = front.next;
                front.prev = null;
            }
        }
    }

    public void removeRear() {
        if (isEmpty()) {
            System.out.println("비어 있어용");
        } else {
            if (rear.prev == null) {
                front = null;
                rear = null;
            } else {
                rear = rear.prev;
                rear.next = null;
            }
        }
    }

    public char peekFront() {
        if (isEmpty()) {
            System.out.println("비어 있어요.");
            return 0;
        } else {
            return front.data;
        }
    }

    public char peekRear() {
        if (isEmpty()) {
            System.out.println("비어 있어용");
            return 0;
        } else {
            return rear.data;
        }
    }

    public void printDQueue() {
        if (isEmpty()) {
            System.out.printf("DQueue is empty!! %n %n");
        } else {
            DNode temp = front;
            System.out.printf("DQueue>> ");

            while (temp != null) {
                System.out.printf("%c ", temp.data);
                temp = temp.next;
            }

            System.out.println();
            System.out.println();
        }
    }
}