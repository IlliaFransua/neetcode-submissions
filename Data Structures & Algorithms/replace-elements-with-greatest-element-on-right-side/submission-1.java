class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        int current;
        for (int i = arr.length - 2; i >= 0; --i) {
            max = arr[i + 1] > max ? arr[i + 1] : max;
            current = arr[i];
            arr[i] = max;
            max = current > max ? current : max;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}