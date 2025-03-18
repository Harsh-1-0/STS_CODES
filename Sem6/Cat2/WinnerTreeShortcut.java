public class WinnerTreeShortcut {
    public static void main(String[] args) {
        int[] players = { 3, 7, 1, 9, 4, 2, 8, 5 };
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < players.length; i++) {
            if (players[i] < min) {
                min = players[i];
            }
        }
        System.out.println(min);
    }
}
