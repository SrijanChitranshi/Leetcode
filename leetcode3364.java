import java.util.List;

class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;
        
        // Fix the left boundary of the subarray
        for (int i = 0; i < n; ++i) {
            int s = 0;
            // Expand the right boundary of the subarray
            for (int j = i; j < n; ++j) {
                s += nums.get(j);
                int k = j - i + 1; // Current subarray length
                
                // Check if length is within [l, r] and sum is strictly positive
                if (k >= l && k <= r && s > 0) {
                    ans = Math.min(ans, s);
                }
            }
        }
        
        // If ans was never updated, return -1
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
