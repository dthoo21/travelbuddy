package weather;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherServlet {

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast?";
    private static final String APP_ID = "9db0e2fddcc9f01d3e575642dc6ab560";
    private static final String CITY_LIST_RESOURCE = "city.list.json";

    private String getWeatherJson(String weatherUrl) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL(weatherUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    private String urlBuilder(int cityId) {
        return BASE_URL +
                "appid=" +
                APP_ID +
                "&" +
                "id=" +
                cityId;
    }

    private int getCityCode(String city) throws IOException {
        InputStream is = ClassLoader.getSystemResourceAsStream(CITY_LIST_RESOURCE);
        StringWriter writer = new StringWriter();
        IOUtils.copy(is, writer, "UTF-8");

        String strCityList = writer.toString();
        JSONArray cityListJsonArray = new JSONArray(strCityList);
        int cityId = 0;

        for (int i = 0; i < cityListJsonArray.length(); i++) {
            JSONObject cityJsonObject = cityListJsonArray.getJSONObject(i);
            String cityName = cityJsonObject.getString("name");

            if (city.equalsIgnoreCase(cityName)) {
                return cityJsonObject.getInt("id");
            }
        }

        return cityId;
    }

    public static void main(String[] args) throws Exception {
        WeatherServlet ws = new WeatherServlet();

        int cityId = ws.getCityCode("Toronto");
        String torontoUrl = ws.urlBuilder(cityId);
        System.out.println(ws.getWeatherJson(torontoUrl));
    }
}