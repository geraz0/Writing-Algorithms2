package org.example;

import java.util.ArrayList;

public class SearchPattern {
    private String text;
    private String pattern;

    public SearchPattern(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
    }

    // Method to search the pattern in the text using the Z-algorithm
    public ArrayList<Integer> search() {
        String combined = pattern + "$" + text;
        int[] Z = new int[combined.length()];
        ArrayList<Integer> result = new ArrayList<>();
        int L = 0, R = 0, K;

        // Constructing the Z array
        for (int i = 1; i < combined.length(); i++) {
            if (i > R) {
                L = R = i;
                while (R < combined.length() && combined.charAt(R - L) == combined.charAt(R)) {
                    R++;
                }
                Z[i] = R - L;
                R--;
            } else {
                K = i - L;
                if (Z[K] < R - i + 1) {
                    Z[i] = Z[K];
                } else {
                    L = i;
                    while (R < combined.length() && combined.charAt(R - L) == combined.charAt(R)) {
                        R++;
                    }
                    Z[i] = R - L;
                    R--;
                }
            }
            if (Z[i] == pattern.length()) {
                result.add(i - pattern.length() - 1 + 1); // +1 for 1-based index
            }
        }

        return result;
    }

    // Main method to demonstrate the search of specific examples
    public static void main(String[] args) {
        String example1Text = "batmanandrobinarebat";
        String example1Pattern = "bat";
        SearchPattern searchPattern1 = new SearchPattern(example1Text, example1Pattern);

        String example2Text = "abesdu";
        String example2Pattern = "edu";
        SearchPattern searchPattern2 = new SearchPattern(example2Text, example2Pattern);

        ArrayList<Integer> results1 = searchPattern1.search();
        ArrayList<Integer> results2 = searchPattern2.search();

        System.out.println("Example 1 - Pattern 'bat' found at indices: " + results1 + " (Found " + results1.size() + " times)");
        System.out.println("Example 2 - Pattern 'edu' found at indices: " + results2 + " (Found " + results2.size() + " times)");
    }
}
