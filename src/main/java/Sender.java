import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * This class is developed to send requests to online resources.
 *
 * @author bezgerts
 * @
 *
 */
public class Sender {

    /**
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

}
