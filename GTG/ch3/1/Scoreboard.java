import java.io.BufferedInputStream;
import java.util.Scanner;

/*
 * Implementation based on the scoreboard problem from Sec 3.1
 *
 * Author: Jeanderson Candido <http://jeandersonbc.github.io>
 */
class Main {

    static class GameEntry {
        private String player;
        private int score;
        public GameEntry(String player, int score) {
            this.player = player;
            this.score = score;
        }
        public int getScore() { return this.score; }
        public String getPlayer() { return this.player; }

        @Override
        public String toString() {
            return String.format("%s - %d", getPlayer(), getScore());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int testcases = in.nextInt();
        while (testcases-- > 0) {
            int capacity = in.nextInt();
            int entries = in.nextInt();

            for (int e = 0; e < entries; e++) {
                String player = in.next();
                int score = in.nextInt();
                GameEntry entry = new GameEntry(player, score);
                System.out.println(entry);
            }
        }
        in.close();
    }
}
