package stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    private static int[] asteroidCollisionUsingStack(int[] asteroids) {
        if (asteroids.length <= 1) {
            return asteroids;
        }

        Stack<Integer> stack = new Stack<>();

        for (int asteroid: asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                // pop until positive element found which is < abs(asteroid)
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }
                // pop if asterid == peek
                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                }
                // push negative value in stack
                else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
            }
        }

        int[] result = new int[stack.size()];
        // reverse
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] asteroids = {10,3,4,6,-5,-8,-22,-1};
        System.out.println(Arrays.toString(asteroidCollisionUsingStack(asteroids)));
    }
}
