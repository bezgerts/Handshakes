import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

            User user = new User(userId);
            User targetUser = new User(targetUserId);

            List<List<User>> choppedFriends = ProvidingService.chopped(user.getFriends(), 5);
            for (int i = 0; i < choppedFriends.size(); i++) {
                new HandshakeThread(new ArrayList<>(choppedFriends.get(i)), user, targetUser, searchDepth, "Thread " + i).start();
            }

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            System.out.println(timeStamp);

            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            System.out.println(timeStamp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

