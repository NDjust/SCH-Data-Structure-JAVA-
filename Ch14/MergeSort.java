package Ch14;

public class MergeSort {
    public static void main(String args[]) {
        int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
        int size = a.length;

        MergeSorting S = new MergeSorting();
        System.out.printf("\n정렬할 원소 : ");

        for (int i = 0; i < a.length; i++) {
            System.out.printf(" %d", a[i]);
        }

        System.out.println();
        S.Sort(a, 0, size - 1);
    }
}

class MergeSorting {

    private int sorted[] = new int[30];

    public void merge(int a[], int m, int middle, int n) {
        int i, j, k, t;
        int size = a.length;

        i = m;
        j = middle + 1;
        k = m;

        while (middle >= i && j <= n) {
            if (a[i] <= a[j]) {
                sorted[k] = a[i++];
            } else {
                sorted[k] = a[j++];
            }
            k++;
        }

        if (i > middle) {
            for (t = j; t <= n; t++, k++) {
                sorted[k] = a[t];
            }
        } else {
            for (t = i; t <= middle; t++, k++) {
                sorted[k] = a[t];
            }
        }

        for (t = m; t <= n; t++) {
            a[t] = sorted[t];
        }
        System.out.printf("\n 병합 정렬 >> ");

        for (t = 0; t < size; t++) {
            System.out.printf("%3d ", a[t]);
        }
    }

    public void Sort (int a[], int m, int n){
        int middle;
        if (m < n) {
            middle = (m + n) / 2;
            Sort(a, m, middle);
            Sort(a, middle + 1, n);
            merge(a, m, middle, n);
        }

    }
}