// 649. Dota2 参议院
package stack_queue;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution649 {

    public String predictPartyVictory(String senate) {
        Queue<Integer> queueRadiant = new ArrayDeque<>();
        Queue<Integer> queueDire = new ArrayDeque<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') queueRadiant.offer(i);
            else queueDire.offer(i);
        }

        while (!queueRadiant.isEmpty() && !queueDire.isEmpty()) {
            int r = queueRadiant.poll();
            int d = queueDire.poll();
            if (r < d) {
                queueRadiant.offer(r + n);
            } else {
                queueDire.offer(d + n);
            }
        }

        return queueRadiant.isEmpty() ? "Dire" : "Radiant";
    }

}
