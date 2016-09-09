import java.util.ArrayList;

/**
 * Created by bezgerts on 09.09.16.
 */
public class HandshakeThread extends Thread {
    private ArrayList<Integer> friends;
    private int targetUserId;
    private int searchDepth;

    public HandshakeThread(ArrayList<Integer> friends, int targetUserId, int searchDepth){
        this.friends = friends;
        this.targetUserId = targetUserId;
        this.searchDepth = searchDepth;
    }

    @Override
    public void run() {
        Handshake handshake = new Handshake(targetUserId, searchDepth);
        handshake.find(friends);
    }
}
