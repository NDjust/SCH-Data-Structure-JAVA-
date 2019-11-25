package Ch13;

import java.util.ArrayList;
import java.util.Collections;

public class KrusKalPrac {
    public static void main(String[] args) {
        int v= 7;
        int c = 11;

        ArrayList<Edge> arr = new ArrayList<>();

        arr.add(new Edge(1, 7, 12));
        arr.add(new Edge(1, 4, 28));
        arr.add(new Edge(1, 2, 67));
        arr.add(new Edge(1, 5, 17));
        arr.add(new Edge(2, 4, 24));
        arr.add(new Edge(2, 5, 62));
        arr.add(new Edge(3, 5, 20));
        arr.add(new Edge(3, 6, 37));
        arr.add(new Edge(4, 7, 13));
        arr.add(new Edge(5, 6, 45));
        arr.add(new Edge(5, 7, 73));
        arr.add(new Edge(1, 7, 21));

        Collections.sort(arr);

        int parent[] = new int[v];
        int total_distance = 0;

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        Kruskal kk = new Kruskal();

        for (int i = 0; i < arr.size(); i++) {
            if (kk.findParent(parent, arr.get(i).node[0] - 1, arr.get(i).node[1] - 1) == 0) {
                total_distance += arr.get(i).distance;
                kk.unionParent(parent, arr.get(i).node[0] - 1, arr.get(i).node[1] - 1);
            }
        }
        System.out.println(total_distance);
    }
}


class Kruskal {
    public int getParent(int[] parent, int x) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = getParent(parent, parent[x]);
    }

    public void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public int findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        if (a == b) {
            return 1;
        } else {
            return 0;
        }
    }
}

class Edge implements Comparable<Edge> {
    int node[] = new int[2];
    int distance;

    public Edge(int a, int b, int distance) {
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

