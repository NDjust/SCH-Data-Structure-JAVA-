package Ch14;

public class heapSort {
    public static void main (String[] args) {
        int arr[] = {12, 11, 14, 5, 6, 7};
        HeapSort HS = new HeapSort();
        System.out.printf("정렬 전 : ");
        printArray(arr);
        HS.Sorting(arr);
        System.out.printf("정렬 후 : ");
        printArray(arr);
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}

class HeapSort {
    void Sorting(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            makeHeap(arr, i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            makeHeap(arr, 0, i);
        }
    }

    void makeHeap(int arr[], int i, int n) {
        int j;
        int temp = arr[i];

        for (j = child(i); j <= n; j = child(j)) {
            if ((j < n - 1) && (arr[j] < arr[j + 1])) {
                j++;
            }

            if (arr[i] >= arr[j]) {
                break;
            } else {
                arr[parent(j)] = arr[j];
            }
        }
        arr[parent(j)] = temp;
    }

    int parent(int i) {
        return (i + 1) / 2 - 1;
    }

    int child(int i) {
        return 2 * (i + 1) - 1;
    }
}