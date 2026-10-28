class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            long totalTime = 0;
            for (var pile : piles) {
                totalTime += Math.ceil((double) pile / mid);
                if (totalTime > h) {
                    break;
                }
            }

            if (totalTime <= h) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
