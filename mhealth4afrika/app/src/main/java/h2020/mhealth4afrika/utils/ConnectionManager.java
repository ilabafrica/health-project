package h2020.mhealth4afrika.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.util.List;


public class ConnectionManager {

	private Context ctx;

	private HttpClient httpClient;
	private HttpPost httpPost;


	public ConnectionManager(Context context) {
		ctx = context;
	}

	public ConnectionManager() {
	}

	// Check connectivity
	public boolean checkConnection() {
		ConnectivityManager connectivity = (ConnectivityManager) ctx
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity != null) {
			NetworkInfo info = connectivity.getActiveNetworkInfo();
			if (info != null && info.isConnectedOrConnecting()) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	// Make HTTP request
	public String httpRequest(String url, List<NameValuePair> pairs) {

		httpClient = new DefaultHttpClient();
		httpPost = new HttpPost(url);
		String responseString = null;

		try {

			httpPost.setEntity(new UrlEncodedFormEntity(pairs));
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			
			// EntityUtils grabs response as String
			responseString = EntityUtils.toString(httpEntity);
			// is = httpEntity.getContent();

		} catch (ClientProtocolException cpe) {
			Log.e("ERROR", "Client protocol problem.");
			cpe.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException uee) {
			Log.e("ERROR", "A surprising problem occured when encoding.");
			uee.printStackTrace();
			return null;
		}catch (HttpHostConnectException hce){
			hce.printStackTrace();
			return null;
		} catch (Exception ex) {
			Log.e("ERROR", "A surprising problem occured when making the HTTP Request.");
			ex.printStackTrace();
			return null;
		}
		
 
		Log.w("HTTP RESPONSE STRING==>",responseString);
		return responseString;
	}
	
}
