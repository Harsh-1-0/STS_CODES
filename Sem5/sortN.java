import java.util.*;
import java.util.regex.*;

public class sortN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String input = sc.nextLine();
        String[] strings = input.split(",");

        Arrays.sort(strings, (s1, s2) -> {
            Pattern pattern = Pattern.compile("(\\D+)(\\d+)");
            Matcher m1 = pattern.matcher(s1);
            Matcher m2 = pattern.matcher(s2);

            while (m1.find() && m2.find()) {
                int stringComparion = m1.group(1).compareTo(m2.group(1));
                if (stringComparion != 0) {
                    return stringComparion;
                }
                int numberComparison = Integer.compare(Integer.parseInt(m1.group(2)), Integer.parseInt(m2.group(2)));
                if (numberComparison != 0) {
                    return numberComparison;
                }
            }

            return s1.compareTo(s2);
        });
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
