package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//347
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int num:nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count+1);
        }
        for (int i = 0; i < k; i ++) {
            int max = -1;
            for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
                if (entry.getValue() > max) {
                    res[i] = entry.getKey();
                    max = entry.getValue();
                }
            }
            map.remove(res[i]);
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int num:nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count+1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            if (queue.size() == k) {
                if (queue.peek()[1] < entry.getValue()) {
                    queue.poll();
                    queue.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            }else {
                queue.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }

        for (int i = 0; i < k; i ++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
