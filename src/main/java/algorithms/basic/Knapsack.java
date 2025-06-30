package algorithms.basic;

public class Knapsack {

    // Function to solve 0/1 Knapsack Problem using Dynamic Programming
    public static int knapsack(int[] itemWeight, int[] itemValue, int knapsackCapacity) {
        int n = itemWeight.length;
        int[][] table = new int[n + 1][knapsackCapacity + 1];

        // Build table[][] in bottom-up manner
        for (int tableRowIndex = 1; tableRowIndex <= n; tableRowIndex++) {
            int itemIndex = tableRowIndex - 1;
            for (int currentKnapsackCapacity = 1; currentKnapsackCapacity <= knapsackCapacity; currentKnapsackCapacity++) {
                int currentItemWeight = itemWeight[itemIndex];
                int currentItemValue = itemValue[itemIndex];

                if (currentItemWeight <= currentKnapsackCapacity) {
                    // check element at previous row (tableRowIndex - 1), and column of (currentKnapsackCapacity - currentItemWeight).
                    int maxValueWithCurrentItem =
                            currentItemValue + table[tableRowIndex - 1][currentKnapsackCapacity - currentItemWeight];

                    // check element at previous row (tableRowIndex - 1), and column of currentKnapsackCapacity.
                    int maxValueWithoutCurrentItem = table[tableRowIndex - 1][currentKnapsackCapacity];

                    int max = Math.max(maxValueWithCurrentItem, maxValueWithoutCurrentItem);
                    table[tableRowIndex][currentKnapsackCapacity] = max;
                } else {
                    // Can't include item i
                    table[tableRowIndex][currentKnapsackCapacity] = table[tableRowIndex - 1][currentKnapsackCapacity];
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

