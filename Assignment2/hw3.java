package Assignment2;


class SingleSourceShortestPath {
    // 최단 경로 트리에 아직 포함되지 않은 정점들의 집합에서 출발 정점으로부터 최소 거리에 있는 정점을 찾음
    static int findMinDistance(int d[], boolean T[], int n) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int v = 0; v < n; v++) {
            if (T[v] == false && d[v] <= min) {
                min = d[v];
                min_index = v;
            }
        }
        return min_index;
    }
    // 모든 정점에 대해, 출발 정점으로부터 각 정점까지 최단 경로를 거리와 함께 출력
    static void printShortestPath(int d[], int p[], int n) {

    }

    static void dijkstra(int W[][], int src, int n) {
        int d[] = new int[n];
        boolean T[] = new boolean[n];
        int p[] = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = Integer.MAX_VALUE;
            T[i] = false;
            p[i] = -1;
        }
        d[src] = 0;

        for (int count = 0; count < n -1; count++) {
            int u = findMinDistance(d, T, n);
            T[u] = true;
        }
        printShortestPath(d, p, n);
    }

}

public class hw3 {
    public static void main(String[] args) {
        final int INF = 9999;
        int W[][] = new int[][] {{0, 2, INF, INF, 7}, {2, 0, 5, INF, 1}, {INF, 5, 0, 4, 3}, {INF, INF, 4, 0, 6}, {7, 1, 3, 6, 0}};
        SingleSourceShortestPath.dijkstra(W, 0 ,5);

    }
}

