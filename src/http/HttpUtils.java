package http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//从网站获取并返回信息
public class HttpUtils {
    public static String getHtml(String url) {
        StringBuffer result = new StringBuffer();
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(3000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                    result.append("\n");
                }
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result.toString());
        return result.toString();
    }
}
