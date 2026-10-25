// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSort(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    private void quickSort(List<Pair> pairs, int start, int end) {
        if (start >= end) return;

        int pivot = end;
        int left = start;
        for (int i = start; i < end; ++i) {
            if (pairs.get(i).key < pairs.get(pivot).key) {
                Pair tmp = pairs.get(i);
                pairs.set(i, pairs.get(left));
                pairs.set(left, tmp);
                ++left;
            }
        }

        Pair tmp = pairs.get(pivot);
        pairs.set(pivot, pairs.get(left));
        pairs.set(left, tmp);

        quickSort(pairs, start, left - 1);
        quickSort(pairs, left + 1, end);
    }
}
