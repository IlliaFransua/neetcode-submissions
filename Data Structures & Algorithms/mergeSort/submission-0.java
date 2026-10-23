// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {

    private Pair[] buffer;

    public List<Pair> mergeSort(List<Pair> pairs) {
        if (pairs == null || pairs.isEmpty()) return List.of();
        buffer = new Pair[pairs.size()];
        mergeSort(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    private void mergeSort(List<Pair> pairs, int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;
        mergeSort(pairs, left, mid);
        mergeSort(pairs, mid + 1, right);
        merge(pairs, left, mid, right);
    }

    private void merge(List<Pair> pairs, int left, int mid, int right) {
        int l1_left = left;
        int l1_right = mid;
        int l2_left = mid + 1;
        int l2_right = right;
        int i = 0;

        while (l1_left <= l1_right && l2_left <= l2_right) {
            if (pairs.get(l1_left).key <= pairs.get(l2_left).key) {
                buffer[i++] = pairs.get(l1_left++);
            } else {
                buffer[i++] = pairs.get(l2_left++);
            }
        }
        while (l1_left <= l1_right) {
            buffer[i++] = pairs.get(l1_left++);
        }
        while (l2_left <= l2_right) {
            buffer[i++] = pairs.get(l2_left++);
        }
        --i;

        while (i >= 0) {
            pairs.set(right--, buffer[i--]);
        }
    }
}
