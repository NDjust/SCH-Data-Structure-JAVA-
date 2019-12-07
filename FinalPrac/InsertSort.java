package FinalPrac;

public class InsertSort {
    public static void main(String args[]) {
        int a[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
        int size = a.length - 1;
        InsertionSort S = new InsertionSort();
        System.out.printf("\n정렬할 원소 : ");

        for (int i = 0; i <= size; i++) {
            System.out.printf(" %d", a[i]);
        }
        System.out.println();
        S.InsertionSorting(a, size);

        System.out.printf("\n 정렬한 원소 : ");
        for (int i = 0; i <= size; i++) {
            System.out.printf(" %d", a[i]);
        }
        System.out.println();
    }
}

class InsertionSort {
    public void InsertionSorting(int arr[], int size) {
        int i, j, temp;

        for (i = 1; i < arr.length; i++) {
            temp = arr[i];
            j = i;
            while ((j > 0) && (arr[j - 1] > temp)) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
