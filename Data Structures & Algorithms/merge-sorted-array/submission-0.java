class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] buffer = new int[nums1.length];
        int k = -1;
        
        int p1 = 0;
        int p2 = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] <= nums2[p2]) {
                buffer[++k] = nums1[p1++];
            } else {
                buffer[++k] = nums2[p2++];
            }
        }
        while (p1 < m) {
            buffer[++k] = nums1[p1++];
        }
        while (p2 < n) {
            buffer[++k] = nums2[p2++];
        }

        for (int i = 0; i <= k; ++i) {
            nums1[i] = buffer[i];
        }
    }
}