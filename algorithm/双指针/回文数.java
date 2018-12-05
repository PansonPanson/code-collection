class Solution {
    public boolean validPalindrome(String s) {
        int i = -1, j = s.length();
        while (++i < --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return (isPalindrom(s, i, j - 1) || isPalindrom(s, i + 1, j));
            }
        }
        return true;
        
    }
    
    private boolean isPalindrom(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}