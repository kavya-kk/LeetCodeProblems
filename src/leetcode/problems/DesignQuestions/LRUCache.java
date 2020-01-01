package leetcode.problems.DesignQuestions;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer,Integer> {
    int capacity = 0;
    public LRUCache(int capacity){
        // the data will be stored in the order of most accessed to least accessed.
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public void add(Integer key, Integer value){
        super.put(key,value);
    }

    public Integer get(Integer key){
        return super.getOrDefault(key,-1);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        // if the size of the map is greater than the capacity, remove the eldest element.
        return size() > capacity;
    }
}
