package FinalPrac;

import java.lang.invoke.VarHandle;

public class TreeS {
    public static void main(String args[]) {
        int[] arr = {50, 30, 70, 15, 7, 62, 22, 35, 87, 31};
        TreeSort TS = new TreeSort(arr[0]);

        System.out.println("정렬 전 : ");
        printArray(arr);
        TS.Sorting(arr);
        System.out.println("\n정렬 후 : ");
        printArray(arr);

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d", arr[i]);
        }
    }
}

class TNode {
    int data;
    TNode left;
    TNode right;

    TNode (int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }
}
class TreeSort {
    TNode node;
    int count = 0;

    TreeSort(int value) {
        node = new TNode(value);
    }

    public void Sorting(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            insertBST(node, arr[i]);
        }
        inorder(node, arr);
    }
    public TNode insertBST(TNode node, int value) {
        if (node == null) {
            return new TNode(value);
        }

        if (node.data > value) {
            node.right = insertBST(node.right, value);
        } else if (node.data < value) {
            node.left = insertBST(node.left, value);
        }
        return node;
    }

    public void inorder(TNode node, int arr[]) {
        if (node != null) {
            inorder(node.left, arr);
            arr[count++] = node.data;
            inorder(node.right, arr);
        }
    }


}