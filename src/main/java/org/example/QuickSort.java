package org.example;

import java.util.Arrays;

public class QuickSort {
    private int[] array;

    // Constructor initializes the array
    public QuickSort(int[] array) {
        this.array = array;
    }

    // Method to perform the Quick Sort using recursion
    public void sort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);  // Partitioning index
            sort(low, pi - 1);              // Sort the left part
            sort(pi + 1, high);             // Sort the right part
        }
    }

    // Helper method to partition the array around the pivot
    private int partition(int low, int high) {
        int pivot = array[high];  // Taking the last element as pivot
        int i = (low - 1);        // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (array[j] < pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Public method to get the sorted array
    public String getSortedArray() {
        return Arrays.toString(this.array);
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        int[] example1 = {4, 1, 3, 9, 7};
        int[] example2 = {2, 1, 6, 10, 4, 1, 3, 9, 7};

        QuickSort quickSort1 = new QuickSort(example1);
        QuickSort quickSort2 = new QuickSort(example2);

        quickSort1.sort(0, example1.length - 1);
        quickSort2.sort(0, example2.length - 1);

        System.out.println("Sorted Array Example 1: " + quickSort1.getSortedArray());
        System.out.println("Sorted Array Example 2: " + quickSort2.getSortedArray());
    }
}
