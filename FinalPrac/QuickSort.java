package FinalPrac;

public class QuickSort {
    public static void main(String args[]) {

            int a[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
            int size = a.length - 1;
            quickSorting S = new quickSorting();
            System.out.printf("\n정렬할 원소 : ");

            for (int i = 0; i <= size; i++) {
                System.out.printf(" %d", a[i]);
            }
            System.out.println();
            S.sorting(a, 0, size);

            System.out.printf("\n 정렬한 원소 : ");
            for (int i = 0; i <= size; i++) {
                System.out.printf(" %d", a[i]);
            }
            System.out.println();
    }
}

class quickSorting {
    int i = 0;
    public void sorting(int a[], int begin, int end) {

    }

    public int partition (int a[], int begin, int end){
        return 1;
    }
}