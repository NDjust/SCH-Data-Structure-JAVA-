package Assignment2;

public class hw2 {
    public static void main(String[] args) {
        Coloring col = new Coloring();
        col.vcolor = new int[10];

        int graph[][] = {{0, 1, 0, 1, 1},
                         {1, 0, 1, 1, 0},
                         {0, 1, 0, 1, 0},
                         {1, 1, 1, 0, 1},
                         {1, 0, 0, 1, 0}};

        col.N = 5;
        col.m = 0;

        do {
            col.m += 1;
            col.m_coloring(graph, 0);
        } while (col.count != col.N);
        System.out.println("Graph Coloring 에 필요한 최소 색깔 수: " + col.m);

    }
}

class Coloring {
    int N;
    int m;
    int count = 0;
    int[] vcolor; // 각 노드별 색깔 (vertex color)

    public void m_coloring(int G[][], int i) {

        if (valid(G, i)) {
            if (i == N) {
                count = N;
                return;
            } else {
                for (int color = 1; color <= m; color++) {
                    vcolor[i + 1] = color;
                    m_coloring(G, i + 1);
                }
            }
        }

    }

    public boolean valid(int G[][], int i) {
        int j = 1;
        while (j < i) {
            if (G[i - 1][j - 1] == 1 && vcolor[i] == vcolor[j]) {
                return false;
            }
            j++;
        }
        return true;
    }
}
