package Practice;

public class CircularDoubly {
    public static void main(String[] args) {
        CircularDoublyLinkedList DL = new CircularDoublyLinkedList();
        System.out.println("(1) 공백 리스트에 노드 3개 삽입하기");
        DL.insertLastNode("월");
        DL.insertLastNode("수");
        DL.insertLastNode("일");
        DL.printList();

        System.out.println("(2) 수 노드 뒤에 금 노드 삽입하기");
        ListNode pre = DL.searchNode("수");

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

class ListNode {
    String data;
    ListNode prev;
    ListNode next;

    public ListNode() {
        this.data = null;
        this.prev = null;
        this.next = null;
    }

    public ListNode(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public ListNode(String data, ListNode prev) {
        this.data = data;
        this.prev = prev;
        this.next = null;
    }

    public ListNode(String data, ListNode prev, ListNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public String getData() {
        return this.data;
    }
}

class CircularDoublyLinkedList {
    ListNode head;

    public CircularDoublyLinkedList() {
        this.head = null;
    }

    public void insertFirstNode(String data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            ListNode current = head;
            ListNode prev = current.prev;
            newNode.prev = prev;
            newNode.next = current;
            current.prev = newNode;
            prev.next = newNode;
            head = newNode;
        }
    }

    public void insertMiddleNode(ListNode pre, String data) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            head = newNode;
            newNode.prev = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = pre.next;
            newNode.prev = pre;
            pre.next = newNode;
            pre.next.prev = newNode;
        }
    }

    public void insertLastNode(String data) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            head = newNode;
            newNode.prev = newNode;
            newNode.next = newNode;
        } else {
            ListNode current = head;

            while (current.next != head) {
                current = current.next;
            }

            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    public void deleteFirstNode() {
        if (head == null) {
            System.out.println("삭제할 리스트가 없당.");
        } else {
            head.next.prev = head.prev;
            head.prev.next = head.next;
            head = head.next;
        }
    }

    public void deleteMiddleNode(String data) {
        if (head == null) {
            System.out.println("삭제할 리스트가 없당.");
        } else {
            ListNode current = head;

            while (current.getData() != data) {
                current = current.next;
            }

            current.next.prev = current.prev;
            current.prev.next = current.next;
        }
    }

    public void deleteLastNode() {
        if (head == null) {
            System.out.println("삭제할 리스트가 없당.");
        } else {
            ListNode current = head;

            while (current.next != head) {
                current = current.next;
            }
            current.next.prev = current.prev;
            current.prev.next = current.next;
        }
    }

    public ListNode searchNode(String data) {
        if (head == null) {
            return null;
        } else {
            ListNode current = head;

            while (current.getData() != data) {
                current = current.next;
            }

            return current;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("출력 할게 없엉.");
        } else {
            ListNode current = head;

            while (current.next != head) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.print(current.data);
        }
        System.out.println();
    }
}