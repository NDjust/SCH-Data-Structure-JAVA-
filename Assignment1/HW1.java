package Assignment1;

public class HW1 {
    public static void main(String[] args) {
        Polynomial A = new Polynomial();
        A.appendTerm(4.1, 3);
        A.appendTerm(3.1, 2);
        A.appendTerm(5.1, 1);
        A.print();

        Polynomial B = new Polynomial();
        B.appendTerm(3.2, 4);
        B.appendTerm(1.2, 3);
        B.appendTerm(2.2, 1);
        B.appendTerm(1.2, 0);
        B.print();

        OperatePoly optPoly = new OperatePoly();
        Polynomial C = optPoly.addPoly(A, B);
        C.print();

    }
}

class OperatePoly {
    public Polynomial addPoly(Polynomial A, Polynomial B) {
        ListNode a = A.head;
        ListNode b = B.head;
        Polynomial C = new Polynomial();

        while (a != null && b != null) {
            if (a.expo == b.expo) {
                C.appendTerm(a.coef + b.coef, b.expo);
                a = a.link;
                b = b.link;
            } else if (a.expo > b.expo) {
                C.appendTerm(a.coef, a.expo);
                a = a.link;
            } else {
                C.appendTerm(b.coef, b.expo);
                b = b.link;
            }
        }

        while (a != null) {
            C.appendTerm(a.coef, a.expo);
            a = a.link;
        }

        while (b != null) {
            C.appendTerm(b.coef, b.expo);
            b = b.link;
        }
        return C;
    }
}

class Polynomial {
    ListNode head;

    public Polynomial() {
        head = null;
    }

    public void appendTerm(double coef, int expo) {
        ListNode node = new ListNode(coef, expo);
        if (head == null) {
            head = node;
        } else {
            ListNode current = head;
            while (current.link != null) {
                current = current.link;
            }
            current.link = node;

        }
    }

    public void print() {
        if (head == null) {
            System.out.println("출력할 노드가 존재하지 않습니다.");
        } else {
            ListNode current = head;
            while (current.link != null) {
                System.out.printf(current.coef + "X^" + current.expo +  " + ");
                current = current.link;
            }
            System.out.print(current.coef + "X^" + current.expo);
            System.out.println();
        }
    }
}

class ListNode {
    double coef;
    int expo;
    ListNode link;

    public ListNode() {
        link = null;
    }

    public ListNode(double coef, int expo) {
        this.coef = coef;
        this.expo = expo;
        this.link = null;
    }

    public ListNode(double coef, int expo, ListNode link) {
        this.coef = coef;
        this.expo = expo;
        this.link = link;
    }

    public double getCoef() {
        return this.coef;
    }

    public int getExpo() {
        return this.expo;
    }
}