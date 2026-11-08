class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sm = new HashMap<>();
        Map<Character, Integer> tm = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (sm.containsKey(c)) {
                sm.put(c, sm.get(c) + 1);
            } else {
                sm.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (tm.containsKey(c)) {
                tm.put(c, tm.get(c) + 1);
            } else {
                tm.put(c, 1);
            }
        }

        return sm.equals(tm);
    }
}
