import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by bezgerts on 09.09.16.
 */
public class HandshakeThread extends Thread {
    private ArrayList<User> friends;
    private User user;
    private User targetUser;
    private int searchDepth;
    private CopyOnWriteArrayList<ArrayList<String>> result;
    private String threadName;
    public HandshakeThread(ArrayList<User> friends, User user,
                           User targetUser, int searchDepth,
                           CopyOnWriteArrayList<ArrayList<String>> result,
                           String threadName){
        this.friends = friends;
        this.user = user;
        this.targetUser = targetUser;
        this.searchDepth = searchDepth;
        this.result = result;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        Handshake handshake = new Handshake(user, targetUser, searchDepth, result, threadName);
        handshake.find(friends);
    }
}
