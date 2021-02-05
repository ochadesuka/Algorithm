package Recursion;

import java.util.ArrayList;
import java.util.List;

//46
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        boolean[] used = new boolean[nums.length];
        recursion(ans, item, nums, used, 0);
        return ans;
    }

    public void recursion(List<List<Integer>> ans, List<Integer> item,
                          int[] nums, boolean[] used,  int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(item));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if(!used[i]) {
                item.add(nums[i]);
                used[i] = true;
                System.out.println("before: " + item.toString() + i + ": " + used[i]);
                recursion(ans, item, nums, used, index+1);
                System.out.println("after: " + item.toString() + i + ": " + used[i]);
                used[i] = false;
                item.remove(item.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Permute p = new Permute();
        System.out.println(p.permute(nums).toString());
    }
}
