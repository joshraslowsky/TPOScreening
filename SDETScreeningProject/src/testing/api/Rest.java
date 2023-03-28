package testing.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;


public class Rest {
	
	

    /**
     * Sends a GET request
     *
     * @param url
     *            for the service you are testing
     * Output response int code
     * @throws Exception 
     */
    public static int sendGetRequest(String url)throws Exception{
    	URL obj = new URL(url);
    	//Setup URL Connection with Given URL
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		//Set Request to Get
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Test");
		int responseCode = con.getResponseCode();
		//Output Response Code
		System.out.println("GET Response Code :: " + responseCode);
		//If Response is 200 or HTTP Success then read response
		if (responseCode == 200) { 
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("GET Request was unsuccesful.");
		}
		return responseCode;
    }
    
  
    /**
     * Sends a Delete request
     *
     * @param url
     *            for the service you are testing
     * Output response int code
     * @throws Exception 
     */
    public static int sendDeleteRequest(String url)throws Exception{
    	URL obj = new URL(url);
    	//Setup URL Connection with Given URL
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		//Set Request to Get
		con.setRequestMethod("DELETE");
		con.setRequestProperty("User-Agent", "Test");
		int responseCode = con.getResponseCode();
		//Output Response Code
		System.out.println("GET Response Code :: " + responseCode);
		//If Response is 200 or HTTP Success then read response
		if (responseCode == 200) { 
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("Delete Request was unsuccesful");
		}
		return responseCode;
    }
    
    
    /**
     * Sends a POST request
     *
     * @param url, payload
     *            
     * Output response int code
     * @throws Exception 
     */
    public static int sendPostRequest(String url, JSONObject payload) throws Exception {

		 //Create JSON Entity
		 StringEntity entity = new StringEntity(payload.toString(),
				 ContentType.APPLICATION_JSON);
		 
		 HttpClient httpClient = HttpClientBuilder.create().build();
	     HttpPost request = new HttpPost(url);
	     request.setEntity(entity);
	     request.addHeader("content-type", "application/json");

	     HttpResponse response = httpClient.execute(request);
	     return response.getStatusLine().getStatusCode();

	}
    
    
    /**
     * Sends a PUT request
     *
     * @param url, payload
     *            
     * Output response int code
     * @throws Exception 
     */
    public static int sendPutRequest(String url, JSONObject payload) throws Exception {

		 //Create JSON Entity
		 StringEntity entity = new StringEntity(payload.toString(),
				 ContentType.APPLICATION_JSON);
		 
		 HttpClient httpClient = HttpClientBuilder.create().build();
	     HttpPut request = new HttpPut(url);
	     request.setEntity(entity);
	     request.addHeader("content-type", "application/json");

	     HttpResponse response = httpClient.execute(request);
	     return response.getStatusLine().getStatusCode();
	}
    
    /**
     * Maps Hashmap to a JSONObject
     * @param jsonValues
     * @return JSONObject
     */
    public static JSONObject buildJsonObject(HashMap<String, String> jsonValues){
		JSONObject object = new JSONObject();
    	jsonValues.forEach((key, value) -> {
    			object.put(key, value);
    	    });
    	return object;
    }

}
