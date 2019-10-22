package MidtermPrac;

public class Queue {
    public static void main(String[] args) {
        int queueSize = 4;
        char deletedItem;
        LinearQueue cQ = new LinearQueue(queueSize);

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

class LinearQueue {
    int queueSize;
    int front;
    int rear;
    char DataArray[];

    public LinearQueue(int queueSize) {
        this.queueSize = queueSize;
        this.front = -1;
        this.rear = -1;
        this.DataArray = new char[queueSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == queueSize - 1;
    }

    public void enQueue(char data) {
        if (isFull()) {
            System.out.println("꽉 참!!");
        } else {
            DataArray[++rear] = data;
        }
    }

    public char deQueue() {
        if (isEmpty()) {
            System.out.println("비어 있어용");
            return 0;
        } else {
            return DataArray[++front];
        }
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("비어 있어용");
            return 0;
        } else {
            return DataArray[front];
        }
    }


    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Array Circular Queue is empty!!");
        } else {
            System.out.printf("Array Circular Queue>> ");

            for (int i = (front + 1) % this.queueSize; i != (rear + 1) % this.queueSize;
                 i = ++i % this.queueSize) {
                System.out.printf("%c ", DataArray[i]);
            }
            System.out.println();
            System.out.println();
        }
    }

}
