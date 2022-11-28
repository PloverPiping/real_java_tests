import java.util.*;
public class fuckYOu {
    public static String eye_generator(){

        // Initialize our variables
        Random rand = new Random();
        StringBuilder output = new StringBuilder();
        int length = rand.nextInt(49);
        int combo = rand.nextInt(4);

        // Append the correct number of _
        output.append("_".repeat(length));

        // Add the correct combo of characters
        switch (combo) {
            case 0:
                output.insert(0, "o");
                output.append("o");
            case 1:
                output.insert(0, "o");
                output.append("0");
            case 2:
                output.insert(0, "0");
                output.append("o");
            case 3:
                output.insert(0, "0");
                output.append("0");
        }
        return output.toString();

    }
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            System.out.println(eye_generator());
        }
    }

}