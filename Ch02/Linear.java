package Ch02;

public class Linear {
    public static void main(String[] args) {
        int sale[] = new int[] { 157, 209, 251, 312 };

        for (int i = 0; i < 4; i++) {
            System.out.printf("%d/4분기 : sale[%d] = %d %n", i + 1, i, sale[i]);
        }

    }
}
