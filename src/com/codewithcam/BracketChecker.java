package com.codewithcam;

import java.util.Stack;

public class BracketChecker {

    public boolean check(String string) {
        String open = "(<[{";
        String close = ")>]}";

        Stack<Character> stack = new Stack<>();
        for (Character c : string.toCharArray()) {
            if (open.contains(c.toString()))
                stack.push(c);
            if (close.contains(c.toString())) {
                if (stack.empty()) return false;
                Character d = stack.pop();
                if (close.indexOf(c) != open.indexOf(d)) return false;
            }
        }

        return true;
    }

}
