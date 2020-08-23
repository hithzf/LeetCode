package design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * TODO
 * 两个Integer类型的数据进行比较，竟然用了==
 * 基础不扎实啊
 */
public class Offer59 {

    private Deque<Integer> data;
    private Deque<Integer> max;

    public Offer59() {
        data = new ArrayDeque<>();
        max = new ArrayDeque<>();
    }

    public int max_value() {
        return data.isEmpty() ? -1 : max.peekFirst();
    }

    public void push_back(int value) {
        data.addLast(value);
        while (!max.isEmpty() && max.peekLast() < value) {
            max.removeLast();
        }
        max.addLast(value);
    }

    public int pop_front() {
        if (data.isEmpty()) {
            return -1;
        }
        int val = data.removeFirst();
        if (max.peekFirst() == val) {
            max.removeFirst();
        }
        return val;
    }

    public int pop_front_wrong() {
        if (data.isEmpty()) {
            return -1;
        }
        if (max.peekFirst().equals(data.peekFirst())) {
            max.removeFirst();
        }
        return data.removeFirst();
    }

    public static void main(String[] args) {
        Offer59 solution = new Offer59();
        solution.push_back(46);
        System.out.println(solution.pop_front_wrong());
        System.out.println(solution.pop_front_wrong());
        solution.push_back(868);
        System.out.println(solution.pop_front_wrong());
        System.out.println(solution.pop_front_wrong());
        System.out.println(solution.pop_front_wrong());
        solution.push_back(525);
        System.out.println(solution.pop_front_wrong());
        System.out.println(solution.pop_front_wrong());
        solution.push_back(123);
        solution.push_back(466);
        System.out.println(solution.max_value());
    }
}
