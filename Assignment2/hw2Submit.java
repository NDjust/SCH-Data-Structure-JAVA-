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
            col.m_coloring(AL, 0);
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
        if (v1 >= totalV && v2 >= totalV) {
            System.out.println("해당하는 정점이 존재하지 않습니다!!");
            return;
        } else {
            Node newNode = new Node();
            newNode.vertex = v2;
            newNode.next = head[v1];
            head[v1] = newNode;
        }

    }

    public void printAdjust() {
        Node node = new Node();
        for (int i = 0; i < totalV; i++) {
            node = head[i];
            System.out.printf("\n정접 %c의 인접리스트 : ", i + 65);
            while (node != null) {
                System.out.printf("-> %c", node.vertex + 65);
                node = node.next;
            }
        }
    }
}

class Color {
    int N;
    int m;
    int count = 0;
    int[] vcolor = new int[10]; // 원본 파일을 지워도 null pointer 에러가 나서 초기화.

    public void m_coloring(AdjList nodes, int i) {
        int color;

        if (valid(nodes, i)) {
            if (N == i) {
                count = N;
                return;
            } else {
                for (color = 1; color <= m; color++) {
                    vcolor[i + 1] = color;
                    m_coloring(nodes, i + 1);
                }
            }
        }

    }

    public boolean valid(AdjList nodes, int i) {
        Node node = new Node();
        node = nodes.head[i];

        while (node != null) {
            // node vertex 체크.
            if (node.vertex < i && vcolor[i] == vcolor[node.vertex]) { // 해당 노드에 인접한 노드들 점검.
                return false;
            } else {
                node = node.next;
            }
        }
        return true;
    }
}