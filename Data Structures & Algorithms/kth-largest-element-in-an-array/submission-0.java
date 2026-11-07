class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = 
                        new PriorityQueue<>(Collections.reverseOrder());
        heap.addAll(Arrays.stream(nums).boxed().toList());
        while (k - 1 > 0) {
            heap.poll();
            k -= 1;
        }
        return heap.poll();
    }
}
