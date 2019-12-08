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

    }

    public void swap(int arr[], int a, int b) {

    }
}