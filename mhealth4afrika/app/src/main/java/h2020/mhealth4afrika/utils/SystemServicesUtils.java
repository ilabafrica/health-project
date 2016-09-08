/**
 *
 */
package h2020.mhealth4afrika.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.GooglePlayServicesUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Common system services/functionality
 *
 * @author allay
 */
public class SystemServicesUtils {

    // Check for Google Play Services

    // Check for internet connectivity
    public static boolean isConnected(Context ctx) {

        ConnectivityManager connectivity = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnectedOrConnecting()) {
                return true;
            } else
                return false;
        } else {
            return false;
        }
    }

    // Get current system date time
    @SuppressLint("SimpleDateFormat")
    public static String getDateTime() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    // Check for Google Play Services
    public static boolean isGooglePlayServicesAvailable(Context ctx) {

//        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(ctx);
//        if (ConnectionResult.SUCCESS == status) {
//            return true;
//        } else {
//            return false;
//        }
        return false;
    }

    // Check whether location providers (GPS or Network) are enabled
    public static boolean isLocationProviderEnabled(Context ctx) {
        LocationManager manager = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);
        boolean gpsEnabled = false, networkEnabled = false;

        //
        try {
            gpsEnabled = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Should we check for this?
        try {
            networkEnabled = manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (!gpsEnabled && !networkEnabled) {
            return false;
        } else {
            return true;
        }

    }


}
