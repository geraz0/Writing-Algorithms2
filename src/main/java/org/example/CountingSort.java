package org.example;

public class CountingSort {
    private final String text;

    public CountingSort(String text) {
        this.text = text;
    }

    // Method to perform the counting sort on a string
    public String sort() {
        int[] count = new int[256];  // Array to hold the count of each character
        char[] output = new char[this.text.length()];

        // Fill the count array with the frequency of each character
        for (char c : this.text.toCharArray()) {
            count[c]++;
        }

        // Modify the count array by adding the count of the previous characters
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        // Build the output character array
        for (int i = this.text.length() - 1; i >= 0; i--) {
            output[count[this.text.charAt(i)] - 1] = this.text.charAt(i);
            count[this.text.charAt(i)]--;
        }

        return new String(output);
    }

    // Main method to demonstrate the sorting of specific examples
    public static void main(String[] args) {
        String example1 = "edsab";
        String example2 = "geeksforgeeks";

        CountingSort sorter1 = new CountingSort(example1);
        CountingSort sorter2 = new CountingSort(example2);

        System.out.println("Sorted String Example 1: " + sorter1.sort());
        System.out.println("Sorted String Example 2: " + sorter2.sort());
    }
}
