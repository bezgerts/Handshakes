import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Scanner;

/**
 * Starter fo SevenHandshakesApplication&
 */
public class Starter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userId = Integer.parseInt(scanner.nextLine());


         try {
             String response = Sender.getFriendsFromVkByUserId(userId);
             System.out.println(response);

             JSONObject obj = new JSONObject(response);
             JSONArray array = obj.getJSONArray("response");

             for (int i = 0; i < array.length(); i++){
                 System.out.println(array.getInt(i));

             }

             System.out.println("Friends count: " + array.length());


        } catch (Exception e){
             System.out.println(e.getMessage());
        }

    }

}
