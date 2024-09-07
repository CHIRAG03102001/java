import java.util.HashSet;
import java.util.Set;

public class ConsecutiveNumbersChecker {

    public static boolean canBeConsecutive(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false; // An empty or null array cannot form consecutive numbers
        }

        Set<Integer> numberSet = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Process each number in the array
        for (int num : numbers) {
            if (!numberSet.add(num)) {
                // Duplicate number found
                return false;
            }
            // Update min and max values
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        // Check if the range covers all consecutive numbers
        return (max - min + 1) == numbers.length;
    }

    public static void main(String[] args) {
        // Example usage
        int[] numbers1 = {5, 3, 4, 6, 7}; // True: 3, 4, 5, 6, 7 are consecutive
        int[] numbers2 = {1, 2, 4, 5};    // False: 1, 2, 4, 5 are not consecutive
        int[] numbers3 = {10, 12, 11};    // True: 10, 11, 12 are consecutive
        int[] numbers4 = {10, 11, 11};    // False: Duplicate number

        System.out.println("Can be consecutive: " + canBeConsecutive(numbers1));
        System.out.println("Can be consecutive: " + canBeConsecutive(numbers2));
        System.out.println("Can be consecutive: " + canBeConsecutive(numbers3));
        System.out.println("Can be consecutive: " + canBeConsecutive(numbers4));
    }
}
