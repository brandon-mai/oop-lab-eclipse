// Exercise 6.5: Sort an inputed array, calculate sum and average values

import java.util.*;

public class ArraySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numeric array items separated by whitespace:");
        String line = sc.nextLine();
        String[] arr = line.trim().split("\\s+");

        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(nums);

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        double average = (double) sum / nums.length;

        // Print the sorted array, sum, and average
        System.out.println("Sorted array: " + Arrays.toString(nums));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
