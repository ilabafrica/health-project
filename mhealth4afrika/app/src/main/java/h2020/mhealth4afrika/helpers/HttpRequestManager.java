/**
 *
 */
package h2020.mhealth4afrika.helpers;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to handle http requests
 */
public class HttpRequestManager {

    private HttpClient httpClient;
    private HttpPost httpPost;
    private HttpResponse response;

    public HttpRequestManager() {

    }


    // Post name value pairs
    public String post(String url, List<NameValuePair> nameValuePair) {

        String serverResponse = "";

        httpClient = new DefaultHttpClient();
        httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair, HTTP.UTF_8));
        } catch (UnsupportedEncodingException uex) {
            uex.printStackTrace();
        }

        try {

            response = httpClient.execute(httpPost);

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }

            serverResponse = sb.toString();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return serverResponse;
    }


    // Post JSON string
    public String post(String url, String json) {

        String serverResponse = "";

        httpClient = new DefaultHttpClient();
        httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new StringEntity(json, HTTP.UTF_8));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }

        try {

            response = httpClient.execute(httpPost);

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }

            serverResponse = sb.toString();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return serverResponse;
    }


    // get NameValuePairs from Object
    public ArrayList<NameValuePair> getObjectNameValuePairs(Object obj) throws IllegalArgumentException, IllegalAccessException {

        ArrayList<NameValuePair> list = new ArrayList<NameValuePair>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true); // if you want to modify private fields
            BasicNameValuePair nameValuePair = new BasicNameValuePair(field.getName(), (String) field.get(obj).toString()); //toString() covers serialization long variables
            list.add(nameValuePair);
        }
        return list;
    }

}
