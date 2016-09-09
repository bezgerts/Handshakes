import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Starter for HandshakesApplication.
 */
public class Starter {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Sample usage of the program:" +
                    "java -jar handshake.jar 2691570 273251945 3");
            System.exit(0);
        }

        try {
            String userId = args[0];
            String targetUserId = args[1];
            String searchDepth = args[2];

            Handshake handshake = new Handshake(Integer.parseInt(targetUserId), Integer.parseInt(searchDepth));

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            System.out.println(timeStamp);

            handshake.find(Integer.parseInt(userId));
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            System.out.println(timeStamp);
        } catch (Exception e){
             System.out.println(e.getMessage());
        }
    }
}
