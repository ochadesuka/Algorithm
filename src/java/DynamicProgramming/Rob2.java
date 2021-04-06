package DynamicProgramming;
//213
public class Rob2 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] states = new int[n];
        if (n == 0) {
            return 0;
        }else if(n == 1) {
            return nums[0];
        }
        states[1] = nums[1];
        for (int i = 2; i < n ; i ++) {
            states[i] = Math.max(states[i - 1], states[i - 2] + nums[i]);
        }
        int max = states[n-1];
        states[0] = nums[0];
        states[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i ++) {
            states[i] = Math.max(states[i - 1], states[i - 2] + nums[i]);
        }
        return Math.max(max, states[n-2]);
    }
}
