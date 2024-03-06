package linked_list;

public class HappyNumber {

    private static int getSquare(int num) {
        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            ans += rem * rem;
            num = rem / 10;
        }
        return ans;
    }

    private static boolean isHappy(int num) {
        int slow = num;
        int fast = num;

        do {
            slow = getSquare(slow);
            fast = getSquare(getSquare(fast));
        } while (fast != slow);

        // going sequentially so it will be 1 eventually if happy num is provided
        if (slow == 1) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
