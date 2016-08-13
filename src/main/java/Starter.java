import vk.VkApi;

import java.io.IOException;

/**
 * Created by bezgerts on 12.08.16.
 */
public class Starter {
    public static void main(String[] args) {
     /*
        try {
        VkApi vkApi = VkApi.with("5585015", "Q5SUCeZNXF1JUdPkuOwP");
            vkApi.getUsers("2691570");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
         */
     try {
         String responseFromGoogle = Sender.sendGetRequest("https://api.vk.com/method/friends.get?user_id=2691570");
         System.out.println(responseFromGoogle);
     } catch (Exception e){
         System.out.println(e.getMessage());
     }

    }

}
