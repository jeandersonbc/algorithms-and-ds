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
    static class Scoreboard {
        private GameEntry[] scores;
        private int entries;
        public Scoreboard(int capacity) {
            this.scores = new GameEntry[capacity];
            this.entries = 0;
        }
        public void insert(GameEntry entry) {
            int newScore = entry.getScore();
            if (entries < scores.length || newScore > scores[scores.length - 1].getScore()) {
                if (entries < scores.length)
                    entries++;
                int pos = entries - 1;
                while (pos > 0 && newScore > scores[pos - 1].getScore()) {
                    scores[pos - 1] = scores[pos];
                    pos--;
                }
                scores[pos] = entry;
            }
        }
        @Override
        public String toString() {
            StringBuilder str = new StringBuilder("Scoreboard\n");
            GameEntry entry = null;
            for (int i = 0; i < this.entries; i++) {
                entry = this.scores[i];
                str.append(String.format("%3d - %s\n", entry.getScore(), entry.getPlayer()));
            }
            return str.toString();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int testcases = in.nextInt();
        while (testcases-- > 0) {
            int capacity = in.nextInt();
            int entries = in.nextInt();

            Scoreboard scoreboard = new Scoreboard(capacity);
            for (int e = 0; e < entries; e++) {
                String op = in.next();
                if ("+".equals(op)) {
                    String player = in.next();
                    int score = in.nextInt();
                    scoreboard.insert(new GameEntry(player, score));
                }
                System.out.println(scoreboard);
            }
        }
        in.close();
    }
}
