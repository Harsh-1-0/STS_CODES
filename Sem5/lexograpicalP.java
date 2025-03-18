public class lexograpicalP {

    public static String lexographical(String str) {
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }
        int oddCount = 0;
        for (int i = 0; i < freq[i]; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
            }
        }
        String oddString = "";
        if (oddCount > 1) {
            return "Not Possible";
        } else {
            for (int i = 0; i < 26; i++) {
                if (freq[i] % 2 != 0) {
                    oddString += (char) (i + 'a');
                    freq[i]--;
                    break;
                }
            }
        }
        String frontStr = "", rearStr = "";
        for (int i = 0; i < 26; i++) {
            String temp = "";
            if (freq[i] > 0) {
                for (int j = 0; j < freq[i] / 2; j++) {
                    temp += (char) (i + 'a');
                }
            }
            frontStr = frontStr + temp;
            rearStr = temp + rearStr;
        }
        return frontStr + oddString + rearStr;
    }

    public static void main(String[] args) {
        String str = "malayalam";
        System.out.println(lexographical(str));
    }
}
