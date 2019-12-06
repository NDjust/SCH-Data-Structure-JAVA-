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
            System.out.printf("정점을 초과!!\n");
            return;
        } else {
            matrix[v1][v2] = 1;
        }
    }

    public void printMatrix() {
        for (int i = 0; i < totalV; i++) {
            System.out.printf("\n\t\t");
            for (int j = 0; j < totalV; j++) {
                System.out.printf("%2d ", matrix[i][j]);
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
        return true;
    }

    public void push(int item) {
        StackNode newNode = new StackNode();
        newNode.data = item;

        if (top == null) {
            top = newNode;
            return;
        } else {
            newNode.link = top;
            top = newNode;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Deleting fail! Linked Stack is empty!!");
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
            System.out.println("Deleting fail!! LinkedQueue is Empty!!");
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
            System.out.println("그래프에 없는 정점입니다.");
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
            System.out.printf("\n 정점 %c의 인접리스트 ", i + 65);
            gNode = head[i];
            while (gNode != null) {
                System.out.printf("-> %c", gNode.vertex + 65);
                gNode = gNode.link;
            }
        }


    }

    public void DFS(int v) {
        boolean[] visited = new boolean[totalV];
        GraphNode w = new GraphNode();
        LinkedStack S = new LinkedStack();

        S.push(v);
        visited[v] = true;

       while (S.top == null) {
           w = head[v];
           while (w != null) {
               if (visited[w.vertex] == false) {
                   S.push(w.vertex);
                   visited[w.vertex] = true;
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
        visited[v] = true;
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

