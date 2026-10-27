class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);

        int i = 0;
        int j = sb.length() - 1;

        while (i < j) {
            if (!isVowel(sb.charAt(i))) {
                i++;
            } else if (!isVowel(sb.charAt(j))) {
                j--;
            } else {
                char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);

                i++;
                j--;
            }
        }

        return sb.toString();
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
