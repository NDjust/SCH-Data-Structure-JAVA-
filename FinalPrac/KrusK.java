package FinalPrac;

import java.util.*;

public class KrusK {
    public static void main(String[] args) {
        int v = 7;
        int e = 11;

        int parent[] = new int[11];

        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        Kruskal KK = new Kruskal();

        KK.unionParent(parent, 1, 2);
        KK.unionParent(parent, 2, 3);
        KK.unionParent(parent, 3, 4);
        KK.unionParent(parent, 5, 6);
        KK.unionParent(parent, 6, 7);
        KK.unionParent(parent, 7, 8);
        KK.unionParent(parent, 1, 7);

        System.out.println(KK.findParent(parent, 1, 5));


        ArrayList<Edge> arr = new ArrayList<>();
        arr.add(new Edge(1, 7, 12));
        arr.add(new Edge(1, 4 ,28));
        arr.add(new Edge(1, 2, 67));
        arr.add(new Edge(1, 5, 17));
        arr.add(new Edge(2, 4, 24));
        arr.add(new Edge(2, 5 ,62));
        arr.add(new Edge(3, 5 ,20));
        arr.add(new Edge(3, 6, 37));
        arr.add(new Edge(4, 7, 13));
        arr.add(new Edge(5, 6, 45));
        arr.add(new Edge(5, 7, 73));
        arr.add(new Edge(1, 7, 12));

        Collections.sort(arr);

        int parents[] = new int[v];
        int total_distance = 0;

        for (int i = 0; i < parents.length; i++) {
            parents [i] = i;
        }

        Kruskal kk = new Kruskal();

        for (int i = 0; i < arr.size(); i++) {
            // 루트가 서로 다르면
            if (kk.findParent(parents, arr.get(i).node[0] - 1, arr.get(i).node[1] - 1) == 0) {
                total_distance += arr.get(i).distance;
                kk.unionParent(parents, arr.get(i).node[0] - 1, arr.get(i).node[1] - 1);
            }
        }
        System.out.println(total_distance);
    }
}

class Edge implements Comparable<Edge> {
    int node[] = new int[12];
    int distance;

    public Edge (int a, int b, int distance) {
        this.node[0] = a;
        this.node[1] = b;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge c) {
        if (this.distance < c.distance) {
            return -1;
        } else if (this.distance > c.distance) {
            return 1;
        }
        return 0;
    }
}

class Kruskal { // union find
    public int getParent(int[] arr, int x) {
        if (arr[x] == x ) {
            return x;
        }
        return arr[x] = getParent(arr, arr[x]);
    }

    public void unionParent(int[] arr, int a, int b) {
        a = getParent(arr, a);
        b = getParent(arr, b);

        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }

    public int findParent(int[] arr, int a, int b) {
        a = getParent(arr, a);
        b = getParent(arr, b);

        if (a == b) {
            return 1;
        } else {
            return 0;
        }
    }
}