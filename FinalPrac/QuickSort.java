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
        if (begin < end) {
            int pivot;
            pivot = partition(a, begin, end);
            sorting(a, begin, pivot - 1);
            sorting(a, pivot + 1, end);
        }
    }

    public int partition (int a[], int begin, int end){
        int pivot, temp;
        pivot = (begin + end) / 2;
        int left = begin;
        int right = end;

        while (left < right) {
            while ((a[left] < a[pivot]) && (left < right)) {
                left++;
            }

            while ((a[right] >= a[pivot]) && (left < right)) {
                right--;
            }

            if (left < right) {
                temp = a[right];
                a[right] = a[left];
                a[left] = temp;

                if (pivot == left) {
                    pivot = right;
                }
            }
        }

        temp = a[right];
        a[right] = a[pivot];
        a[pivot] = temp;

        return right;
    }
}