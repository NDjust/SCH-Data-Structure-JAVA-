package FinalPrac;

public class SelectSort {
    public static void main(String args[]) {
        int a[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
        SelectionSort S = new SelectionSort();
        System.out.printf("\n정렬할 원소 : ");

        for (int i = 0; i < a.length; i++) {
            System.out.printf(" %d", a[i]);
        }
        S.SelectionSorting(a);

        System.out.printf("\n정렬한 원소 : ");
        for (int i = 0; i < a.length; i++) {
            System.out.printf(" %d", a[i]);
        }

    }
}

class SelectionSort {
    public void SelectionSorting(int a[]) {
        int i, j, min;
        min = 0;

        for (i = 0; i < a.length - 1; i++) {
            for (j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
                swap(a, min, i);
            }
        }
    }

    public void swap(int arr[], int a, int b) {
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}