import java.util.ArrayList;
import java.util.Scanner;

/**
 * Starter fo SevenHandshakesApplication&
 */
public class Starter {
    public static void main(String[] args) {

      /*  Scanner scanner = new Scanner(System.in);

        System.out.println("Enter userId: ");
        int userId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter target userId: ");
        int targetUserId = Integer.parseInt(scanner.nextLine());
*/
        try {
            Handshake handshake = new Handshake(2691570, 1785797);
            handshake.find(2);
        } catch (Exception e){
             System.out.println(e.getMessage());
        }
    }
}
