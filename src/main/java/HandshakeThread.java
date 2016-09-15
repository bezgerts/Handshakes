import java.util.ArrayList;

/**
 * Created by bezgerts on 09.09.16.
 */
public class HandshakeThread extends Thread {
    private ArrayList<User> friends;
    private User user;
    private User targetUser;
    private int searchDepth;
    private String threadName;

    public HandshakeThread(ArrayList<User> friends, User user, User targetUser, int searchDepth, String threadName){
        this.friends = friends;
        this.user = user;
        this.targetUser = targetUser;
        this.searchDepth = searchDepth;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        Handshake handshake = new Handshake(user, targetUser, searchDepth, threadName);
        handshake.find(friends);
    }
}
