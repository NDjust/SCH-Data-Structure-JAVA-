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
        int pivot = (begin + end) / 2;
        int left = begin;
        int right = end;
        int temp;

        while (left < right) {
            while ((a[left] < a[pivot]) && (left < right)) {
                left++;
            }

            while ((a[right] >= a[pivot]) && (right > left)) {
                right--;
            }

            if (right > left) {
                temp = a[left];
                a[left] = a[right];
                a[right] = temp;

                if (left == pivot) {
                    pivot = right;
                }
            }
        }

        // 원소 right와 피봇위치 변경
        temp = a[pivot];
        a[pivot] = a[right];
        a[right] = temp;

        return right;
    }
}