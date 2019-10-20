package MidtermPrac;

public class Polynominal {
    public static void main(String[] args) {
        Poly A = new Poly();
        A.appendTerm(4.1, 3);
        A.appendTerm(3.1, 2);
        A.appendTerm(5.1, 1);
        A.print();

        Poly B = new Poly();
        B.appendTerm(3.2, 4);
        B.appendTerm(1.2, 3);
        B.appendTerm(2.2, 1);
        B.appendTerm(1.2, 0);
        B.print();

        OperatePoly optPoly = new OperatePoly();
        Poly C = optPoly.addPoly(A, B);
        C.print();

    }
}
class OperatePoly {
    public Poly addPoly(Poly A, Poly B) {
        Node a = A.head;
        Node b = B.head;
        Poly C = new Poly();

        while (a != null && b != null) {
            if (a.expo == b.expo) {
                C.appendTerm(a.coef + b.coef, a.expo);
                a = a.next;
                b = b.next;
            } else if (a.expo > b.expo) {
                C.appendTerm(a.coef, a.expo);
                a = a.next;
            } else if (a.expo < b.expo) {
                C.appendTerm(b.coef, b.expo);
                b = b.next;
            }
        }
        while (a != null) {
            C.appendTerm(a.coef, a.expo);
            a = a.next;
        }

        while (b != null) {
            C.appendTerm(b.coef, b.expo);
            b = b.next;
        }

        return C;
    }
}

class Node {
    double coef;
    int expo;
    Node next;

    public Node() {
        this.coef = 0.0;
        this.expo = 0;
        this.next = null;
    }

    public Node(double coef, int expo, Node next) {
        this.coef = coef;
        this.expo = expo;
        this.next = next;
    }

    public Node(double coef, int expo) {
        this.coef = coef;
        this.expo = expo;
    }

    public double getCoef() {
        return this.coef;
    }

    public int getExpo() {
        return this.expo;
    }
}

class Poly {
    Node head;

    public Poly() {
        head = null;
    }

    public void appendTerm(double coef, int expo) {
        Node newNode = new Node(coef, expo);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("출력할 노드가 존재하지 않습니다.");
        } else {
            Node current = head;
            while (current.next != null) {
                System.out.printf(current.coef + "X^" + current.expo);
                current = current.next;
                if (current != null) {
                    System.out.printf(" + ");
                }
            }
            System.out.print(current.coef + "X^" + current.expo);
            System.out.println();
        }
    }
}