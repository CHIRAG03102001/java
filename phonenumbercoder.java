import java.util.HashMap;
import java.util.Map;

public class PhoneNumberDecoder {
    
    // Mapping of letters to digits
    private static final Map<Character, Character> letterToDigitMap = new HashMap<>();
    
    static {
        letterToDigitMap.put('A', '2');
        letterToDigitMap.put('B', '2');
        letterToDigitMap.put('C', '2');
        letterToDigitMap.put('D', '3');
        letterToDigitMap.put('E', '3');
        letterToDigitMap.put('F', '3');
        letterToDigitMap.put('G', '4');
        letterToDigitMap.put('H', '4');
        letterToDigitMap.put('I', '4');
        letterToDigitMap.put('J', '5');
        letterToDigitMap.put('K', '5');
        letterToDigitMap.put('L', '5');
        letterToDigitMap.put('M', '6');
        letterToDigitMap.put('N', '6');
        letterToDigitMap.put('O', '6');
        letterToDigitMap.put('P', '7');
        letterToDigitMap.put('Q', '7');
        letterToDigitMap.put('R', '7');
        letterToDigitMap.put('S', '7');
        letterToDigitMap.put('T', '8');
        letterToDigitMap.put('U', '8');
        letterToDigitMap.put('V', '8');
        letterToDigitMap.put('W', '9');
        letterToDigitMap.put('X', '9');
        letterToDigitMap.put('Y', '9');
        letterToDigitMap.put('Z', '9');
    }

    public static String decodePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }

        StringBuilder digitPhoneNumber = new StringBuilder();
        for (char c : phoneNumber.toCharArray()) {
            if (Character.isLetter(c)) {
                digitPhoneNumber.append(letterToDigitMap.get(Character.toUpperCase(c)));
            } else {
                digitPhoneNumber.append(c);
            }
        }

        // Format the phone number
        return formatPhoneNumber(digitPhoneNumber.toString());
    }

    private static String formatPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }

        return String.format("(%s) %s-%s",
                phoneNumber.substring(0, 3),
                phoneNumber.substring(3, 6),
                phoneNumber.substring(6));
    }

    public static void main(String[] args) {
        // Example usage
        String inputPhoneNumber = "800888TEST";
        String decodedPhoneNumber = decodePhoneNumber(inputPhoneNumber);
        System.out.println("Decoded Phone Number: " + decodedPhoneNumber);
    }
}
