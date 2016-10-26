import java.util.ArrayList;

/**
 * Class describes a user of vk.com
 *
 * @author a_bezgerts
 *
 */
public class User {
    private int id;
    private String name;
    private ArrayList<User> friends;

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public ArrayList<User> getFriends(){
        if (friends == null) {
            this.friends = ProvidingService.getFriendsFromVk(id);
        }
        return friends;
    }

    public String getName() {
        if (name == null) {
            this.name = ProvidingService.getUserName(this.id);
        }
        return name;
    }
}
