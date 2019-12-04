package FinalPrac;

public class GraphTraversal {
    public static void main(String[] args) {
        AdjList MG1 = new AdjList();

        for (int i = 0; i < 7; i++) {
            MG1.insertVertex(i);
        }
        MG1.insertEdge(0, 2);
        MG1.insertEdge(0, 1);
        MG1.insertEdge(1, 4);
        MG1.insertEdge(1, 3);
        MG1.insertEdge(1, 0);
        MG1.insertEdge(2, 4);
        MG1.insertEdge(2, 0);
        MG1.insertEdge(3, 6);
        MG1.insertEdge(3, 1);
        MG1.insertEdge(4, 6);
        MG1.insertEdge(4, 2);
        MG1.insertEdge(4, 1);
        MG1.insertEdge(5, 6);
        MG1.insertEdge(6, 5);
        MG1.insertEdge(6, 4);
        MG1.insertEdge(6, 3);

        System.out.printf("\n 그래프 G9의 인접행렬: ");
        MG1.printAdjust();
        System.out.println();

        System.out.printf("\n\n 깊이 우선 탐색 >> ");
        MG1.DFS(0);

        System.out.printf("\n\n 너비 우선 탐색 >> ");
        MG1.BFS(0);

        AdjList LG1 = new AdjList();

        for (int i = 0; i < 4; i ++) {
            LG1.insertVertex(i);
        }

        LG1.insertEdge(0, 3);
        LG1.insertEdge(0, 1);
        LG1.insertEdge(1, 3);
        LG1.insertEdge(1, 2);
        LG1.insertEdge(1, 0);
        LG1.insertEdge(2, 3);
        LG1.insertEdge(2, 1);
        LG1.insertEdge(3, 2);
        LG1.insertEdge(3, 1);
        LG1.insertEdge(3, 0);
        System.out.printf("\n 그래프 G1의 인접리스트 : ");
        LG1.printAdjust();
        System.out.println();
    }
}

class AdjMatrix {
    private int matrix[][] = new int[10][10];
    private int totalV = 0;

    public void insertVertex(int v) {
        totalV++;
    }

    public void insertEdge(int v1, int v2) {
        if (v1 >= totalV || v2 >= totalV) {
            System.out.println("그래프에 없는 정점입니다!!");
        } else {
            matrix[v1][v2] = 1;
        }
    }

    public void printMatrix() {
        for (int i = 0; i < totalV; i++) {
            System.out.printf("\n\t\t");
            for (int j = 0; j < totalV; j++) {
                System.out.printf("%2d", matrix[i][j]);
            }
        }
    }
}
class StackNode {
    int data;
    StackNode link;
}

class LinkedStack {
    StackNode top;

    public boolean isEmpty() {
        return (top == null);
    }

    public void push(int item) {
        StackNode newNode = new StackNode();
        newNode.data = item;
        newNode.link = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Deleting fail! Linked Stack is Empty!");
            return 0;
        } else {
            int item = top.data;
            top = top.link;
            return item;
        }
    }
}

class QNode {
    int data;
    QNode link;
}

class LinkedQueue {
    QNode front;
    QNode rear;

    public LinkedQueue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public void enQueue(int item) {
        QNode newNode = new QNode();
        newNode.data = item;
        newNode.link = null;

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.link = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Deleting fail! Queue is empty!!");
            return 0;
        } else {
            int item = front.data;
            front = front.link;

            if (front == null) {
                rear = null;
            }
            return item;
        }
    }
}


class GraphNode {
    int vertex;
    GraphNode link;
}


class AdjList {
    private GraphNode head[] = new GraphNode[10];
    private int totalV = 0;

    public void insertVertex(int v) {
        totalV++;
    }

    public void insertEdge(int v1, int v2) {
        if (v1 >= totalV || v2 >= totalV) {
            System.out.println("그래프에 없는 정점입니다!!");
        } else {
            GraphNode gNode = new GraphNode();
            gNode.vertex = v2;
            gNode.link = head[v1];
            head[v1] = gNode;
        }
    }

    public void printAdjust() {
        GraphNode gNode = new GraphNode();
        for (int i = 0; i < totalV; i++) {
            System.out.printf("\n 정점 %c 인접리스트", i + 65);
            gNode = head[i];

            while (gNode != null) {
                System.out.printf("-> %c", gNode.vertex + 65);
                gNode = gNode.link;
            }
        }
    }

    public void DFS(int v) {
        GraphNode w = new GraphNode();
        LinkedStack S = new LinkedStack();
        boolean visited[] = new boolean[10];

        S.push(v);
        visited[v] = true;

        System.out.printf(" %c", v + 65);

        while (S.top != null) {
            w = head[v];
            while (w != null) {
                if (visited[w.vertex] == false) {
                    S.push(w.vertex);
                    visited[w.vertex] = true;
                    System.out.printf(" %c", w.vertex + 65);
                    v = w.vertex;
                    w = head[v];
                } else {
                    w = w.link;
                }
            }
            v = S.pop();
        }
    }

    public void BFS(int v) {
        GraphNode w = new GraphNode();
        LinkedQueue Q = new LinkedQueue();
        boolean visited[] = new boolean[10];

        System.out.printf(" %c", v + 65);
        Q.enQueue(v);

        while (!Q.isEmpty()) {
            v = Q.dequeue();

            for (w = head[v]; w != null; w = w.link) {
                if (visited[w.vertex] == false) {
                    visited[w.vertex] = true;
                    System.out.printf(" %c", w.vertex + 65);
                    Q.enQueue(w.vertex);
                }
            }
        }
    }
}

