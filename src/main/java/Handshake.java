import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * Class represents the handshake.
 * @author bezgerts
 *
 */
public class Handshake {
    private User user;
    private User targetUser;
    private int searchDepth;
    private CopyOnWriteArrayList<ArrayList<String>> result;
    private ArrayList<User> friends;
    private ArrayList<String> chainOfFriends;
    private int counter;
    private boolean checkResult;


    public Handshake(User user, User targetUser, int searchDepth,
                     CopyOnWriteArrayList<ArrayList<String>> result,
                     String threadName) {
        this.targetUser = targetUser;
        this.searchDepth = searchDepth;
        this.user = user;
        this.result = result;
        this.chainOfFriends = new ArrayList<>();
        this.chainOfFriends.add(threadName);
    }

    public void findWithRecursion(User user){
        counter++;
        if (counter > searchDepth) {
            counter--;
            return;
        } else {
            friends = ProvidingService.getFriendsFromVk(user.getId());
            checkResult = ProvidingService.checkId(targetUser.getId(), friends);
            chainOfFriends.add(ProvidingService.getUserName(user.getId()));
            if (checkResult) {
                result.add(new ArrayList<String>(chainOfFriends));
                System.out.println(chainOfFriends);
            }
            for (User friend :
                    friends) {
                findWithRecursion(friend);
            }
            chainOfFriends.remove(counter);
        }
        counter--;
    }

    void find(ArrayList<User> friends) {
        this.friends = friends;
        checkResult = ProvidingService.checkId(targetUser.getId(), friends);
        if (checkResult) {
            result.add(new ArrayList<String>(chainOfFriends));
        }
        for (User friend :
                friends) {
            findWithRecursion(friend);
        }
        friends.clear();
    }
}


