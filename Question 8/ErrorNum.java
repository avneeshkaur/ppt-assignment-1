

// 💡 **Q8.** You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

// You are given an integer array nums representing the data status of this set after the error.

// Find the number that occurs twice and the number that is missing and return them in the form of an array.

// **Example 1:**
// Input: nums = [1,2,2,4]
// Output: [2,3]


import java.util.Arrays;

public class ErrorNum {
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] result = new int[2];

        // Find the duplicate number
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] < 0) {
                result[0] = num;
            } else {
                nums[num - 1] = -nums[num - 1];
            }
        }

        // Find the missing number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result[1] = i + 1;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};

        int[] errorNums = findErrorNums(nums);

        System.out.println("Duplicate number: " + errorNums[0]);
        System.out.println("Missing number: " + errorNums[1]);
    }
}
