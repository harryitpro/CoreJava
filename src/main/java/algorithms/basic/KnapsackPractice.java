package algorithms.basic;

public class KnapsackPractice {
    static int getMaxValue(int[] weights, int[] values, int capacity) {
        int itemLength = weights.length;
        int[][] maxValues = new int[itemLength + 1][capacity + 1];
        for (int row = 1; row <= itemLength; row++) {
            int itemWeight = weights[row - 1];
            int itemValue = values[row - 1];
            for (int col = 1; col <= capacity; col++) {
                int existingMaxValueWithoutCurrentItem = maxValues[row - 1][col];
                if (itemWeight > col) { //current item is heavier than knapsack capacity, skip current item
                    maxValues[row][col] = existingMaxValueWithoutCurrentItem;
                } else {
                    int maxValueWithCurrentItem = maxValues[row - 1][col - itemWeight] + itemValue;
                    maxValues[row][col] = Math.max(existingMaxValueWithoutCurrentItem, maxValueWithCurrentItem);
                }
            }
        }
        return maxValues[itemLength][capacity];
    }

    public static void main(String[] args) {
        int[] itemWeight = {1, 3, 4};
        int[] itemValue = {100, 400, 500};
        int capacity = 5;

        int table = getMaxValue(itemWeight, itemValue, capacity);
        System.out.println("Maximum value in knapsack: " + table);
    }
}
