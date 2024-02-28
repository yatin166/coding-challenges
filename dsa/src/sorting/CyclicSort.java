package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicSort {

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }

    // Leetcode 268 Missing no
    private static int missingNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i];
            if (correct >= arr.length) {
                i++;
            } else if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        int missingNumber = 0;
        for (missingNumber = 0; missingNumber < arr.length; missingNumber++) {
            if (arr[missingNumber] != missingNumber) {
                return missingNumber;
            }
        }
        return missingNumber;
    }

    private static List<Integer> findAllDuplicatesInArray(int[] nums) {
        int i = 0;
        List<Integer> list = new ArrayList<>();

        // This will take O(n^2) complexity due to contains
        /*while (i < nums.length) {
            if (nums[i] != i+1) {
                int correct = nums[i] - 1;
                if (nums[i] != nums[correct]) {
                    int temp = nums[i];
                    nums[i] = nums[correct];
                    nums[correct] = temp;
                } else {
                    if (!list.contains(nums[i])) {
                        list.add(nums[i]);
                    }
                    i++;
                }
            } else {
                i++;
            }
        }*/

        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                list.add(nums[index]);
            }
        }

        return list;
    }

    // Leetcode 645 Set Mismatch
    public static int[] findErrorNums(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

        int[] result = {-1,-1};

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index +1) {
                result[0] = nums[index];
                result[1] = index + 1;
            }
        }

        return result;

    }

    //Leetcode 41 First missing positive no
    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        //System.out.println(Arrays.toString(findErrorNums(arr)));
        System.out.println(firstMissingPositive(arr));
    }
}
