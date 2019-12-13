package Ch14;

public class TreeS {
    public static void main(String[] args) {
        int[] arr = { 50, 30, 70, 15, 7, 62, 22, 35, 87, 31 };
        TreeSort TS = new TreeSort(arr[0]);

        System.out.printf("정렬 전 : ");
        printArray(arr);
        TS.Sorting(arr);
        System.out.printf("정렬 후 : ");
        printArray(arr);

    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node (int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
class TreeSort {
    Node node;

    TreeSort(int value) {
        node = new Node(value);
    }
    int count = 0;

    public void Sorting(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            insertBST(node, arr[i]);
        }
        inOrder(node, arr);
    }

    public Node insertBST(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insertBST(node.left, value);
        } else if (value > node.value) {
            node.right = insertBST(node.right, value);
        }

        return node;
    }

    public void inOrder(Node node, int arr[]) {
        if (node != null) {
            inOrder(node.left, arr);
            arr[count++] = node.value;
            inOrder(node.right, arr);
        }
    }

}