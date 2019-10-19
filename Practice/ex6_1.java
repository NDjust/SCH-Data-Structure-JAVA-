package Practice;

public class ex6_1 {
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
            System.out.println("검색 실패!");
        } else {
            L.insertMiddleNode(pre ,"금");
            L.printList();
        }

        System.out.println("(3) 리스트의 첫 번째에 '토' 추가");
        L.insertFirstNode("토");
        L.printList();

        System.out.println("(4) 리스트의 마지막 노드 삭제하기");
        L.deleteLastNode();
        L.printList();

        System.out.println("(5) 리스트의 중간 노드 '수'삭제");
        L.deleteMiddleNode("수");
        L.printList();

        System.out.println("(6) 리스트의 첫 번째 노드 삭제하기");
        L.deleteFirstNode();
        L.printList();

    }
}

class Node {
    String data;
    Node next;

    public Node () {
        this.data = null;
        this.next = null;
    }

    public Node (String data) {
        this.data = data;
        this.next = null;
    }

    public Node (String data, Node next) {
        this.data = data;
        this.next = next;
    }

    public String getData() {
        return this.data;
    }
}

class LinkedList {
    private Node head;

    LinkedList() {
        head = null;
    }

    public void insertFirstNode(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != head) {
                current = current.next;
            }
            newNode.next = head.next;
            head.next = newNode;
            head = newNode;
        }
    }

    public void insertMiddleNode(Node pre, String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = pre.next;
            pre.next = newNode;
        }
    }

    public void insertLastNode(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = newNode;
        } else {
            Node current = head;

            while (current.next != head) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public Node searchNode(String data) {
        if (head == null) {
            System.out.println("노드가 비어 있습니다.");
            return null;
        } else {
            Node current = head;
            while (current.data != data) {
                current = current.next;
            }
            return current;
        }
    }

    public void deleteFirstNode() {
        if (head == null) {
            return ;
        } else {
            Node current = head;

            while (current.next != head) {
                current = current.next;
            }

            head = current.next.next;
            current.next = head;
        }
    }

    public void deleteLastNode() {

        if (head == null) {
            return ;
        } else {
            Node current = head;
            while (current.next.next != head) {
                current = current.next;
            }
            current.next = head;
        }
    }

    public void deleteMiddleNode(String data) {
        if (head == null) {
            return;
        } else {
            Node prev = head;
            Node current = head.next;
            while (prev.next.data != data) {
                prev = prev.next;
            }
            prev.next  = prev.next.next;
        }
    }


    public void printList() {
        if (head == null) {
            System.out.println("출력할 리스트가 존재하지 않습니다.");
        } else {
            Node current = head;
            System.out.print("[");
            while (current.next != head) {
                System.out.print(current.data + " ");
                current = current.next;
            }

            System.out.print(current.data);
            System.out.print("]");
            System.out.println();
        }


    }

}



