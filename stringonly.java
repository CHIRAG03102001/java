public class ReverseLetters {

    public static String reverseLettersOnly(String input) {
        // Validate the input
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        
        // StringBuilder to collect letters
        StringBuilder letters = new StringBuilder();
        
        // Collect letters from the input string
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.append(c);
            }
        }
        
        // Reverse the letters
        letters.reverse();
        
        // StringBuilder to build the result
        StringBuilder result = new StringBuilder();
        int letterIndex = 0;
        
        // Rebuild the string with reversed letters and original numbers
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append(letters.charAt(letterIndex++));
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        // Example usage
        String input = "ez56d";
        String reversed = reverseLettersOnly(input);
        System.out.println("Reversed String: " + reversed);
    }
}
