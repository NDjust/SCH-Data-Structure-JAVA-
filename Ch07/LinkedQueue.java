package Ch07;

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
    QNode link;
}

class LinkedListQueue implements Queue {
    QNode front;
    QNode rear;

    public LinkedListQueue() {
        front = null;
        rear = null;
    }

    @Override
    public boolean isEmpty() {
        return (front == null);
    }

    @Override
    public void enQueue(char item) {
        QNode newNode = new QNode();
        newNode.data = item;
        newNode.link = null; // link에는 null을 넣은 다음에 시작.

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.link = newNode;
            rear = newNode;
        }
        System.out.println("Inserted Item : " + item);
    }

    @Override
    public char deQueue() {
        if (isEmpty()) {
            System.out.println("Deleting fail! Linked Queue is empty!!");
            return 0;
        } else {
            char item = front.data;
            front = front.link;

            if (front == null) {
                rear = null;
            }
            return item;
        }
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            System.out.println("Deleting fail!! Linked Queue is empty!!");
        } else {
            front = front.link;

            if (front == null) {
                rear = null;
            }
        }

    }

    @Override
    public char peek() {
        if (isEmpty()) {
            System.out.println("Peeking fail! Linked Queue is empty!!");
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
                temp = temp.link;
            }
            System.out.println();
            System.out.println();
        }
    }
}