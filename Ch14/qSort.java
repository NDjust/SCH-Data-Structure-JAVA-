package Ch14;

public class qSort {

    int i = 0;

    public int partition(int a[], int begin, int end) {
        int pivot, temp, L, R, t;
        L = begin;
        R = end;
        pivot = (begin + end) / 2;

        System.out.printf("\n [퀵정렬 %d 단계 : pivot=%d ]\n", ++i, a[pivot]);

        while (L < R) {
            while ((a[L] < a[pivot]) && (L < R)) {
                L++;
            }
            while ((a[R] >= a[pivot]) && (L < R)) {
                R--;
            }

            if (L < R) {
                temp = a[L];
                a[L] = a[R];
                a[R] = temp;

                if (L == pivot) {
                    pivot = R;
                }
            }
        }
        temp = a[pivot];
        a[pivot] = a[R];
        a[R] = temp;

        for (t = 0; t < a.length; t++) {
            System.out.printf("%3d  ", a[t]);
        }
        return R;
    }

    public void quickSort(int a[], int begin, int end) {
        if (begin < end) {
            int p;
            p = partition(a, begin, end);
            quickSort(a, begin, p - 1);
            quickSort(a, p + 1, end);
        }
    }

    public static void main(String args[]) {
        int a[] = { 69, 10, 30, 2, 16, 8, 31, 22};
        int size = a.length - 1;

        qSort qs = new qSort();
        System.out.printf("\n 정렬할 원소 : ");
        for (int i = 0; i <= size; i++) {
            System.out.printf(" %d", a[i]);
        }

        System.out.println();
        qs.quickSort(a, 0, size);

    }
}
