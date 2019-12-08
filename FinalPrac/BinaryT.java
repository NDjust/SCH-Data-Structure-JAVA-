package FinalPrac;

public class BinaryT {

    public static void main(String args[]) {
        LinkedT tt = new LinkedT();

        TreeNode n1 = tt.makeBT(null, 'A', null);
        TreeNode n2 = tt.makeBT(null, 'B', null);
        TreeNode n3 = tt.makeBT(null, 'C', null);
        TreeNode n4 = tt.makeBT(null, 'D', null);
        TreeNode n5 = tt.makeBT(n1, '*', n2);
        TreeNode n6 = tt.makeBT(n3, '/', n4);
        TreeNode root = tt.makeBT(n5, '-', n6);

        System.out.println("PreOrder Result");
        tt.preorder(root);
        System.out.println("\nInOrder Result");
        tt.inorder(root);
        System.out.println("\nPostOrder Result");
        tt.postorder(root);

    }

}



class LinkedT {

    private TreeNode root;

    public TreeNode makeBT(TreeNode bt1, Object data, TreeNode bt2) {
        TreeNode newNode = new TreeNode();
        newNode.data = data;
        newNode.left = bt1;
        newNode.right = bt2;

        return newNode;
    }

    public void preorder(TreeNode root) {
        if (root != null) {
            System.out.printf(" %c", root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.printf(" %c", root.data);
            inorder(root.right);
        }
    }

    public void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.printf(" %c", root.data);
        }
    }
}