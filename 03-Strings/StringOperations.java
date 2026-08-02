import java.util.Arrays;

public class StringOperations {

    // Reverse a string
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    // Check Palindrome
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Check Anagrams
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println("Original: " + str);
        System.out.println("Reversed: " + reverseString(str));
        System.out.println("Is 'racecar' palindrome? " + isPalindrome("racecar"));
        System.out.println("Are 'listen' and 'silent' anagrams? " + isAnagram("listen", "silent"));
    }
}
