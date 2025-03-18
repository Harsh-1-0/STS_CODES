public class moveHyphen {
    public static void main(String[] args) {
        String s = "Harsh-Kumar-Sinha";
        String trans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                trans = "-" + s.substring(0, i) + s.substring(i + 1);
                s = trans;
            }
        }
        System.out.println(s);
    }
}