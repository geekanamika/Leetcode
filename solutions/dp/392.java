class Solution {
    public boolean isSubsequence(String s, String t) {
        int si = 0, ti = 0;
        while(ti < t.length() && si < s.length()) {
            if(s.charAt(si) == t.charAt(ti))
                si++;
            ti++;
        }
        return si == s.length();
    }
}