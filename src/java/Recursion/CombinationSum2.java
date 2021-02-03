package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//40
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        if (candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        recursion(ans, item, candidates, target, 0);
        return ans;
    }

    public void recursion(List<List<Integer>> ans,
                                         List<Integer> item,
                                         int[] nums, int target, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(item));
            return;
        }
        for (int i = index; i < nums.length; i ++) {
            if (target - nums[i] < 0) {
                break;
            }
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }
            item.add(nums[i]);
            System.out.println("before: " + item);
            recursion(ans, item, nums, target-nums[i], i+1);
            System.out.println("after: " + item);
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 c = new CombinationSum2();
        int[] nums = new int[]{2,2,1,3,5};
        System.out.println(c.combinationSum2(nums, 5));
    }
}
