/**
 * Starter for HandshakesApplication.
 */
public class Starter {
    public static void main(String[] args) {
        try {
            Handshake handshake = new Handshake(2691570, 579897, 2);
            handshake.find();
        } catch (Exception e){
             System.out.println(e.getMessage());
        }
    }
}
