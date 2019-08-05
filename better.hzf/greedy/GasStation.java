package greedy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 134. Gas Station
 * @author hzf
 * @see https://leetcode.com/problems/gas-station/
 */
public class GasStation {
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		//将数组扩大到原来的两倍
		int[] gas2 = new int[gas.length * 2];
		int[] cost2 = new int[cost.length * 2];
		for(int i = 0; i < gas2.length; i++){
			gas2[i] = gas[i % gas.length];
		}
		for(int i = 0; i < cost2.length; i++){
			cost2[i] = cost[i % cost.length];
		}
		//遍历数组，将SumGas[i,j]-SumCost[i,j]大于等于0记录到Map中
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < gas2.length; i++){
        	if(gas2[i] >= cost2[i]){
        		Map<Integer, Integer> tempMap = new HashMap<>();
        		tempMap.put(i, gas2[i]-cost2[i]);
        		map.put(i, tempMap);
        	}
        	Map<Integer, Integer> before = map.get(i-1);
			if (before != null) {
				Iterator<Map.Entry<Integer, Integer>> it = before.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<Integer, Integer> entry = it.next();
					if(entry.getValue() + gas2[i] - cost2[i] >= 0){
						entry.setValue(entry.getValue() + gas2[i] - cost2[i]);
						if(entry.getKey() + gas.length -1 == i){
							return entry.getKey();
						}
					}else{
						it.remove();
					}
				}
				if(!before.isEmpty()){
					map.put(i, before);
					map.remove(i-1);
				}
			}
        }
        if(gas.length == 1 && !map.isEmpty()){
        	return 0;
        }
        return -1;
    }

	public static void main(String[] args) {
		int[] gas = {5};
		int[] cost = {4};
		GasStation gs = new GasStation();
		System.out.print(gs.canCompleteCircuit(gas, cost));
	}

}
