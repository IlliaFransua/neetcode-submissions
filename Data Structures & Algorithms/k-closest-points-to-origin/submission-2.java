class Solution {
    private record Pair(int[] points, double distance) {}

    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0) {
            return null;
        }

        Pair[] pairs = new Pair[points.length];
        for (int i = 0; i < points.length; ++i) {
            int x = points[i][0];
            int y = points[i][1];
            double distance = calculateDistance(x, y);
            pairs[i] = new Pair(points[i], distance);
        }

        quickSort(pairs, 0, pairs.length - 1);

        int[][] res = new int[k][2];
        for(int i = 0; i < k; ++i) {
            res[i] = pairs[i].points();
        }
        return res;
    }

    private void quickSort(Pair[] pairs, int start, int end) {
        if (start >= end) return;
        int pivot = end;
        int left = start;
        for (int i = start; i < end; ++i) {
            if (pairs[i].distance() < pairs[pivot].distance()) {
                Pair tmp = pairs[left];
                pairs[left] = pairs[i];
                pairs[i] = tmp;
                ++left;
            }
        }

        Pair tmp = pairs[left];
        pairs[left] = pairs[pivot];
        pairs[pivot] = tmp;

        quickSort(pairs, start, left - 1);
        quickSort(pairs, left + 1, end);
    }

    private double calculateDistance(int x, int y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}