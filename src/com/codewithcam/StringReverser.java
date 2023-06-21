package com.codewithcam;

import java.util.Stack;

public class StringReverser {

    public String reverse(String string) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++)
            stack.push(string.charAt(i));

        String out = "";
        while (!stack.empty())
            out = String.join("", out, stack.pop().toString());

        return out;

    }

}
