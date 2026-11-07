class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(stones.length);

        for (var n : stones) {
            heap.offer(-n);
        }

        while (heap.size() > 1) {
            var x = heap.poll();
            var y = heap.poll();
            if (y > x) {
                heap.add(x - y);
            }
        }

        return heap.isEmpty() ? 0 : Math.abs(heap.poll());
    }


}