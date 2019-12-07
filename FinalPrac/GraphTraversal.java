package FinalPrac;

public class GraphTraversal {
    public static void main(String[] args) {
        AdjMatrix mg1 = new AdjMatrix();

        for (int i = 0; i < 4; i++) {
            mg1.insertVertex(i);
        }

        mg1.insertEdge(0, 3);
        mg1.insertEdge(0, 1);
        mg1.insertEdge(1, 3);
        mg1.insertEdge(1, 2);
        mg1.insertEdge(1, 0);
        mg1.insertEdge(2, 3);
        mg1.insertEdge(2, 1);
        mg1.insertEdge(3, 2);
        mg1.insertEdge(3, 1);
        mg1.insertEdge(3, 0);

        System.out.printf("\n그래프 G1의 인접행렬 : ");
        mg1.printMatrix();;
        System.out.println();

        AdjList lg1 = new AdjList();
        for (int i = 0; i < 4; i++) {
            lg1.insertVertex(i);
        }

        lg1.insertEdge(0, 3);
        lg1.insertEdge(0, 1);
        lg1.insertEdge(1, 3);
        lg1.insertEdge(1, 2);
        lg1.insertEdge(1, 0);
        lg1.insertEdge(2, 3);
        lg1.insertEdge(2, 1);
        lg1.insertEdge(3, 2);
        lg1.insertEdge(3, 1);
        lg1.insertEdge(3, 0);
        System.out.printf("\n 그래프 G1의 인접리스트 : ");
        lg1.printAdjust();
        System.out.println();


        AdjList g9 = new AdjList();

        for (int i = 0; i < 7; i++) {
            g9.insertVertex(i);
        }

        g9.insertEdge(0, 2);
        g9.insertEdge(0, 1);
        g9.insertEdge(1, 4);
        g9.insertEdge(1, 3);
        g9.insertEdge(1, 0);
        g9.insertEdge(2, 4);
        g9.insertEdge(2, 0);
        g9.insertEdge(3, 6);
        g9.insertEdge(3, 1);
        g9.insertEdge(4, 6);
        g9.insertEdge(4, 2);
        g9.insertEdge(4, 1);
        g9.insertEdge(5, 6);
        g9.insertEdge(6, 5);
        g9.insertEdge(6, 4);
        g9.insertEdge(6, 3);
        System.out.printf("\n 그래프 G9의 인접리스트 : ");
        g9.printAdjust();
        System.out.println();

        System.out.printf("\n\n 깊이우선탐색 >> ");
        g9.DFS(0);

        System.out.printf("\n\n 너비우선탐색 >> ");
        g9.BFS(0);

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
            System.out.println("해당 정점은 그래프에 없습니다!");
            return;
        } else {
            matrix[v1][v2] = 1;
        }

    }

    public void printMatrix() {
        System.out.println();
        for (int i = 0; i < totalV; i++) {
            for (int j = 0; j < totalV; j++) {
                System.out.printf("%2d ", matrix[i][j]);
            }
            System.out.printf("\n");
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
            System.out.println("삭제할 노드가 없습니다!!");
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
            System.out.println("Deleting is fail! Queue is Empty!!");
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
        if (v1 >= totalV && v2 >= totalV) {
            System.out.println("해당 점점은 그래프에 없습니다!");
        } else {
            GraphNode newNode = new GraphNode();
            newNode.vertex = v2;
            newNode.link = head[v1];
            head[v1] = newNode;
        }

    }

    public void printAdjust() {
        for (int i = 0; i < totalV; i++) {
            System.out.printf("\n정점 %c의 인접리스트 ", i + 65);
            GraphNode w = head[i];
            while (w != null) {
                System.out.printf("-> %c", w.vertex + 65);
                w = w.link;
            }
        }


    }

    public void DFS(int v) {
        GraphNode w = new GraphNode();
        boolean visited[] = new boolean[10];
        LinkedStack S = new LinkedStack();
        visited[v] = true;

        S.push(v);
        System.out.printf(" %c", v + 65);

        while (!S.isEmpty()) {
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
        boolean visited[] = new boolean[10];
        LinkedQueue Q = new LinkedQueue();
        visited[v] = true;

        Q.enQueue(v);
        System.out.printf(" %c", v + 65);

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

