import java.util.ArrayList;

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

    private String threadName;

    private ArrayList<User> friends;
    private int counter;
    private boolean checkResult;
    private ArrayList<String> resultString;


    public Handshake(User user, User targetUser, int searchDepth, String threadName) {
        this.targetUser = targetUser;
        this.searchDepth = searchDepth;
        this.user = user;
        this.threadName = threadName;
        this.resultString = new ArrayList<>();
        this.resultString.add(0, threadName + " Handshake: " + user.getName() +
                " & " + targetUser.getName() + "  || ");
    }

    public void findWithRecursion(int id){
        /**
         * if (counter < 1) {
         System.out.println(threadName + ": Check user: " + ProvidingService.getUserName(id) + " with ID: " + id);
         }
         */

        counter++;
        if (counter > searchDepth) {
            counter--;
            return;
        } else {
            friends = ProvidingService.getFriendsFromVk(id);
            checkResult = ProvidingService.checkId(targetUser.getId(), friends);
            resultString.add(ProvidingService.getUserName(id) + " : ");
            if (checkResult) {
                System.out.println(ProvidingService.resultToString(resultString));
            }
            for (User friend :
                    friends) {
                findWithRecursion(friend.getId());
            }
            resultString.remove(counter);
        }
        counter--;
    }

    void find(ArrayList<User> friends) {
        this.friends = friends;
        checkResult = ProvidingService.checkId(targetUser.getId(), friends);
        if (checkResult) {
            System.out.println(ProvidingService.resultToString(resultString));
        }
        for (User friend :
                friends) {
            findWithRecursion(friend.getId());
        }
        friends.clear();
    }

    void find(){
      this.find(user.getFriends());
    }
}


