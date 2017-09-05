import java.io.BufferedInputStream;
import java.util.Scanner;

/*
 * Implementation based on the scoreboard problem from Sec 3.1
 *
 * Author: Jeanderson Candido <http://jeandersonbc.github.io>
 */
class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int testcases = in.nextInt();
        while (testcases-- > 0) {
            int capacity = in.nextInt();
            int entries = in.nextInt();

            for (int e = 0; e < entries; e++) {
                String player = in.next();
                int score = in.nextInt();
            }
        }
        in.close();
    }
}
