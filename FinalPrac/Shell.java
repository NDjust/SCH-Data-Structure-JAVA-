package FinalPrac;

public class Shell {
    public static void main(String args[]) {
        int a[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
        int size = a.length;


        ShellSort S = new ShellSort();
        System.out.printf("\n정렬할 원소 : ");

        for (int i = 0; i < a.length; i++) {
            System.out.printf(" %d", a[i]);
        }

        System.out.println();
        S.ShellSorting(a, size);

    }
}

class ShellSort {
    public void IntervalSort(int a[], int begin, int end, int interval) {
        int i, j, temp;

        for (i = begin + interval; i <= end; i = i + interval) {
            temp = a[i];

            for (j = i - interval; j >= begin && temp < a[j]; j -= interval) {
                a[j + interval] = a[j];
            }
            a[j + interval] = temp;
        }
    }

    public void ShellSorting(int a[], int size) {
        int i, j, interval, t = 0;
        interval = size/2;

        while (interval >= 1) {
            for (i = 0; i < interval; i++) {
                IntervalSort(a, i, size - 1, interval);
            }
            System.out.printf("\n 쉘 정렬 %d 단계 : interval = %d >> ", ++t, interval);
            for (j = 0; j < size; j++) {
                System.out.printf("%d  ", a[j]);
            }
            System.out.println();
            interval /= 2;
        }

    }
}
