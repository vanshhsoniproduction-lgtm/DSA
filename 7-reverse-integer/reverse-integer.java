class Solution {
    public int reverse(int x) {
        long temp = Math.abs((long) x);
        long answer = 0;

        while (temp > 0) {
            long attach = temp % 10;
            answer = answer * 10 + attach;
            temp = temp / 10;
        }

        if (x < 0) {
            answer = -answer;
        }

        if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) answer;
    }
}