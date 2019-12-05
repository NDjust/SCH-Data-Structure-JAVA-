package FinalPrac;

public class HP {
    public static void main(String[] args) {
        int n, item;

        Heap h = new Heap();

        h.insertHeap(13);
        h.insertHeap(8);
        h.insertHeap(10);
        h.insertHeap(15);
        h.insertHeap(20);
        h.insertHeap(19);

        h.printHeap();

        n = h.getHeapSize();

        for (int i = 1; i <= n; i++) {
            item = h.deleteHeap();
            System.out.printf("\n deleted Item : [%d]", item);
        }
    }
}

class Heap {
    private int HeapSize;
    private int itemheap[];

    public Heap() {
        HeapSize = 0;
        itemheap = new int[50];
    }

    public void insertHeap(int item) {
        int i = ++HeapSize;

        while ((i != 1 && (item > itemheap[i / 2]))) {
            itemheap[i] = itemheap[i / 2];
            i /= 2;
        }
        itemheap[i] = item;
    }

    public int getHeapSize() {
        return HeapSize;
    }

    public int deleteHeap() {
        int parent, child;
        int item = itemheap[1];
        int temp = itemheap[HeapSize--];

        parent = 1;
        child = 2;

        while (child <= HeapSize) {
            // 오른쪽 자식 노드가 왼쪽 자식 노드보다 크다면 오른쪽 자식 노드로 변경!
            if ((child < HeapSize) && (itemheap[child] < itemheap[child + 1])) {
                child++;
            }

            if (temp >= itemheap[child]) {
                break;
            }
            itemheap[parent] = itemheap[child]; // 부모노드의 값을 자식 노드와 바꾸기.
            parent = child; // 점검할 부모 노드 위치 변경.
            child *= 2;
        }
        itemheap[parent] = temp;
        return item;
    }

    public void printHeap(){
        System.out.printf("\nHeap >>> ");

        for (int i = 1; i <= HeapSize; i++) {
            System.out.printf("[%d] ", itemheap[i]);
        }
    }


}
