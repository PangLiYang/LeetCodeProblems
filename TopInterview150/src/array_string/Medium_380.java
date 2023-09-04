package array_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Medium_380 {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private int idx;

    public Medium_380() {
        list = new ArrayList<>();
        map = new HashMap<>();
        idx = 0;
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, idx);
            list.add(val);
            idx += 1;
            return true;
        }

        return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int currIdx = map.get(val);
            int lastValue = list.get(idx - 1);

            if (currIdx != idx - 1) {
                list.set(currIdx, lastValue);
                map.put(lastValue, currIdx);
            }

            list.remove(idx - 1);
            map.remove(val);
            idx -= 1;
            return true;
        }

        return false;
    }

    public int getRandom() {
        int rand = (int) Math.floor(list.size() * Math.random());
        return list.get(rand);
    }
}
