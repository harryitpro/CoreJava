package algorithms.basic;

public class Knapsack {

    // Function to solve 0/1 Knapsack Problem using Dynamic Programming
    public static int knapsack(int[] itemWeight, int[] itemValue, int knapsackCapacity) {
        int n = itemWeight.length;
        int[][] table = new int[n + 1][knapsackCapacity + 1];

        // Build table[][] in bottom-up manner
        for (int tableRowIndex = 1; tableRowIndex <= n; tableRowIndex++) {
            int itemIndex = tableRowIndex - 1;
            for (int currentTableCapacity = 1; currentTableCapacity <= knapsackCapacity; currentTableCapacity++) {
                int currentItemWeight = itemWeight[itemIndex];
                int currentItemValue = itemValue[itemIndex];

                if (currentItemWeight <= currentTableCapacity) {
                    // check element at previous row (tableRowIndex - 1), and column of (currentTableCapacity - currentItemWeight).
                    int includeCurrentItem =
                            currentItemValue + table[tableRowIndex - 1][currentTableCapacity - currentItemWeight];

                    // check element at previous row (tableRowIndex - 1), and column of currentTableCapacity.
                    int excludeCurrentItem = table[tableRowIndex - 1][currentTableCapacity];

                    int max = Math.max(includeCurrentItem, excludeCurrentItem);
                    table[tableRowIndex][currentTableCapacity] = max;
                } else {
                    // Can't include item i
                    table[tableRowIndex][currentTableCapacity] = table[tableRowIndex - 1][currentTableCapacity];
                }
            }
        }

        return table[n][knapsackCapacity];  // Max value for full capacity
    }

    public static void main(String[] args) {
        int[] itemWeight = {1, 3, 4};
        int[] itemValue = {100, 400, 500};
        int capacity = 5;

        int table = knapsack(itemWeight, itemValue, capacity);
        System.out.println("Maximum value in knapsack: " + table);
    }
}

