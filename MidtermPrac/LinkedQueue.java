package MidtermPrac;

public class LinkedQueue {
    public static void main(String[] args) {
        char deletedItem;
        LinkedListQueue LQ = new LinkedListQueue();

        LQ.enQueue('A');
        LQ.printQueue();

        LQ.enQueue('B');
        LQ.printQueue();

        deletedItem = LQ.deQueue();
        if (deletedItem != 0) {
            System.out.println("deleted Item : " + deletedItem);
        }
        LQ.printQueue();

        LQ.enQueue('C');
        LQ.printQueue();

        deletedItem = LQ.deQueue();
        if (deletedItem != 0) {
            System.out.println("deleted Item : " + deletedItem);
        }
        LQ.printQueue();

        deletedItem = LQ.deQueue();
        if (deletedItem != 0) {
            System.out.println("deleted Item : " + deletedItem);
        }
    }
}

class QNode {
    char data;
    QNode next;
}

class LinkedListQueue {
    QNode rear;
    QNode front;

    public LinkedListQueue() {
        this.rear = null;
        this.front = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enQueue(char data) {
        QNode newNode = new QNode();
        newNode.data = data;
//        newNode.next = null;
        if (isEmpty()) {
            rear = newNode;
            front = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public char deQueue() {
        if (isEmpty()) {
            System.out.println("비어 있습니다.");
            return 0;
        } else {
            char data = front.data;
            front = front.next;

            if (front == null) {
                rear = null;
            }
            return data;
        }
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("비어 있습니당");
            return 0;
        } else {
            return front.data;
        }
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.printf("Linked Queue is empty!! %n %n");
        } else {
            QNode temp = front;
            System.out.printf("Linked Queue>> ");

            while (temp != null) {
                System.out.printf("%c ", temp.data);
                temp = temp.next;
            }
            System.out.println();
            System.out.println();
        }
    }
}