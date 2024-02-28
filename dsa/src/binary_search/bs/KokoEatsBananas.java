package binary_search.bs;

public class KokoEatsBananas {

    private static int perHourSpeed(int[] piles, int h) {
        boolean flag = true;
        int ans = 0;
        for (int num: piles) {
            ans = Math.max(num, ans);
        }

        if (piles.length == h) {
            return ans;
        }

        while (flag) {
            int requiredHours = 0;
            for (int pile : piles) {
                requiredHours += (int)Math.ceil((float) pile / ans);
            }
            if (requiredHours > h || ans == 0) {
                ans = ans + 1;
                flag = false;
            } else {
                ans--;
            }
        }

        return ans;
    }

    private static int requiredHours(int[] piles, int h) {
        int requiredHours = 0;
        for (int pile: piles) {
            /*requiredHours += (int)Math.ceil((float) pile / h);*/


            int hoursToEatPile = pile / h;
            requiredHours += hoursToEatPile;
            if (pile % h != 0) {
                requiredHours++;
            }
        }
        return requiredHours;
    }

    private static int usingBinarySearch(int[] piles, int h) {
        int start = 1;
        int end = 0;
        for (int pile: piles) {
            end = Math.max(end, pile);
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (requiredHours(piles, mid) > h) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] piles = new int[] {3,6,7,11};
        System.out.println(usingBinarySearch(piles, 8));
    }
}
