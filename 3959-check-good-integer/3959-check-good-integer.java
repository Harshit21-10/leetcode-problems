class Solution {
    public boolean checkGoodInteger(int n) {
        int squareSum = 0;
        int sum = 0;
        while(n>0){
            int digit = n%10;
            sum += digit;
            squareSum += digit*digit;
            n /= 10;
        }
        return squareSum - sum >= 50;
    }
}