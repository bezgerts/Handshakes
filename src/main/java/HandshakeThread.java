import java.util.ArrayList;

/**
 * Created by bezgerts on 09.09.16.
 */
public class HandshakeThread extends Thread {
    private ArrayList<Integer> friends;
    private int userId;
    private int targetUserId;
    private int searchDepth;
    private String threadName;

    public HandshakeThread(ArrayList<Integer> friends, int userId, int targetUserId, int searchDepth, String threadName){
        this.friends = friends;
        this.userId = userId;
        this.targetUserId = targetUserId;
        this.searchDepth = searchDepth;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        Handshake handshake = new Handshake(userId, targetUserId, searchDepth, threadName);
        handshake.find(friends);
    }
}
