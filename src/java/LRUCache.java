import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//146
public class LRUCache {
    private Map<Integer,Integer> cacheMap;
    private List<Integer> keyList;
    private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>(capacity);
        keyList = new ArrayList<>(capacity);
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            int index = keyList.indexOf(key);
            keyList.remove(index);
            keyList.add(key);
            return cacheMap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cacheMap.size() == capacity) {
            int oldKey = keyList.remove(0);
            cacheMap.remove(oldKey);
        }
    }
}
