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
        System.out.printf("\n정렬한 원소 : ");
        S.ShellSorting(a, size);
        for (int i = 0; i < a.length; i++) {
            System.out.printf(" %d", a[i]);
        }

    }
}

class ShellSort {
    public void IntervalSort(int a[], int begin, int end, int interval) {


    }

    public void ShellSorting(int a[], int size) {

    }
}
