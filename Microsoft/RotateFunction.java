class Solution {
  public int maxRotateFunction(int[] nums) {
    final int sum = Arrays.stream(nums).sum();
    int function = 0;

    for (int i = 0; i < nums.length; ++i)
      function += i * nums[i];

    int ans = function;

    for (int i = nums.length - 1; i >= 0; --i) {
      function += sum - nums.length * nums[i];
      ans = Math.max(ans, function);
    }

    return ans;
  }
}
