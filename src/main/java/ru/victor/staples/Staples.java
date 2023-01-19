package ru.victor.staples;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Staples {
    // tests in test
    public String checkStaples(String str) {
        Queue<Character> queue = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        List<Integer> iter = new ArrayList<>();
        int count = 0;
        char[] staples = str.toCharArray();
        for (char staple : staples) {
            if (queue.size() != 0 && staple == queue.peek()) {
                result.append(queue.poll());
                count += 2;
                iter.remove(iter.size() - 1);
            }
            if (staple == '(') {
                queue.offer(')');
                result.append('(');
                iter.add(result.length() - 1);
            }
        }
        if (count == 0) {
            return count + "";
        }
        iter.forEach(result::deleteCharAt);
        return count + " - " + result;
    }
}