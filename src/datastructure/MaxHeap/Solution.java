package datastructure.MaxHeap;

import java.util.*;
import java.util.PriorityQueue;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else {
                map.put(num,1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Comparator.comparingInt(map::get)
        );

        for(Integer key : map.keySet()){
            if(pq.size() < k) {
                pq.add(key);
            }else if(map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }

        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.remove());
        }

        return list;
    }


}
