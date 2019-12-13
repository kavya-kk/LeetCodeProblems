package leetcode.problems.DesignQuestions;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer,Integer> {
    int capacity = 0;
    public LRUCache(int capacity, float loadfactor){
        super(capacity,loadfactor,true);
        this.capacity = capacity;
    }
    public Integer get(Integer key){
        return super.getOrDefault(key,-1);
    }
    public void add(Integer key, Integer value){
        super.put(key,value);
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer,Integer> entry){
        return size()>capacity;
    }

}
