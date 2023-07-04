package com.codewithcam;

import java.util.*;

public class HashTableExercises {

    public static int mostFrequent(int[] array) {
//        Iterate over array
//        Add each element to hash table as key with frequency as value
//        Keep track of max frequency and relevant key
//        If the frequency exceeds the max frequency then replace the max
//        Return the max key
//        Algorithm is O(n)

        int max_n = 0;
        int max_count = 0;
        HashMap<Integer, Integer> table = new HashMap<>();
        for (int n : array) {
            int count = table.getOrDefault(n, 0) + 1;
            table.put(n, count);
            if (count > max_count) {
                max_count = count;
                max_n = n;
            }
        }

        return max_n;
    }

    public static int countPairsWithDiff(int[] array, int k) {
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (int n : array) {
            if (visited.contains(n + k))
                count++;
            if (visited.contains(n - k))
                count++;
            visited.add(n);
        }

        return count;
    }


    public static String twoSum(int[] array, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            if (map.get(complement) != null)
                return Arrays.toString(new int[]{i, map.get(complement)});
            map.put(array[i], i);
        }

        return null;
    }

}
