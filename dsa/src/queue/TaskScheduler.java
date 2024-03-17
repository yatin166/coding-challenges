package queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

    private static int leastIntervalUsingPriorityQueue(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.addAll(map.values());

        int cycles = 0;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!queue.isEmpty()) {
                    list.add(queue.remove());
                }
            }

            for (int frequency: list) {
                if (--frequency > 0) {
                    queue.add(frequency);
                }
            }

            cycles += queue.isEmpty() ? list.size() : n + 1;
        }

        return cycles;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int cooling = 2;
        System.out.println(leastIntervalUsingPriorityQueue(tasks, cooling));
    }
}
