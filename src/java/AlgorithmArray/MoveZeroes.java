package AlgorithmArray;

import java.util.Arrays;

//283
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int zero = 0, num = 0;
        while (num < nums.length) {
            if (nums[num] != 0) {
                int tmp = nums[zero];
                nums[zero] = nums[num];
                nums[num] = tmp;
                zero++;
            }
            num++;
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,0,2,3,0};
        MoveZeroes.moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }
}
