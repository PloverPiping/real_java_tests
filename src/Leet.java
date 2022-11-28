import java.util.*;

public class Leet {

    public static List<String> strongPasswordChecker(String password) {

        // Initialize output list
        List<String> output = new ArrayList<>();
        output.add(password);

        // Convert input string into list
        List<Character> list = new ArrayList<>();
        for (char ch : password.toCharArray()) {
            list.add(ch);
        }

        // Check length
        int length = list.size();
        if (length > 6 && length < 20) {
            output.add("Right size");
        }

        // Initialize a buffer for later
        List<Character> buffer = new ArrayList<>();

        for (Character character : list) {
            // Check for each of the character requirements
            if (Character.isDigit(character)) {
                output.add("Has a digit");
            }
            if (Character.isUpperCase(character)) {
                output.add("Has an uppercase letter");
            }
            if (Character.isLowerCase(character)){
                output.add("Has a lowercase letter");
            }

            // Check for repeating characters
            buffer.add(character);
            if (Collections.frequency(buffer, character) == 3){
                output.add("Too many characters");
                output.add("" + buffer);
            }
            if(buffer.size() == 3){
                buffer.remove(0);
            }
        }

        // Check for repeating characters

        return output;
    }

    public static void main(String[] args) {
        List<String> zoo = new ArrayList<>();
        zoo.add("Apple");
        zoo.add("Apple");
        zoo.add("Apple");
        zoo.add("Bamnnannannna");
        int apples = Collections.frequency(zoo, "apple");
        System.out.println(apples);

        System.out.println(strongPasswordChecker("aA1_._._000..ppp.p.2"));



    }
}
