package com.codewithcam;

import java.util.Stack;

public class StringReverser {

    public String reverse(String string) {
        if (string == null) throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();
        for (char c : string.toCharArray())
            stack.push(c);

        StringBuffer out = new StringBuffer();

        while (!stack.empty())
            out.append(stack.pop());

        return out.toString();

    }

}
