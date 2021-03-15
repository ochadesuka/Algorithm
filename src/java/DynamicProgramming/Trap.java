package DynamicProgramming;
//42
public class Trap {
    public int trap(int[] height) {
        int sum = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        for(int i = 1; i < height.length-1; i ++) {
            left[i] = Math.max(left[i-1], height[i-1]);
        }

        for(int j = height.length-2; j >= 1; j --) {
            right[j] = Math.max(right[j+1], height[j+1]);
        }

        for(int i = 1; i < height.length-1; i ++) {
            int min = Math.min(left[i], right[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }
}
