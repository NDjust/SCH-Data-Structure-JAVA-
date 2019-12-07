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

        Union_Find UF = new Union_Find();

        UF.unionParent(parent, 1, 2);
        UF.unionParent(parent, 2, 3);
        UF.unionParent(parent, 3, 4);
        UF.unionParent(parent, 5, 6);
        System.out.println(UF.findParent(parent, 1, 5));
        UF.unionParent(parent, 6, 7);
        System.out.println(UF.findParent(parent, 1, 5));
        System.out.println(UF.findParent(parent, 5, 7));
        UF.unionParent(parent, 7, 8);
        System.out.println(UF.findParent(parent, 1, 5));
        System.out.println(UF.findParent(parent, 5, 7));
        UF.unionParent(parent, 1, 7);

        System.out.println(UF.findParent(parent, 1, 5));


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

class Union_Find {
    public int getParent(int[] parent, int x) {
        // 특정 점점의 부모 정점을 찾기 (루트가 나올 때까지 재귀호출 반복)
        if (parent[x] == x) { // 자기 자신이 부모일 경우.
            return x;
        }

        return parent[x] = getParent(parent, parent[x]);
    }

    public void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        // 두 부모 정점 중 작은 값을 큰 값의 부모노드로 저장.
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public int findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        // 두 정점의 부모 정점이 일치하면 연결
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
        node[0] = a;
        node[1] = b;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge C) {
        if (this.distance < C.distance) {
            return -1;
        } else if (this.distance > C.distance) {
            return 1;
        }
        return 0;
    }
}

class Kruskal { // union find
    public int getParent(int[] arr, int x) {
        if (arr[x] == x) {
            return x;
        } else {
            return arr[x] = getParent(arr, arr[x]);
        }

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