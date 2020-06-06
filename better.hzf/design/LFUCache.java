package design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

class LFUCache {

    private HashMap<Integer, Vfreq> map;
    private TreeMap<Integer, LinkedHashSet<Integer>> freqMap;
    private int max;

    public LFUCache(int capacity) {
        map = new HashMap<>(capacity);
        freqMap = new TreeMap<>();
        max = capacity;
    }

    public int get(int key) {
        Vfreq vfreq = map.get(key);
        if(vfreq == null){
            return -1;
        }

        updateFreqMap(key, vfreq.freq, vfreq.freq + 1);

        vfreq.freq += 1;
        return vfreq.value;
    }

    private void updateFreqMap(int key, Integer oldFreq, Integer newFreq) {
        LinkedHashSet<Integer> origin = freqMap.get(oldFreq);
        if(origin != null) {
            origin.remove(key);
        }

        LinkedHashSet<Integer> current = freqMap.get(newFreq);
        if(current != null){
            current.add(key);
            return;
        }
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(key);
        freqMap.put(newFreq, set);
    }

    public void put(int key, int value) {
        if(max == 0){
            return;
        }
        Vfreq vfreq = map.get(key);
        if(vfreq != null){
            updateFreqMap(key, vfreq.freq, vfreq.freq + 1);

            vfreq.value = value;
            vfreq.freq += 1;
            return;
        }

        if(map.size() == max){
            Integer deleteKey = deleteLeastFreq();
            map.remove(deleteKey);
        }

        updateFreqMap(key, -1, 1);
        Vfreq newVfreq = new Vfreq();
        newVfreq.value = value;
        newVfreq.freq = 1;
        map.put(key, newVfreq);
    }

    private Integer deleteLeastFreq() {
        for(Map.Entry<Integer, LinkedHashSet<Integer>> entry : freqMap.entrySet()){
            LinkedHashSet<Integer> linkedHashSet = entry.getValue();
            if(!linkedHashSet.isEmpty()){
                Integer key = linkedHashSet.iterator().next();
                linkedHashSet.remove(key);
                return key;
            }
        }
        return null;
    }

    class Vfreq{
        Integer value;
        Integer freq;
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
        System.out.println(cache.get(3));       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(4));       // 返回 4
    }
}
