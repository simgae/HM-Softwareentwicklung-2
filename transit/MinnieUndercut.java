import edu.hm.cs.rs.se.ss23.a07.MinnieBooker; // X
import edu.hm.cs.rs.se.ss23.a08.Just6;
import edu.hm.cs.rs.se.ss23.a08.Only5;
import edu.hm.cs.rs.se.ss23.a08.Player;
import edu.hm.cs.rs.se.ss23.a08.Undercut;

/** Moderator des Spieles Undercut.
 * @version 2023-03-18
 */
public class MinnieUndercut {
    /** Hauptprogramm.
     * Gibt am Ende den Gewinner aus oder null bei einem Unentschieden.
     * @param args Kommandozeilenargumente: keine.
     */
    public static void main(String... args) {
        final Undercut undercut = new Undercut(new MinnieBooker());
        final Player winner = undercut.run(new Only5(), new Just6());
        System.out.println("the winner is: " + winner);
    }
}
