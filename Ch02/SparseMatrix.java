package Ch02;

public class SparseMatrix {
    public static void main(String[] args) {
        // {{2, 0, 3}, {0, 0, 7}}
        int A[][] = new int[][] { {2, 3, 3},
                                  {0, 0, 2},
                                  {0, 2, 3},
                                  {1, 2, 7} };
        int AT[][] = new int[4][3];
        SparseMatrix SM = new SparseMatrix();
        AT = SM.transposeSM(A);

        System.out.printf("A = %n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d ", A[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.printf("A^T = %n");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d ", AT[i][j]);
            }
            System.out.println();
        }

    }

    public int[][] transposeSM(int[][] A) {
        int m = A[0][0];
        int n = A[0][1];
        int v = A[0][2];
        int[][] B = new int[v + 1][3];
        B[0][0] = n;
        B[0][1] = m;
        B[0][2] = v;

        if (v > 0) {
            int p = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= v; j++) {
                    if (A[j][1] == i) {
                        B[p][0] = A[j][1];
                        B[p][1] = A[j][0];
                        B[p][2] = A[j][2];
                        p++;
                    }
                }
            }
        }
        return B;
    }
}
