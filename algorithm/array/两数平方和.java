class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int)Math.sqrt(c);
        int sum = 0;
        while (i <= j) {
            sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if(sum > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}