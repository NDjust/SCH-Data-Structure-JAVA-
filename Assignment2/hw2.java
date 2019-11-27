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
        int color;

        if (valid(G, i)) {
            if (i == N) { // 정점을 모드 검사했으면 종료.
                count = N;
                return;
            } else {
                for (color = 1; color <= m; color++) { // 반복할 때 마다 모든 컬러를 넣어봄.
                    vcolor[i + 1] = color;
                    System.out.println(vcolor[i + 1]);
                    m_coloring(G, i + 1);
                }
            }
        }
    }

    public boolean valid(int G[][], int i) {
        int j = 1;
        while (j < i) {
            // System.out.println(G[i - 1][j - 1]);
            // System.out.println(vcolor[i]);
            // System.out.println(vcolor[j]);
            if (G[i - 1][j - 1] == 1 && vcolor[i] == vcolor[j]) {
                // 인접한 정점인가? && 인접한 정점이 현재 select 한 컬러와 똑같은가?
                return false; // 그렇다면 select 한 컬러는 답이 될 수 없음.
            }
            j++;
        }
        return true;
    }
}
