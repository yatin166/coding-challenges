package binary_search;

import java.util.Arrays;

//https://leetcode.com/problems/koko-eating-bananas/description/
public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (canBeEaten(piles, h, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private static boolean canBeEaten(int[] piles, int h, int k) {
        int totalHoursToEat = 0;
        for (int pile:piles) {
            int hoursToEatPile = pile / k;
            totalHoursToEat += hoursToEatPile;
            if (pile % k != 0) {
                totalHoursToEat++;
            }
        }

        return totalHoursToEat <= h;
    }

    public static void main(String[] args) {
        int[] arr = { 100000000 };
        int hours = 2;
        System.out.println(minEatingSpeed(arr, hours));
    }
}
