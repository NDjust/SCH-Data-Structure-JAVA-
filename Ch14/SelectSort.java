package Ch14;

public class SelectSort {

    public static void main(String args[]) {
        int a[] = { 69, 10, 30, 2, 16, 8, 31, 22};
        SelectionSort s = new SelectionSort();

        System.out.printf("\n 정렬한 요소 : ");

        for (int i = 0; i < a.length; i++) {
            System.out.printf(" %d", a[i]);
        }
        s.selection(a);

    }
}

class SelectionSort {
    public void selection(int a[]) {
        int i, j, min;

        for (i = 0; i < a.length - 1; i++) {
            min = 0;

            for (j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, min, i);
            System.out.printf("\n 선택 정렬 %d 단계 : ", i + 1);

            for (j = 0; j < a.length - 1; j++) {
                System.out.printf("%d ", a[j]);
            }
        }
    }

    public void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}