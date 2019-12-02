package Ch14;

public class bubbleSort {
    public static void main(String args[]) {
        int a[] = { 69, 10, 30, 2, 16, 8, 21, 22 };

        bubbleSort bs = new bubbleSort();

        System.out.printf("\n정렬할 원소 : ");

        for (int i = 0; i < a.length; i++) {
            System.out.printf(" %d", a[i]);
        }
        bs.bubblesort(a);
    }

    public void bubblesort(int a[]) {
        int i, j, temp, size;

        size = a.length;

        for (i = size - 1; i > 0; i--) {
            System.out.printf("\n버블 정렬 %d 단계 : ", size - 1);

            for (j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
                System.out.printf("\n\t");

                for (int k = 0; k < size; k++) {
                    System.out.printf("3%d ", a[k]);
                }
            }
        }
    }
}
