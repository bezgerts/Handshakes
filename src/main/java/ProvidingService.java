import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * This class is developed to consolidate all providing services.
 * @author bezgerts
 *
 */
public class ProvidingService {

    /**
     *
     * This method sends get request.
     *
     * @param requestUrl - Get request will be send to this address.
     * @return String with response from the server.
     *
     */
    public static String sendGetRequest(String requestUrl) throws Exception {

        URL obj = new URL(requestUrl);

        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
        httpURLConnection.setRequestMethod("GET");

        // int responseCode = httpURLConnection.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(httpURLConnection.getInputStream()));

        String currentLine;
        StringBuffer responseBuffer = new StringBuffer();
        while ((currentLine = in.readLine()) != null){
            responseBuffer.append(currentLine);
        }
        in.close();

        String response = responseBuffer.toString();
        return response;
    }

    static final String URL_PATH_VK_GET_FRIENDS = "https://api.vk.com/method/friends.get?user_id=";
    /**
     *
     * This method gets friends of user from https://www.vk.com.
     *
     * @param userId - userId from https://www.vk.com. For example: 2691570
     * @return ArrayList<Integer> with IDs of friends;
     *
     */
    public static ArrayList<Integer> getFriendsFromVk(int userId) {
        ArrayList<Integer> userFriendsList = new ArrayList<>();
        try {
            String response = sendGetRequest(URL_PATH_VK_GET_FRIENDS + userId);

            JSONObject obj = new JSONObject(response);
            if (obj.has("response")) {
                JSONArray array = obj.getJSONArray("response");
                if (array != null) {
                    int len = array.length();
                    for (int i=0;i<len;i++){
                        userFriendsList.add(Integer.parseInt(array.get(i).toString()));
                    }
                }
            }

        }
        catch (Exception e){
            System.out.println("Exception. UserID: " + userId + ". Message: " + e.getMessage());
        }

        return userFriendsList;
    }

    /**
     * This method checks of exist ID in ArrayList.
     *
     * @param id - user id,
     * @param friendList
     *
     */
    public static boolean checkId(int id, ArrayList<Integer> friendList){
        boolean result = false;
        for (Integer f :
                friendList) {
            if (f == id) {
                result = true;
            }
        }
        return result;
    }
}


