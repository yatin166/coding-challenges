package practice_random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencyWiseSorting {

    public static void main(String[] args) {
        int[] nums = {-1,1,-6,4,5,-6,1,4,1};
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));

        int[] result = Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
                .mapToInt(num -> num)
                .toArray();
        System.out.println(Arrays.toString(result));
    }
}
