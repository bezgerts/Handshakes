import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
            int userId = Integer.parseInt(args[0]);
            int targetUserId = Integer.parseInt(args[1]);
            int searchDepth = Integer.parseInt(args[2]);

            ArrayList<Integer> friends = ProvidingService.getFriendsFromVk(userId);


                HandshakeThread handshakeThread1 = new HandshakeThread(new ArrayList<>(friends.subList(0,199)), userId, targetUserId, searchDepth, "Thread 1");
                HandshakeThread handshakeThread2 = new HandshakeThread(new ArrayList<>(friends.subList(200,399)), userId, targetUserId, searchDepth, "Thread 2");
                HandshakeThread handshakeThread3 = new HandshakeThread(new ArrayList<>(friends.subList(400,599)), userId, targetUserId, searchDepth, "Thread 3");
                HandshakeThread handshakeThread4 = new HandshakeThread(new ArrayList<>(friends.subList(600,700)), userId, targetUserId, searchDepth, "Thread 4");
                handshakeThread1.start();
                handshakeThread2.start();
                handshakeThread3.start();
                handshakeThread4.start();


            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            System.out.println(timeStamp);

            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            System.out.println(timeStamp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

