import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

public class naturalSort {
    public static void main(String[] args) {
        // Taking custom input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter comma-separated strings:");
        String input = scanner.nextLine();
        String[] strings = input.split(",");

        // Sorting the strings using the natural order
        Arrays.sort(strings, (s1, s2) -> {
            Pattern pattern = Pattern.compile("(\\D+)(\\d+)");
            Matcher m1 = pattern.matcher(s1);
            Matcher m2 = pattern.matcher(s2);

            while (m1.find() && m2.find()) {
                int textComparison = m1.group(1).compareTo(m2.group(1));
                if (textComparison != 0)
                    return textComparison;

                int numberComparison = Integer.compare(Integer.parseInt(m1.group(2)), Integer.parseInt(m2.group(2)));
                if (numberComparison != 0)
                    return numberComparison;
            }

            return s1.compareTo(s2); // fallback to lexicographical order if no numbers
        });

        // Output the sorted array
        System.out.println("Sorted Strings: " + Arrays.toString(strings));

        scanner.close();
    }
}