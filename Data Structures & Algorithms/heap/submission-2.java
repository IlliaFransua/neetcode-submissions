class MinHeap {

    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void push(int val) {
        heap.add(val);
        if (heap.size() == 1) {
            return;
        }

        int i = heap.size() - 1;
        while (i / 2 > 0 && heap.get(i) < heap.get(i / 2)) {
            var tmp = heap.get(i);
            heap.set(i, heap.get(i / 2));
            heap.set(i / 2, tmp);
            i /= 2;
        }
    }

    public Integer pop() {
        if (heap.size() == 1) {
            return -1;
        }

        var res = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int i = 1;
        while (i * 2 < heap.size()) {

            if (i * 2 + 1 < heap.size() &&
                heap.get(i * 2 + 1) < heap.get(i * 2) &&
                heap.get(i * 2 + 1) < heap.get(i)) {
                    
                var tmp = heap.get(i);
                heap.set(i, heap.get(i * 2 + 1));
                heap.set(i * 2 + 1, tmp);
                i = i * 2 + 1;

            } else if (heap.get(i * 2) < heap.get(i)) {
                var tmp = heap.get(i);
                heap.set(i, heap.get(i * 2));
                heap.set(i * 2, tmp);
                i = i * 2;
            } else {
                break;
            }
        }
        return res;
    }

    public Integer top() {
        if (heap.size() == 1) {
            return -1;
        }
        return heap.get(1);
    }

    public void heapify(List<Integer> nums) {
        heap = nums;
        if (heap.isEmpty()) {
            heap.add(0);
            return;
        }
        heap.add(heap.get(0));
        heap.set(0, 0);
        int curr = heap.size() / 2 - 1; // last parent

        while (curr > 0) {
            int i = curr;
            while (i * 2 < heap.size()) {

                if (i * 2 + 1 < heap.size() &&
                    heap.get(i * 2 + 1) < heap.get(i * 2) &&
                    heap.get(i * 2 + 1) < heap.get(i)) {
    
                    var tmp = heap.get(i);
                    heap.set(i, heap.get(i * 2 + 1));
                    heap.set(i * 2 + 1, tmp);
                    i = i * 2 + 1;
    
                } else if (heap.get(i * 2) < heap.get(i)) {
                    var tmp = heap.get(i);
                    heap.set(i, heap.get(i * 2));
                    heap.set(i * 2, tmp);
                    i = i * 2;
                } else {
                    break;
                }
            }
            curr -= 1;
        }
    }
}
