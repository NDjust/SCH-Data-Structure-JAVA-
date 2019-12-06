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

        while ((i != 1) && (item > itemheap[i / 2])) {
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
        int item, temp;

        item = itemheap[1];
        temp = itemheap[HeapSize--];

        parent = 1;
        child = 2;

        while (child <= HeapSize) {
            // 왼쪽 오른쪽 결정
            if ((child < HeapSize) && (itemheap[child] < itemheap[child + 1])) {
                child++;
            }

            if (temp >= itemheap[child]) {
                break;
            }

            itemheap[parent] = itemheap[child];
            parent = child;
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
