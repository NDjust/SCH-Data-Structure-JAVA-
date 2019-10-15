package Ch02;

public class DoubleLinear {
    public static void main(String[] args) {
        int sale[][][] = new int[][][] { { { 63, 84, 140, 130 }, { 157, 209, 251, 312} },
                                        { { 59, 80, 130, 135}, {149, 187, 239, 310} } };
        for (int i = 0; i < 2; i++) {
            System.out.printf("<< %d 팀 >> %n", i + 1);
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 4; k++) {
                    System.out.printf("%d/4 분기 : sale[%d][%d][%d] = %d %n", k + 1, j , i, k, sale[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
