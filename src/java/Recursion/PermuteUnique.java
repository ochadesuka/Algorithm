package Recursion;

import java.util.*;
import java.util.stream.Collectors;

//47
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
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
            if (i > 0 && nums[i] == nums[i-1] && used[i-1]) {
                continue;
            }
            if(!used[i]) {
                item.add(nums[i]);
                used[i] = true;
                System.out.println("before: " + item.toString() + "index:"+index+"i:"+i + ": " + used[0]+","+used[1]+","+used[2]);
                recursion(ans, item, nums, used, index+1);
                System.out.println("after1: " + item.toString()  + "index:"+index+"i:"+ i + ": " + used[0]+","+used[1]+","+used[2]);
                used[i] = false;
                item.remove(item.size()-1);
                System.out.println("after2: " + item.toString()  + "index:"+index+"i:"+ ": " + used[0]+","+used[1]+","+used[2]);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        PermuteUnique pu = new PermuteUnique();
        System.out.println(pu.permuteUnique(nums).toString());
    }
}
