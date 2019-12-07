package FinalPrac;

import java.util.ArrayList;

public class Radix {
    public static void main(String[] args) {
        int arr[] = { 177, 45, 75, 90, 802, 24, 2, 66 };
        RadixSort RS = new RadixSort();

        System.out.printf("정렬 전 : ");
        printArray(arr);
        RS.Sorting(arr);
        System.out.printf("정렬 후 : ");
        printArray(arr);

    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class ArrayQueue {
    int front;
    int rear;
    int itemArray[];

    public ArrayQueue(int queueSize) {
        front = 0;
        rear = -1;
        itemArray = new int[queueSize];
    }

    public void enQueue(int item) {
        itemArray[++rear] = item;
    }

    public int deQueue() {
        int tmp = itemArray[front];

        for (int i = 1; i <= rear; i++) {
            itemArray[i - 1] = itemArray[i];
        }
        rear--;
        return tmp;
    }
}

class RadixSort {
    void Sorting(int[] arr) {
        int maxsize = getMaxLength(arr);
        ArrayList<ArrayQueue> bucket = new ArrayList();

        int power = 1;
        int index = 0;

        for (int i = 0; i < 10; i++) {
            bucket.add(new ArrayQueue(10));
        }

        for (int i = 1; i <= maxsize; i++) {
            for (int j = 0; j < arr.length; j++) {
                bucket.get((arr[j] / power) % 10).enQueue(arr[j]);
            }

            for (int k = 0; k < 10; k++) {
                int bucket_num = bucket.get(k).rear;

                for (int n = 0; n <= bucket_num; n++) {
                    arr[index] = bucket.get(k).deQueue();
                    index++;
                }
            }
            index = 0;
            power *= 10;
        }
    }

    int getMaxLength(int[] data) {
        int maxsize = 0;

        for (int i = 0; i < data.length; i++) {
            int length = (int)Math.log10((double)data[i]) + 1;
            if (maxsize < length) {
                maxsize = length;
            }
        }
        return maxsize;
    }
}