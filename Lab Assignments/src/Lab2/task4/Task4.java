package task4;

import java.util.Random;
import java.util.Scanner;

public class Task4 {

  public static void main(String[] args) throws Exception {

    // Initialises Scanner
    Scanner scanner = new Scanner(System.in);

    // Generates and display array:
    Random random = new Random();
    int[] numbers = new int[10];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = random.nextInt(100) + 1; // 1-100
    }

    printArray(numbers, "Generated Array");

    // Bubble sorts the array
    bubbleSort(numbers);

    // Displays the Array
    printArray(numbers, "After Bubble Sort");

    // Prompts user to enter a search target value
    System.out.println("\n\n Choose a target value for the Search Algorithms: ");
    int searchTarget = scanner.nextInt();

    // Performs Linear Search on Array with Target
    int linearSearchResult = linearSearch(numbers, searchTarget);

    // Prints result of linear search
    System.out.println("\nResult of Linear Search: " + linearSearchResult);

    // Performs binary Search on Array with Target
    int binarySearchResult = binarySearch(numbers, searchTarget);

    // Prints result of binary search
    System.out.println("\nResult of Binary Search: " + binarySearchResult);

    // Closes Scanner
    scanner.close();

  }

  public static void printArray(int[] arr, String header) {
    System.out.println("\n\n" + header + ": ");
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
      if (i < arr.length - 1) {
        System.out.print(arr[i] + ", ");
      } else {
        System.out.print(arr[i]);
      }
    }
    System.out.print("]");
  }

  public static void bubbleSort(int[] arr) {
    int arr_length = arr.length;
    boolean swapped;

    for (int i = 0; i < arr_length - 1; i++) {
      swapped = false;
      for (int j = 0; j < arr_length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          // Swap arr[j] and arr[j+1]
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swapped = true;
        }
      }
      // If no two elements were swapped by inner loop, then break
      if (!swapped) {
        break;
      }
    }
  }

  public static int linearSearch(int[] arr, int target) {
    int comparisonsCount = 0;

    // Linear search through the array
    for (int i = 0; i < arr.length; i++) {
      // Increment comparisons count for each comparison made
      comparisonsCount++;
      // Check if the current element matches the target
      if (arr[i] == target) {
        System.out.println("\nAmount of comparisons: " + comparisonsCount);
        return i;
      }
    }
    // If the target is not found, return -1
    System.out.println("\nAmount of comparisons: " + comparisonsCount);
    return -1;
  }

  public static int binarySearch(int[] arr, int target) {
    int comparisonsCount = 0;
    // initialize low and high pointers for the binary search
    int low = 0;
    int high = arr.length - 1;

    // Perform binary search while the low pointer is less than or equal to the high
    // pointer
    while (low <= high) {
      comparisonsCount++;
      // Calculate the middle index of the current search range
      int mid = (low + high) / 2;
      // Check if the middle element is equal to the target
      if (arr[mid] == target) {
        // If found, print the number of comparisons and return the index
        System.out.println("\nAmount of comparisons: " + comparisonsCount);
        return mid;
        // If the middle element is less than the target, search in the right half
      } else if (arr[mid] < target) {
        low = mid + 1;
        // Otherwise if the middle element is greater than the target, search in the
        // left half
      } else {
        high = mid - 1;
      }
    }

    System.out.println("\nAmount of comparisons: " + comparisonsCount);
    return -1;
  }

}
