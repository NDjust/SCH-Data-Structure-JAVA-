package Ch03;

import java.util.List;

public class CircleLikedList {
    public static void main(String[] args) {

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
    int node_counts;

    public CircularList() {
        this.head = null;
        this.node_counts = 0;
    }
    public int get_length() {
        return this.node_counts;
    }

    boolean insertNode(String data, int pos) {
        ListNode node = new ListNode(data);
        int i = 1;
        if (pos < 1 || pos > node_counts + 1) {
            return false;
        }

        if (pos == 1) {
            node.next = head;
            head = node;
        } else {
            ListNode prev = head;
            ListNode current = head;
            while (i < pos - 1) {
                prev = prev.next;
                i++;
            }
            node.next = prev.next;
            prev.next = node;
        }

        if (pos == node_counts + 1) {
            node.next = head;
            head = node;
        }
        node_counts++;
        return true;
    }


}