package Recursion;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

//698
public class CanPartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        OptionalInt max = Arrays.stream(nums).max();
        if (max.getAsInt() > target) {
            return false;
        }
        boolean[] group = new boolean[k];
        return backtrack(nums, k, target, 0, 0, group);
    }

    public boolean backtrack(int[] nums, int k, int target, int cur, int index, boolean[] group) {
        if (k == 0) return true;
        if (cur == target) {
            return backtrack(nums, k-1, target, 0, 0, group);
        }
        for (int i = index; i < nums.length; i ++) {
            if (!group[i] && cur+nums[i] <= target) {
                group[i] = true;
                if (backtrack(nums, k, target, cur+nums[i], i+1, group)) {
                    return true;
                }
                group[i] = false;
            }
        }
        return false;
    }
}
