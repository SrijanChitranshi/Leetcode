class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        long even = 1, odd = 0, ans = 0;
        int prefix = 0; // parity of running sum: 0 = even, 1 = odd

        for (int x : arr) {
            prefix ^= (x & 1);
            if (prefix == 1) {
                ans += even;  // odd prefix pairs with every earlier even prefix
                odd++;
            } else {
                ans += odd;   // even prefix pairs with every earlier odd prefix
                even++;
            }
            ans %= MOD;
        }
        return (int) ans;
    }
}
