/**
 * 
 */
package h2020.mhealth4afrika.tasks;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import h2020.mhealth4afrika.R;
import h2020.mhealth4afrika.helpers.HttpRequestManager;
import h2020.mhealth4afrika.helpers.WidgetHelper;
import h2020.mhealth4afrika.interfaces.OnSubmitTaskComplete;
import h2020.mhealth4afrika.utils.SystemServicesUtils;

/**
 * 
 * Background HTTP Post request
 * 
 * @author allay
 * 
 *
 */
public class SubmitTask extends AsyncTask<Void, Void, String> {

	private Activity act;
	private WidgetHelper widgets;
	private String jsonString, url, processResult = "fail";
	private boolean isConnected;
	private HttpRequestManager requestManager;
	private List<NameValuePair> nameValuePair;
	private OnSubmitTaskComplete listener;

	public SubmitTask (OnSubmitTaskComplete listener, Activity act, String jsonString, String url, WidgetHelper widgets) {
		this.act = act;
		this.jsonString = jsonString;
		this.url = url;
		this.widgets = widgets;
		this.listener = listener;

	}

	protected void onPreExecute() {
		super.onPreExecute();
		widgets.showProgressDialog(act.getResources().getString(R.string.processing));
	}

	@Override
	protected String doInBackground(Void... params) {
		// Check for connectivity
		isConnected = SystemServicesUtils.isConnected(act);

		if (isConnected) {
			
			requestManager = new HttpRequestManager();
			nameValuePair = new ArrayList<>(1);
			nameValuePair.add(new BasicNameValuePair("data", jsonString));
			// Request
			processResult = requestManager.post(url, nameValuePair);
			
			// debug
			Log.d("URL ", url);
			Log.d("JSON ", jsonString);
			Log.d("RESULT ", processResult);
		}
		
		return "complete";
	}
	
	@Override
	protected void onPostExecute(String result) {
		
		widgets.dismissProgessDialog();
		
		if (result.equals("complete")) {
			// Let the calling activity handle processing of request results
			listener.onSubmitTaskComplete(isConnected, processResult);
		}
		
	}

}
