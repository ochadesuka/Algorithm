package DynamicProgramming;

import java.util.Arrays;

//198
public class Rob {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }else if (nums.length == 1) {
            return nums[0];
        }
        int[] states = new int[nums.length];
        states[0] = nums[0];
        states[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i ++) {
            states[i] = Math.max(states[i-2] + nums[i], states[i-1]);
        }

        return states[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,3};
        Rob r = new Rob();
        System.out.println(r.rob(nums));
    }
}
