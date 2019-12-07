package FinalPrac;

public class BubbleSort {
    public static void main(String args[]) {
        int a[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
        BubbleSorting B = new BubbleSorting();
        System.out.printf("\n정렬할 원소 : ");

        for (int i = 0; i < a.length; i++) {
            System.out.printf(" %d", a[i]);
        }
        B.sorting(a);

        System.out.printf("\n정렬한 원소 : ");
        for (int i = 0; i < a.length; i++) {
            System.out.printf(" %d", a[i]);
        }

    }
}

class BubbleSorting {

    public void sorting(int a[]) {
        int i, j;

        for (i = a.length - 1; i > 0; i--) {
            for (j = 0; j < i; j++) {
                if (a[j + 1] < a[j]) {
                    int temp;
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }

        }
    }
}