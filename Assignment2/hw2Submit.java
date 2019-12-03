package Assignment2;

public class hw2Submit {
    public static void main(String[] args) {
        Color col = new Color();
        AdjList AL = new AdjList();

        for (int i = 0; i < 5; i++) {
            AL.insertVertex(i);
        }

        // Set up Graph
        AL.insertEdge(0, 4);
        AL.insertEdge(0, 3);
        AL.insertEdge(0, 1);

        AL.insertEdge(1, 3);
        AL.insertEdge(1, 2);
        AL.insertEdge(1, 0);
        AL.insertEdge(2, 3);
        AL.insertEdge(2, 1);
        AL.insertEdge(3, 4);
        AL.insertEdge(3, 2);
        AL.insertEdge(3, 1);
        AL.insertEdge(3, 0);
        AL.insertEdge(4, 3);
        AL.insertEdge(4, 0);

        AL.printAdjust();

        col.N = 5;
        col.m = 0;

        do {
            col.m += 1;
            col.m_coloring(AL.head, 0);
        } while (col.count != col.N);
        System.out.println("\nGraph Coloring 에 필요한 최소 색깔 수: " + col.m);

    }
}

class Node {
    int vertex;
    Node next;
}


class AdjList {
    public Node head[] = new Node[10];
    private int totalV = 0;

    public void insertVertex(int v) {
        totalV++;
    }

    public void insertEdge(int v1, int v2) {
        if (v1 >= totalV || v2 >= totalV) {
            System.out.println("그래프에 없는 정점입니다!!");
        } else {
            Node gNode = new Node();
            gNode.vertex = v2;
            gNode.next = head[v1];
            head[v1] = gNode;
        }
    }

    public void printAdjust() {
        Node gNode = new Node();
        for (int i = 0; i < totalV; i++) {
            System.out.printf("\n 정점 %d 인접리스트", i + 1);
            gNode = head[i];

            while (gNode != null) {
                System.out.printf("-> %d", gNode.vertex + 1);
                gNode = gNode.next;
            }
        }
    }
}

class Color {
    int N;
    int m;
    int count = 0;
    int[] vcolor = new int[10]; // 원본 파일을 지워도 null pointer 에러가 나서 초기화.

    public void m_coloring(Node[] nodes, int i) {
        int color;

        if (valid(nodes, i)) {
            if (i == N) { // 정점을 모두 검사했으면 종료.
                count = N;
                return;
            } else {
                for (color = 1; color <= m; color++) { // 반복할 때 마다 모든 컬러를 넣어봄.
                    vcolor[i + 1] = color;
                    m_coloring(nodes, i + 1);
                }
            }
        }
    }

    public boolean valid(Node[] nodes, int i) {
        int j = 1;
        while (j < i) {
            if (nodes[i - 1] != null && vcolor[i] == vcolor[j]) {
                return false;
            }

            if (nodes[i - 1].next == null) { // 인접 행렬이 없을 때 break.
                break;
            }

            nodes[i - 1] = nodes[i - 1].next;
            j++;
        }
        return true;
    }
}