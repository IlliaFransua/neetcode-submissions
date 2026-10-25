class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0) {
            return null;
        }

        int left = 0;
        int right = points.length - 1;
        int pivot = points.length;
        while (pivot != k) {
            pivot = partition(points, left, right);
            if (pivot < k) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        int[][] res = new int[k][2];
        System.arraycopy(points, 0, res, 0, k);
        return res;
    }

    private int partition(int[][] points, int start, int end) {
        int pivot = end;
        int left = start;
        int pivotDistance = calculateDistance(points[pivot][0], points[pivot][1]);
        for (int i = start; i < end; ++i) {
            if (calculateDistance(points[i][0], points[i][1]) < pivotDistance) {
                int[] tmp = points[left];
                points[left] = points[i];
                points[i] = tmp;
                ++left;
            }
        }

        int[] tmp = points[left];
        points[left] = points[pivot];
        points[pivot] = tmp;
        return left;
    }

    private int calculateDistance(int x, int y) {
        return x * x + y * y;
    }
}