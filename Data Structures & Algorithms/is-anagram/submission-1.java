class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sm = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (sm.containsKey(c)) {
                sm.put(c, sm.get(c) + 1);
            } else {
                sm.put(c, 1);
            }
        }

        for (var c : t.toCharArray()) {
            if (sm.containsKey(c)) {
                sm.put(c, sm.get(c) - 1);
                if (sm.get(c) == 0) {
                    sm.remove(c);
                }
            } else {
                return false;
            }
        }

        return sm.isEmpty();
    }
}
