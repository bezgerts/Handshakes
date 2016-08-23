import java.util.ArrayList;

/**
 *
 * Class represents the handshake.
 * @author bezgerts
 *
 */
public class Handshake implements Runnable {
    private int userId;
    private int targetUserId;
    private int searchDepth;

    private ArrayList<Integer> friends;
    private int counter;
    private boolean checkResult;
    private ArrayList<String> resultString;

    private Handshake(){
        this.resultString = new ArrayList<>();
        this.resultString.add(0, "Handshake: " + ProvidingService.getUserName(this.userId) +
                " & " + ProvidingService.getUserName(targetUserId) + " || ");

        this.counter = 0;
        this.checkResult = false;
    }

    public Handshake(int userId, int targetUserId, int searchDepth) {
        this();
        this.userId = userId;
        this.targetUserId = targetUserId;
        this.searchDepth = searchDepth;
    }

    public Handshake(ArrayList<Integer> friends, int targetUserId, int searchDepth) {
        this();
        this.targetUserId = targetUserId;
        this.searchDepth = searchDepth;
        this.friends = friends;
    }

    public void findWithRecursion(int id){
        if (counter < 1) {
            System.out.println("Check user: " + ProvidingService.getUserName(id) + " with ID: " + id);
        }
        counter++;
        if (counter > searchDepth) {
            counter--;
            return;
        } else {
            friends = ProvidingService.getFriendsFromVk(id);
            checkResult = ProvidingService.checkId(targetUserId, friends);
            resultString.add(ProvidingService.getUserName(id) + " : ");
            if (checkResult) {
                System.out.println(ProvidingService.resultToString(resultString));
            }
            for (Integer friend :
                    friends) {
                findWithRecursion(friend);
            }
            resultString.remove(counter);
        }
        counter--;
    }

    void find() {
        if (userId != 0) {
            friends = ProvidingService.getFriendsFromVk(userId);
        }
        checkResult = ProvidingService.checkId(targetUserId, friends);
        if (checkResult) {
            System.out.println(ProvidingService.resultToString(resultString));
        }
        for (Integer friend :
                friends) {
            findWithRecursion(friend);
        }
        friends.clear();
    }

    @Override
    public void run() {
        this.find();
    }
}


