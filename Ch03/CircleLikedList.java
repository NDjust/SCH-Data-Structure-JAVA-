package Ch03;

import java.util.List;

public class CircleLikedList {
    public static void main(String[] args) {
        CircularList CL = new CircularList();
        System.out.println("(1) 공백 리스트에 노드 3개 삽입하기");
        CL.insertFirstNode("월");
        CL.insertFirstNode("수");
        CL.insertFirstNode("일");
        CL.printList();
        System.out.println("(2) \"수\"노드 뒤에 \"금\" 노드 삽입하기");
        ListNode pre = CL.searchNode("수");
        if (pre == null) {
            System.out.println("검색 실패 >> 찾는 데이터가 없습니다.");
        } else {
            CL.insertMiddleNode(pre, "금");
        }
        CL.printList();
        System.out.println("(3) 리스트의 첫 번째에 \"토\" 노드 추가하기");
        CL.insertFirstNode("토");
        CL.printList();
        System.out.println("(4) 리스트의 마지막 노드 삭제하기");
        CL.deleteLastNode();
        CL.printList();
        System.out.println("(5) 리스트의 중간 노드 \"수\" 삭제하기");
        CL.deleteMiddleNode("수");
        CL.printList();
        System.out.println("(6) 리스트의 첫 번째 노드 삭제하기");
        CL.deleteFirstNode();
        CL.printList();
    }
}

class ListNode {
    String data;
    ListNode next;

    public ListNode() {
        this.data = null;
        this.next = null;
    }

    public ListNode(String data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(String data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public String getData() {
        return this.data;
    }
}
class CircularList {
    private ListNode head;

    public CircularList() {
        this.head = null;
    }

    public void insertLastNode(String data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            node.next = node;
        } else {
            ListNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }
    }

    public void insertFirstNode(String data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            node.next = node;
        } else {
            ListNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
            head = node;
        }
    }

    public void insertMiddleNode(ListNode pre, String data) {
        ListNode node = new ListNode(data);

        if (head == null) {
            head = node;
        } else {
            node.next = pre.next;
            pre.next = node;
        }
    }

    public void deleteLastNode() {
        if (head == null) {
            System.out.println("지울 노드가 존재 x ");
        } else  {
            ListNode prev = head;
            ListNode current = head.next;

            while (current.next != head) {
                prev = current;
                current = current.next;
            }

            prev.next = current.next;
        }
    }

    public void deleteFirstNode() {

        if (head == null) {
            System.out.println("지울 노드가 존재 x ");
        } else  {

            ListNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            ListNode old = current.next;
            head = old.next;
            current.next = head;
        }
    }
    public void deleteMiddleNode(String data) {

        if (head == null) {
            System.out.println("지울 노드가 존재 x ");
        } else  {
            ListNode prev = head;
            ListNode current = head;
            while (current.data != data) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
        }
    }
    public ListNode searchNode(String data) {
        if
        (head == null) {
            System.out.println("노드가 비어있습니다.");
            return null;
        } else
        {
            ListNode current = head;
            while (current.data != data) {
                current = current.next;
            }
            return current;
        }
    }
    public void printList() {
        if
        (head == null) {
            System.out.println("출력할 리스트가 존재하지 않습니다.");
        } else {
            ListNode current = head;
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