import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashGenerator {

    // Method to compute MD5 hash of a string
    public static String getMD5Hash(String input) {
        try {
            // Create an MD5 digest instance
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Perform the hashing
            byte[] digest = md.digest(input.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    public static void main(String[] args) {
        // Example usage
        String input = "Hello, World!";
        String md5Hash = getMD5Hash(input);
        System.out.println("MD5 Hash of \"" + input + "\" is: " + md5Hash);
    }
}
