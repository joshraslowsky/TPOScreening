package testing.api;

import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
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
    /**
     * Sends a POST request
     *
     * @param url, payload
     *            
     * Output response int code
     * @throws Exception 
     */
    public static int sendGetRequest(String url) throws Exception {

		 HttpClient httpClient = HttpClientBuilder.create().build();
	     HttpGet request = new HttpGet(url);

	     HttpResponse response = httpClient.execute(request);
	     return response.getStatusLine().getStatusCode();

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
		 HttpClient httpClient = HttpClientBuilder.create().build();
	     HttpDelete request = new HttpDelete(url);

	     HttpResponse response = httpClient.execute(request);
	     return response.getStatusLine().getStatusCode();
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
