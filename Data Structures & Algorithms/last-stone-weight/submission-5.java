class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(stones.length, Collections.reverseOrder());

        heap.addAll(Arrays.stream(stones).boxed().toList());

        while (heap.size() > 1) {
            var x = heap.poll();
            var y = heap.poll();
            if (x != y) {
                heap.add(x - y);
            }
        }

        return heap.isEmpty() ? 0 : Math.abs(heap.peek());
    }


}
