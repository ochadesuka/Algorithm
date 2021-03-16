package AlgorithmArray;

import java.util.HashMap;
import java.util.Map;

//169
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count+1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length/2) {
                res =  entry.getKey();
                break;
            }
        }
        return res;

    }
}
