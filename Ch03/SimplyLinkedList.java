package Ch03;

public class SimplyLinkedList {
    public static void main(String[] args) {
        LinkedList L = new LinkedList();
        System.out.println("(1) 공백 리스트에 노드 3개 삽입하기");
        L.insertLastNode("월");
        L.insertLastNode("수");
        L.insertLastNode("일");
        L.printList();

        System.out.println("(2) 수 노드 뒤에 금 노드 삽입하기");
        Node pre = L.searchNode("수");

        if (pre == null) {
            System.out.println("검색실패 찾는 데이터가 없습니다. ");
        } else {
            L.insertMiddleNode(pre, "금");
            L.printList();
        }

        System.out.println("(3) 리스트의 노드를 역순으로 바꾸기");
        L.reverseList();
        L.printList();

        System.out.println("(4) 리스트의 마지막 노드 삭제하기");
        L.deleteLastNode();
        L.printList();
    }
}

class Node{
    private String data;
    public Node link;

    public Node() {
        this.data = null;
        this.link = null;
    }

    public Node(String data) {
        this.data = data;
        this.link = null;
    }

    public Node(String data, Node link) {
        this.data = data;
        this.link = link;
    }

    public String getData() {
        return this.data;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public void insertMiddleNode(Node pre, String data) {
        Node newNode = new Node(data);
        newNode.link = pre.link;
        pre.link = newNode;
    }

    public void insertLastNode(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            this.head = newNode;
        } else {
            Node temp = head;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
        }
    }

    public void deleteLastNode() {
        Node pre, temp;
        if (head == null) {
            return ;
        }
        if (head.link == null) {
            head = null;
        } else {
            pre = head;
            temp = head.link;
            while (temp.link != null) {
                pre = temp;
                temp = temp.link;
            }
            pre.link = null;
        }
    }

    public Node searchNode(String data) {
        Node temp = this.head;
        while (temp != null) {
            if (data == temp.getData()) {
                return temp;
            } else {
                temp = temp.link;
            }
        }
        return temp;
    }

    public void reverseList() {
        Node next = head;
        Node current = null;
        Node pre = null;
        while (next != null) {
            pre = current;
            current = next;
            next = next.link;
            current.link = pre;
        }
        head = current;
    }

    public void printList() {
        Node temp = this.head;
        System.out.printf("L = (");
        while (temp != null) {
            System.out.printf(temp.getData());
            temp = temp.link;
            if(temp != null) {
                System.out.printf(", ");
            }
        }
        System.out.println(")");
    }
}