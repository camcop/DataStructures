package com.codewithcam;

import java.util.HashMap;
import java.util.Map;

public class CharFinder {

    public static Character findFirstNonRepeatingCharacter(String string) {

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = string.toLowerCase().toCharArray();
        for (Character c : chars) {
            int count = map.getOrDefault(c, 0);
            map.put(c, ++count);
        }

        for (Character c : chars) {
            if (map.get(c) == 1)
                return c;
        }

        return Character.MIN_VALUE;
    }


}
