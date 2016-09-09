import java.util.ArrayList;

/**
 *
 * Class represents the handshake.
 * @author bezgerts
 *
 */
public class Handshake {
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

    public Handshake(int targetUserId, int searchDepth) {
        this();
        this.targetUserId = targetUserId;
        this.searchDepth = searchDepth;
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

    void find(int userId) {
        this.userId = userId;
        this.find(ProvidingService.getFriendsFromVk(userId));
    }

    void find(ArrayList<Integer> friends) {
        this.friends = friends;
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
}


