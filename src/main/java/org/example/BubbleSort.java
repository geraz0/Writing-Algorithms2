package org.example;

import java.util.Arrays;

public class BubbleSort {
    private int[] array;

    public BubbleSort(int[] array) {
        this.array = array;
    }

    // Method to perform the bubble sort
    public void sort() {
        int n = this.array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (this.array[j] > this.array[j + 1]) {
                    // Swapping the elements if they are in the wrong order
                    int temp = this.array[j];
                    this.array[j] = this.array[j + 1];
                    this.array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }

    // Returns a string representation of the array
    public String getSortedArray() {
        return Arrays.toString(this.array);
    }

    // Main method for testing the bubble sort with specific examples
    public static void main(String[] args) {
        int[] example1 = {4, 1, 3, 9, 7};  // First example input
        int[] example2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // Second example input

        // Creating BubbleSort instances for each example
        BubbleSort sorter1 = new BubbleSort(example1);
        BubbleSort sorter2 = new BubbleSort(example2);

        // Sorting and printing the results for each example
        sorter1.sort();
        System.out.println("Sorted Array Example 1: " + sorter1.getSortedArray());

        sorter2.sort();
        System.out.println("Sorted Array Example 2: " + sorter2.getSortedArray());
    }
}
