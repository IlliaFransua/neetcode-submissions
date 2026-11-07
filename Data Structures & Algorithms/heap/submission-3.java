class MinHeap {

    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void push(int val) {
        heap.add(val);
        shiftUp(heap.size() - 1);
    }

    public Integer pop() {
        if (heap.size() <= 1) {
            return -1;
        }
        if (heap.size() == 2) {
            return heap.remove(1);
        }

        var res = heap.get(1);
        heap.set(1, heap.remove(heap.size() - 1));
        if (heap.size() > 1) {
            shiftDown(1);
        }
        return res;
    }

    public Integer top() {
        return heap.size() > 1 ? heap.get(1) : -1;
    }

    public void heapify(List<Integer> nums) {
        heap = new ArrayList<>();
        heap.add(0);
        heap.addAll(nums);

        for (int i = heap.size() / 2; i > 0; --i) {
            shiftDown(i);
        }
    }

    private void shiftUp(int index) {
        int parent = index / 2;
        while (index > 1 && heap.get(index) < heap.get(parent)) {
            swap(index, parent);
            index = parent;
            parent = index / 2;
        }
    }

    private void shiftDown(int index) {
        int child = 2 * index;
        while (child < heap.size()) {
            if (child + 1 < heap.size() &&
                heap.get(child + 1) < heap.get(child)) {
                child += 1;
            }

            if (heap.get(index) <= heap.get(child)) {
                break;
            }

            swap(child, index);
            index = child;
            child = 2 * index;
        }
    }

    private void swap(int i, int j) {
        var tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }
}