package AlgorithmArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//56
public class Merge {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        if (intervals.length != 0) {
            list.add(intervals[0]);
        }

        for(int i = 1; i < intervals.length; i ++) {
            int n0 = intervals[i][0];
            int n1 = intervals[i][1];
            if (n0 > list.get(list.size()-1)[1]) {
                list.add(intervals[i]);
            }else {
                list.get(list.size()-1)[1] = Math.max(n1, list.get(list.size()-1)[1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] nums = new int[5][2];
        nums[0] = new int[]{2,3};
        nums[1] = new int[]{4,5};
        nums[2] = new int[]{6,7};
        nums[3] = new int[]{8,9};
        nums[4] = new int[]{1, 10};
        Merge m = new Merge();
        System.out.println(m.merge(nums));
    }
}
