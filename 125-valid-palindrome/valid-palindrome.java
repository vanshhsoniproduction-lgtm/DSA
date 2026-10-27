class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            // Move forward if the character is not alphanumeric
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            // Move backward if the character is not alphanumeric (FIXED: changed j++ to j--)
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            
            // Compare characters case-insensitively
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            
            // Move pointers closer together (FIXED: changed j++ to j--)
            i++;
            j--;
        }
        
        return true;
    }
}
