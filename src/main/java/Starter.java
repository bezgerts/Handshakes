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
            if (friends.size() > 400) {
                ArrayList<Integer> tempFriends1 = new ArrayList<>();
                ArrayList<Integer> tempFriends2 = new ArrayList<>();
                ArrayList<Integer> tempFriends3 = new ArrayList<>();
                ArrayList<Integer> tempFriends4 = new ArrayList<>();

                for (int i = 0; i < 99; i++) {
                    tempFriends1.add(friends.get(i));
                    tempFriends2.add(friends.get(i+100));
                    tempFriends3.add(friends.get(i+200));
                    tempFriends4.add(friends.get(i+300));
                }

                HandshakeThread handshakeThread1 = new HandshakeThread(tempFriends1, targetUserId, searchDepth);
                HandshakeThread handshakeThread2 = new HandshakeThread(tempFriends2, targetUserId, searchDepth);
                HandshakeThread handshakeThread3 = new HandshakeThread(tempFriends3, targetUserId, searchDepth);
                HandshakeThread handshakeThread4 = new HandshakeThread(tempFriends4, targetUserId, searchDepth);
                handshakeThread1.start();
                handshakeThread2.start();
                handshakeThread3.start();
                handshakeThread4.start();
            }

            //Handshake handshake = new Handshake(targetUserId, targetUserId);

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            System.out.println(timeStamp);

           // handshake.find(targetUserId);
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            System.out.println(timeStamp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

