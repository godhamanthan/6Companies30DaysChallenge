class FenwickTree {
  public FenwickTree(int n) {
    sums = new int[n + 1];
  }

  public void update(int i, int delta) {
    while (i < sums.length) {
      sums[i] += delta;
      i += lowbit(i);
    }
  }

  public int get(int i) {
    int sum = 0;
    while (i > 0) {
      sum += sums[i];
      i -= lowbit(i);
    }
    return sum;
  }

  private int[] sums;

  private static int lowbit(int i) {
    return i & -i;
  }
}

class Solution {
  public long goodTriplets(int[] nums1, int[] nums2) {
    final int n = nums1.length;
    long ans = 0;
    Map<Integer, Integer> numToIndex = new HashMap<>();
    int[] A = new int[n];
    // leftSmaller[i] := # of A[j] < A[i], where 0 <= j < i
    int[] leftSmaller = new int[n];
    // rightLarger[i] := # of A[j] > A[i], where i < j < n
    int[] rightLarger = new int[n];
    FenwickTree tree1 = new FenwickTree(n); // To calculate leftSmaller
    FenwickTree tree2 = new FenwickTree(n); // To calculate rightLarger

    for (int i = 0; i < n; ++i)
      numToIndex.put(nums1[i], i);

    
    for (int i = 0; i < n; ++i)
      A[i] = numToIndex.get(nums2[i]);

    for (int i = 0; i < n; ++i) {
      leftSmaller[i] = tree1.get(A[i]);
      tree1.update(A[i] + 1, 1);
    }

    for (int i = n - 1; i >= 0; --i) {
      rightLarger[i] = tree2.get(n) - tree2.get(A[i]);
      tree2.update(A[i] + 1, 1);
    }

    for (int i = 0; i < n; ++i)
      ans += (long) leftSmaller[i] * rightLarger[i];

    return ans;
  }
}
