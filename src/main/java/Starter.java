import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            System.out.println(timeStamp);

            int userId = Integer.parseInt(args[0]);
            int targetUserId = Integer.parseInt(args[1]);
            int searchDepth = Integer.parseInt(args[2]);

            User user = new User(userId);
            User targetUser = new User(targetUserId);

            CopyOnWriteArrayList<ArrayList<String>> result = new CopyOnWriteArrayList<>();

            List<List<User>> choppedFriends = ProvidingService.chopped(user.getFriends(), 5);

            Thread[] handshakeThread = new Thread[choppedFriends.size()];

            for (int i = 0; i < choppedFriends.size(); i++) {
                handshakeThread[i] = new HandshakeThread(new ArrayList<>(choppedFriends.get(i)), user, targetUser, searchDepth, result, "Thread " + i);
                handshakeThread[i].start();
            }

            for (int i = 0; i < handshakeThread.length; i++) {
                try {
                    handshakeThread[i].join();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            System.out.println(timeStamp);
            System.out.println("Все потоки завершены");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

