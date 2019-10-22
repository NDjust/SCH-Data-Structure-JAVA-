package MidtermPrac;

public class CircularQueue {
    public static void main(String[] args) {
        int queueSize = 4;
        char deletedItem;
        CQueue cQ = new CQueue(queueSize);

        cQ.enQueue('A');
        cQ.printQueue();

        cQ.enQueue('B');
        cQ.printQueue();

        deletedItem = cQ.deQueue();

        if (deletedItem != 0) {
            System.out.println("deleted Item: " + deletedItem);
        }
        cQ.printQueue();

        cQ.enQueue('C');
        cQ.printQueue();

        cQ.enQueue('D');
        cQ.printQueue();

        cQ.enQueue('E');
        cQ.printQueue();

    }
}


class CQueue {
    int front;
    int rear;
    int QueueSize;
    char itemArray[];

    public CQueue(int QueueSize) {
        this.front = 0;
        this.rear = 0;
        this.QueueSize = QueueSize;
        this.itemArray = new char[this.QueueSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (((rear + 1) % this.QueueSize) == front);
    }

    public void enQueue(char data) {
        if (isFull()) {
            System.out.println("꽉 찼어요.");
        } else {
            rear  = (rear + 1) % this.QueueSize;
            itemArray[rear] = data;
        }
    }

    public char deQueue() {
        if (isEmpty()) {
            System.out.println("비어 있어용");
            return 0;
        } else {
            front = (front + 1) % this.QueueSize;
            return itemArray[front];
        }
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("비어 있어요.");
            return 0;
        } else {
            return itemArray[(front + 1) % this.QueueSize];
        }
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Array Circular Queue is empty!!");
        } else {
            System.out.printf("Array Circular Queue>> ");
            for (int i = (front + 1) % this.QueueSize; i != (rear + 1) % this.QueueSize;
                 i = ++i % this.QueueSize) {
                System.out.printf("%c ", itemArray[i]);
            }
            System.out.println();
            System.out.println();
        }
    }

}
