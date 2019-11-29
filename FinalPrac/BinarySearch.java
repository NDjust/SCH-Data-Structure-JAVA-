package FinalPrac;


class Node {
    int key;
    char data;
    Node left;
    Node right;

    public StringBuilder inorder() {
        StringBuilder traversal = new StringBuilder();
        if (this.left != null) {
            traversal.append(this.left.inorder());
        }

        if (this.right != null) {
            traversal.append(this.right.inorder());
        }
        return traversal;
    }

    public Node[] lookup(int key, Node parent) {
        Node[] KeyParent = new Node[2];
        if (key < this.key) {
            if (this.left != null) {
                return this.left.lookup(key, this);
            } else {
                KeyParent[0] = null;
                KeyParent[1] = null;
                return KeyParent;
            }
        } else if (key > this.key) {
            if (this.right != null) {
                return this.right.lookup(key, this);
            } else {
                KeyParent[0] = null;
                KeyParent[1] = null;
                return KeyParent;
            }
        } else {
            KeyParent[0] = this;
            KeyParent[1] = parent;
            return KeyParent;
        }
    }

    public int countChildren() {
        int count = 0;

        if (this.left != null) {
            count += 1;
        }

        if (this.right != null) {
            count += 1;
        }
        return count;
    }
}

class BinarySearchTree {
    private Node root = new Node();

    public Node insertKey(Node root, char x) {
        Node p = root;
        Node  newNode = new Node();
        newNode.data = x;
        newNode.left = null;
        newNode.right = null;

        if (p == null) {
            return newNode;
        } else if (newNode.data < p.data){
            p.left = insertKey(p.left, x);
            return p;
        } else if (newNode.data > p.data) {
            p.right = insertKey(p.right, x);
            return p;
        } else {
            return p;
        }
    }

    public Node[] lookup(int key, Node parent) {
        if (this.root != null) {
            return this.root.lookup(key, parent);
        } else {
            Node[] empty = new Node[2];
            return empty;
        }
    }

    public boolean remove(int key) {
        Node[] NodeParent = this.lookup(key, null);
        Node node = NodeParent[0];
        Node parent = NodeParent[1];

        System.out.println(node);
        System.out.println(parent);

        int Countchild = node.countChildren();

        if (node != null) {
            if (Countchild == 0) {
                if (parent != null) {
                    if (parent.key > key) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } else if (Countchild == 1) {
                Node node_child = new Node();
                if (node.left != null) {
                     node_child = node.left;
                } else {
                    node_child = node.right;
                }

                if (parent != null) {
                    if (parent.key > key) {
                        parent.left = node_child;
                    } else {
                        parent.right = node_child;
                    }
                } else {
                    this.root = node_child;
                }
            } else {
                Node successor = new Node();
                parent = node;
                successor = parent.right;

                while (successor.left != null) {
                    parent = successor;
                    successor = successor.left;
                }

                node.key = successor.key;
                node.data = successor.data;

                if (parent.key > successor.key) {
                    parent.left = successor.left;
                } else if (parent.key < successor.key) {
                    parent.right = successor.right;
                }
            }
            return true;
        } else {
            return false;
        }
    }


    public void insertBST(char x) {
        root = insertKey(root, x);
    }

    public Node searchBST(char x) {
        Node p = root;

        while (p != null) {
            if (x < p.data) {
                p = p.left;
            } else if (x > p.data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return p;
    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.printf(" %c", root.data);
            inorder(root.right);
        }
    }

    public void printBST() {
        inorder(root);
        System.out.println();
    }
}

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearchTree bsT = new BinarySearchTree();
        bsT.insertBST('G');
        bsT.insertBST('I');
        bsT.insertBST('H');
        bsT.insertBST('D');
        bsT.insertBST('B');
        bsT.insertBST('M');
        bsT.insertBST('N');
        bsT.insertBST('A');
        bsT.insertBST('J');
        bsT.insertBST('E');
        bsT.insertBST('Q');

        System.out.printf("\nBinary Tree >>> ");
        bsT.printBST();

        bsT.remove('A');
        System.out.printf("\nBinary Tree >>> ");
        bsT.printBST();


        System.out.printf("Is there \"A\" ? >>> ");
        Node p1 = bsT.searchBST('A');

        if (p1 != null) {
            System.out.printf("Searching Success! Searched key : %c \n", p1.data);
        } else {
            System.out.printf("Searching fail! There is no %c \n", p1.data);
        }

        System.out.printf("Is there \"Z\" ? >>> ");
        Node p2 = bsT.searchBST('Z');

        if (p2 != null) {
            System.out.printf("Searching Success! Searching key: %c \n", p2.data);
        } else {
            System.out.printf("Searching fail! \n");
        }
    }
}
