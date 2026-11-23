class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        long even = 1, odd = 0, ans = 0;
        int prefix = 0; 

        for (int x : arr) {
            prefix ^= (x & 1);
            if (prefix == 1) {
                ans += even; 
                odd++;
            } else {
                ans += odd;
                even++;
            }
            ans %= MOD;
        }
        return (int) ans;
    }
}
