class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            int sum = 0;
            for (var pile : piles) {
                sum += Math.ceil((double) pile / mid);
            }

            if (sum <= h) {
                r = mid - 1;
                res = Math.min(res, mid);
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
