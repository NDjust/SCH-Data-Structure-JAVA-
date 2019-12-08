package FinalPrac;

public class HPSort {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        HeapSort HS = new HeapSort();

        System.out.printf("정렬 전 : ");
        printArray(arr);
        HS.sorting(arr);
        System.out.printf("정렬 후 : ");
        HS.sorting(arr);
        printArray(arr);

    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}


class HeapSort {
    void sorting(int arr[]) {

    }

    void makeHeap(int arr[], int i, int n) {

    }

    int parent(int i) {
        return (i + 1) / 2 - 1;
    }

    int child(int i) {
        return 2 * (i + 1) - 1;
    }
}