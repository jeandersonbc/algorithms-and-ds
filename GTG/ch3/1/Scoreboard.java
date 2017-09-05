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
            if (this.entries == 0) {
                this.scores[this.entries] = entry;
                this.entries++;
                return;
            }
            if (this.entries == this.scores.length) {
                if (this.scores[this.entries - 1].getScore() > entry.getScore())
                    return;
                this.entries--;
            }
            int position = this.entries - 1;
            while (position >= 0 && this.scores[position].getScore() < entry.getScore()) {
                this.scores[position + 1] = this.scores[position];
                position--;
            }
            this.scores[position + 1] = entry;
            this.entries++;
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
                String player = in.next();
                int score = in.nextInt();
                scoreboard.insert(new GameEntry(player, score));
                System.out.println(scoreboard);
            }
        }
        in.close();
    }
}
