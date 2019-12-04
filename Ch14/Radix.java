package Ch14;

import java.util.ArrayList;

public class Radix {
    public static void main (String[] args) {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        RadixSort RS = new RadixSort();
        System.out.printf("정렬 전 : ");
        printArray(arr);
        RS.Sorting(arr);
        System.out.printf("정렬 후 : ");
        printArray(arr);
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +  " ");
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
            itemArray[i - 1] = itemArray[i]; // for 문으로 뒤에 있는 요소들을 앞으로 밀어넣음.
        }
        rear--;
        return tmp;
    }
}
class RadixSort {
    int getMaxlength(int[] data) { // 최대 자리수를 구하기 위한 함수.
        int maxsize = 0;

        for (int i = 0; i < data.length; i++) {
            int length = (int)Math.log10((double)data[i]) + 1;

            if (maxsize < length) {
                maxsize = length;
            }
        }
        return maxsize;
    }
    void Sorting(int[] arr) {
        int maxsize = getMaxlength(arr);
        ArrayList<ArrayQueue> bucket = new ArrayList();

        int power = 1;
        int index = 0;

        for (int i = 0; i < 10; i++) {
            bucket.add(new ArrayQueue(10));
        }

        for (int i = 1; i <= maxsize; i++) { // bucket에 넣기.
            for (int j = 0; j < arr.length; j++) {
                bucket.get((arr[j] / power)%10).enQueue(arr[j]);
                // 123 / 10 = 3
                // 123 / 10 % 10 = 2
                // 123 / 100 % 10
                // 위와 같이 power로 반복해서 나눠서 구해줘야 함.
            }

            for (int k = 0; k < 10; k++) { // bucket에서 빼기, 고려할 사항이 많
                int bucket_num = bucket.get(k).rear;
                for (int n = 0; n <= bucket_num; n++) {
                    arr[index] = bucket.get(k).deQueue(); // bucket에 있는 queue의 값들을 순차적으로 뺌.
                    index++;
                }
            }
            index = 0;
            power *= 10;
        }
    }
}