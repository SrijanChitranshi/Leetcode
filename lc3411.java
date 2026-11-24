
class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int product = 1;
            int gcd = 0;
            int lcm = 1;

            for (int j = i; j < n; j++) {
                product *= nums[j];

                gcd = findGcd(gcd, nums[j]);
                lcm = (lcm / findGcd(lcm, nums[j])) * nums[j];

                if (product == gcd * lcm) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private int findGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
