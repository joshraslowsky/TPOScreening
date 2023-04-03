package testing.api;

import java.util.HashMap;

import org.apache.hc.client5.http.HttpResponseException;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;
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

    	 CloseableHttpClient  httpClient = HttpClientBuilder.create().build();
	     HttpGet request = new HttpGet(url);
	     ClassicHttpResponse response;

	     response= httpClient.execute(request, new CustomHttpClientResponseHandler());
	     return response.getCode();

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

	     ClassicHttpResponse response;

	     response= httpClient.execute(request, new CustomHttpClientResponseHandler());
	     return response.getCode();

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

	     ClassicHttpResponse response;

	     response= httpClient.execute(request, new CustomHttpClientResponseHandler());
	     return response.getCode();


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

	     ClassicHttpResponse response;

	     response= httpClient.execute(request, new CustomHttpClientResponseHandler());
	     return response.getCode();

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
