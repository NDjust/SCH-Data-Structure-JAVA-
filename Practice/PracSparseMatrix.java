package Practice;

public class PracSparseMatrix {
    public static void main(String[] args) {
        int a[][] = new int[][] { {3, 2, 4}, {1, 2, 3}, {2, 0, 6}, {3, 2, 7}, {2, 5, 5}};
        int AT[][] = new int[5][3];
        PracSparseMatrix sparse = new PracSparseMatrix();
        AT = sparse.TransposeMatrix(a);

        System.out.println("a행렬");
        for (int i = 0; i < 5; i++) {
                System.out.printf("%d %d %d %n", a[i][0], a[i][1], a[i][2]);
            }

        System.out.println();

        for (int i = 0; i < 5; i ++) {
                System.out.printf("%d %d %d %n", AT[i][0], AT[i][1], AT[i][2]);
            }

    }

    public int[][] TransposeMatrix(int[][] a) {
        int m = a[0][0];
        int n = a[0][1];
        int v = a[0][2];

        int T[][] = new int[v+1][3];
        T[0][0] = n;
        T[0][1] = m;
        T[0][2] = v;
        if (v > 0) {
            int p = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= v; j++) {
                    if (a[j][1] == i) {
                        T[p][0] = a[j][1];
                        T[p][1] = a[j][0];
                        T[p][2] = a[j][2];
                        p++;
                    }
                }
            }

        }
        return T;
    }


}
