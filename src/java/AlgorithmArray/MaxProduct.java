package AlgorithmArray;
//152
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i ++) {
            int product = nums[i];
            max = Math.max(max, product);
            for (int j = i + 1; j < nums.length; j ++) {
                max = Math.max(max, product);
                product *= nums[j];
            }
        }
        return max;
    }
}
