package org.example;

public class Main {
    public static void main(String[] args) {
        int arr[] = {5, 6, 8, 13, 17, 21, 25, 37};
        int target = 38;

        System.out.println("Linear search: " + linearSearch(arr, target));
        System.out.println("Binary search: " + binarySearch(arr, target));
        System.out.println("Binary recursive: " + binaryRecursive(arr, target, 0, arr.length - 1));

    }

    public static int linearSearch(int[] nums, int target) {

        int index = -1;
        int steps = 0;
        for(int i = 0; i < nums.length; i++) {
            steps++;
            if(nums[i] == target) {
                index = i;
                break;
            }
        }

        System.out.println("Steps taken: " + steps);
        return index;
    }

    public static int binarySearch(int[] nums, int target) {

        int index = -1;
        int steps = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            steps++;
            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println("Steps taken: " + steps);
        return index;
    }

    public static int binaryRecursive(int[] nums, int target, int left, int right) {
        if(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
               return mid;
            } else if(nums[mid] > target) {
                return binaryRecursive(nums, target, left, mid - 1);
            } else {
                return binaryRecursive(nums, target, mid + 1, right);
            }
        }
        return -1;
    }
}