package Ch04;

public class DoublyLinked {
    public static void main(String[] args) {
        DoublyLinkedList DL = new DoublyLinkedList();
        System.out.println("(1) 공백 리스트에 노드 3개 삽입하기");
        DL.insertLastNode("월");
        DL.insertLastNode("수");
        DL.insertLastNode("일");
        DL.printList();

        System.out.println("(2) 수 노드 뒤에 금 노드 삽입하기");
        Node pre = DL.searchNode("수");

        if (pre == null) {
            System.out.println("검색실패 찾는 데이터가 없습니다. ");
        } else {
            DL.insertMiddleNode(pre, "금");

        }

        DL.printList();
        System.out.println("(3) 리스트 첫번째에 토 추가");
        DL.insertFirstNode("토");
        DL.printList();

        System.out.println("(4) 리스트의 마지막 노드 삭제하기");
        DL.deleteLastNode();
        DL.printList();

        System.out.println("(5) 리스트의 중간노드 수 노드 삭제하기");
        DL.deleteMiddleNode("수");
        DL.printList();


        System.out.println("(6) 첫번째 노드 삭제하기");
        DL.deleteFirstNode();
        DL.printList();




    }
}

class Node {
    String data;
    Node next;
    Node prev;

    public Node(){
        this.next = null;
        this.prev = null;
    }

    public Node(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
        this.prev = null;
    }

    public Node(String data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public String getData() {
        return this.data;
    }
}


class DoublyLinkedList {
    private Node head;

    public  DoublyLinkedList() {
        this.head = null;
    }

    public void insertFirstNode(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertMiddleNode(Node pre, String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = pre.next;
            newNode.prev = pre;
            pre.next = newNode;
            newNode.next.prev = newNode;
        }
    }

    public void insertLastNode(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public String deleteNode(Node old) {
        String data = old.data;
        old.prev.next = old.next;
        old.next.prev = old.prev;

        return data;
    }

    public void deleteFirstNode() {
        if (head == null) {
            System.out.println("삭제할 리스트 존재 x");
        } else {
            head.next.prev = null;
            head = head.next;
        }
    }

    public void deleteMiddleNode(String data) {
        if (head == null) {
            System.out.println("삭제할 리스트 존재 x");
        } else {
            Node current = head;

            while (current.getData() != data) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public void deleteLastNode() {
        if (head == null) {
            System.out.println("삭제할 리스트 존재 x");
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.prev.next = null;
            current.prev = null;
        }
    }

    public Node searchNode(String data) {
        if (head == null) {
            return  null;
        } else {
            Node current = head;

            while (current.data != data) {
                current = current.next;
            }

            return current;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("출력 할게 없엉.");
        } else {
            Node current = head;

            while (current.next != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.print(current.data);
        }
        System.out.println();
    }
}