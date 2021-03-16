package sort;
//75
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int zero = 0;
        int two = nums.length;
        int i = 0;
        while(i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            }else if(nums[i] == 1) {
                i++;
            }else {
                two--;
                swap(nums, i, two);
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
