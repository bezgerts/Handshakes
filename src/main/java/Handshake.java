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

    public Handshake(int userId, int targetUserId) {
        this.userId = userId;
        this.targetUserId = targetUserId;
    }

    /**
     * @param searchDepth - search depth limit
     */
    public void find(int searchDepth) {
        find(userId, searchDepth);
    }

    void find(int userId, int searchDepth) {

        ArrayList<ArrayList<Integer>> friends = new ArrayList<>();

        friends.add(0, ProvidingService.getFriendsFromVk(userId));

        boolean checkResult;

        checkResult = ProvidingService.checkId(targetUserId, friends.get(0));
        if (checkResult) {
            System.out.println("Handshake: " + ProvidingService.getUserName(userId) +
                                                        ": " + ProvidingService.getUserName(targetUserId));
        }

        if (searchDepth > 1) {
            for (int i = 81; i < friends.get(0).size(); i++) {
                friends.add(1, ProvidingService.getFriendsFromVk(friends.get(0).get(i)));
                checkResult = ProvidingService.checkId(targetUserId, friends.get(1));
                if (checkResult){
                    System.out.println("Handshake: " + ProvidingService.getUserName(userId) + ": "
                            + ProvidingService.getUserName(friends.get(0).get(i))  + ": "
                            + ProvidingService.getUserName(targetUserId));
                }
                if (searchDepth > 2){
                    for (int j = 0; j < friends.get(1).size(); j++) {
                        friends.add(2, ProvidingService.getFriendsFromVk(friends.get(1).get(j)));
                        checkResult = ProvidingService.checkId(targetUserId, friends.get(2));
                        if (checkResult) {
                            System.out.println("Handshake: " + ProvidingService.getUserName(userId)  + ": "
                                    + ProvidingService.getUserName(friends.get(0).get(i)) + ": "
                                    + ProvidingService.getUserName(friends.get(1).get(j)) + ": "
                                    + ProvidingService.getUserName(targetUserId));
                        }
                        if(searchDepth > 3){
                            for (int k = 0; k < friends.get(2).size(); k++) {
                                friends.add(3, ProvidingService.getFriendsFromVk(friends.get(2).get(k)));
                                checkResult = ProvidingService.checkId(targetUserId, friends.get(3));
                                if (checkResult) {
                                    System.out.println("Handshake: " + ProvidingService.getUserName(userId)  + ": "
                                            + ProvidingService.getUserName(friends.get(0).get(i)) + ": "
                                            + ProvidingService.getUserName(friends.get(1).get(j)) + ": "
                                            + ProvidingService.getUserName(friends.get(2).get(k)) + ": "
                                            + ProvidingService.getUserName(targetUserId));
                                }

                                if (searchDepth > 4) {
                                    for (int l = 0; l < friends.get(3).size(); l++) {
                                        friends.add(4, ProvidingService.getFriendsFromVk(friends.get(3).get(l)));
                                        checkResult = ProvidingService.checkId(targetUserId, friends.get(4));
                                        if (checkResult) {
                                            System.out.println("Handshake: "
                                                    + ProvidingService.getUserName(userId)  + ": "
                                                    + ProvidingService.getUserName(friends.get(0).get(i)) + ": "
                                                    + ProvidingService.getUserName(friends.get(1).get(j)) + ": "
                                                    + ProvidingService.getUserName(friends.get(2).get(k)) + ": "
                                                    + ProvidingService.getUserName(friends.get(3).get(l)) + ": "
                                                    + ProvidingService.getUserName(targetUserId));
                                        }
                                        if (searchDepth > 5) {
                                            for (int m = 0; m < friends.get(4).size(); m++) {
                                                friends.add(5, ProvidingService.getFriendsFromVk(friends.get(4).get(m)));
                                                checkResult = ProvidingService.checkId(targetUserId, friends.get(5));
                                                if (checkResult) {
                                                    System.out.println("Handshake: "
                                                            + ProvidingService.getUserName(userId)  + ": "
                                                            + ProvidingService.getUserName(friends.get(0).get(i)) + ": "
                                                            + ProvidingService.getUserName(friends.get(1).get(j)) + ": "
                                                            + ProvidingService.getUserName(friends.get(2).get(k)) + ": "
                                                            + ProvidingService.getUserName(friends.get(3).get(l)) + ": "
                                                            + ProvidingService.getUserName(friends.get(4).get(l)) + ": "
                                                            + ProvidingService.getUserName(targetUserId));
                                                }
                                                friends.remove(5);
                                            }
                                        }
                                        friends.remove(4);
                                    }
                                }
                                friends.remove(3);
                            }
                        }
                        friends.remove(2);
                    }
                }
                friends.remove(1);
            }
        }
    }
}


