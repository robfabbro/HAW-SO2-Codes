package Lecture4;

public class Main {
  public static void main(String[] args) {
    int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 7 };
    Main main = new Main();
    System.out.println("Array before sorting:");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
    main.arrayAscendingSort(arr);
    System.out.println("Array after sorting:");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public void arrayAscendingSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          // swap arr[j] and arr[j+1]
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }
}