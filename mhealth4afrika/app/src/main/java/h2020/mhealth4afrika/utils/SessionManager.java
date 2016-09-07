package h2020.mhealth4afrika.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import h2020.mhealth4afrika.models.User;


public class SessionManager {

    // Shared pref mode
    final static int PRIVATE_MODE = 0;
    // SharedPref file name
    private static final String APP_USER_AUTH = "AppUserAuth";
    private static final String REFERENCE_DATA_CACHE_STATUS = "ReferenceDataCacheStatus";
    private static final String DATA_CACHE_STATUS = "DataCacheStatus";
    private static final String LANGUAGE = "Language";
    private static final String SAVE_ON_DEVICE = "SaveOnDevice";
    private static SharedPreferences initSyncPref, credentialsPref, dataCachePref, languagePref,
            persistDataPref;
    private static Editor editor;
    private static String initLogin = "initLogin";
    private static String startStatus = "startStatus";
    private static String pauseStatus = "pauseStatus";
    private static String setupStatus = "setupStatus";
    private static String language_preference = "language_preference";
    private static String persistStatus = "persistStatus";
    private static String navMenuItemsStatus = "menuItemsStatus";

    // Initialize our preferences
    public static void initAPPSharedPref(Context ctx) {

        initSyncPref = ctx.getSharedPreferences(REFERENCE_DATA_CACHE_STATUS, PRIVATE_MODE);
        credentialsPref = ctx.getSharedPreferences(APP_USER_AUTH, PRIVATE_MODE);
        dataCachePref = ctx.getSharedPreferences(DATA_CACHE_STATUS, PRIVATE_MODE);

        languagePref = ctx.getSharedPreferences(LANGUAGE, PRIVATE_MODE);
        persistDataPref = ctx.getSharedPreferences(SAVE_ON_DEVICE, PRIVATE_MODE);

    }


    // Set this is first time login
    public static void setFirstTimeAppLogin(Context ctx) {

        dataCachePref = ctx.getSharedPreferences(DATA_CACHE_STATUS, PRIVATE_MODE);
        editor = dataCachePref.edit();
        editor.putBoolean(initLogin, true);
        editor.commit();
    }

    // Check if first time login
    public static boolean isFirstTimeAppLogin(Context ctx) {
        dataCachePref = ctx.getSharedPreferences(DATA_CACHE_STATUS, PRIVATE_MODE);
        return dataCachePref.getBoolean(initLogin, false);
    }

    // Set first time login false
    public static void setAlreadyFirstTimeAppLogin(Context ctx) {

        dataCachePref = ctx.getSharedPreferences(DATA_CACHE_STATUS, PRIVATE_MODE);
        editor = dataCachePref.edit();
        editor.putBoolean(initLogin, false);
        editor.commit();
    }

    // Set nav menu items fetch complete
    public static void setFetchNavMenuItemsComplete(Context ctx) {

        dataCachePref = ctx.getSharedPreferences(DATA_CACHE_STATUS, PRIVATE_MODE);
        editor = dataCachePref.edit();
        editor.putBoolean(navMenuItemsStatus, true);
        editor.commit();
    }

    // Check status of nav menu items
    public static boolean isFetchNavMenuItemsComplete(Context ctx) {

        dataCachePref = ctx.getSharedPreferences(DATA_CACHE_STATUS, PRIVATE_MODE);
        return dataCachePref.getBoolean(navMenuItemsStatus, false);
    }


    // Set set-up already run startStatus
    public static void setSetUpRun(Context ctx) {

        dataCachePref = ctx.getSharedPreferences(DATA_CACHE_STATUS, PRIVATE_MODE);

        editor = dataCachePref.edit();
        editor.putBoolean(setupStatus, true);
        editor.commit();
    }

    public static boolean isSetupRun(Context ctx) {
        dataCachePref = ctx.getSharedPreferences(DATA_CACHE_STATUS, PRIVATE_MODE);
        return dataCachePref.getBoolean(setupStatus, false);
    }

    // Set reference data synced
    public static void setRefDataSynced(Context ctx) {

        initSyncPref = ctx.getSharedPreferences(REFERENCE_DATA_CACHE_STATUS, PRIVATE_MODE);

        editor = initSyncPref.edit();
        editor.putBoolean(startStatus, true);
        editor.commit();
    }

    // Set reference data to NOT SYNCED
    public static void setRefDataNotSynced(Context ctx) {

        initSyncPref = ctx.getSharedPreferences(REFERENCE_DATA_CACHE_STATUS, PRIVATE_MODE);

        editor = initSyncPref.edit();
        editor.putBoolean(startStatus, false);
        editor.commit();
    }

    // If reference data from data dictionary has been synced
    public static boolean isRefDataSynced(Context ctx) {

        initSyncPref = ctx.getSharedPreferences(REFERENCE_DATA_CACHE_STATUS, PRIVATE_MODE);

        return initSyncPref.getBoolean(startStatus, false);
    }

    // Set data persisted on device startStatus
    public static void setDataSaved(Context ctx) {

        persistDataPref = ctx.getSharedPreferences(SAVE_ON_DEVICE, PRIVATE_MODE);

        editor = persistDataPref.edit();
        editor.putBoolean(persistStatus, true);
        editor.commit();
    }

    // Check if data is persisted on device
    public static boolean isDataSaved(Context ctx) {

        persistDataPref = ctx.getSharedPreferences(SAVE_ON_DEVICE, PRIVATE_MODE);

        return persistDataPref.getBoolean(persistStatus, false);
    }

    // Clear data persisted status
    public static void clearDataSaved(Context ctx) {

        persistDataPref = ctx.getSharedPreferences(SAVE_ON_DEVICE, PRIVATE_MODE);

        editor = persistDataPref.edit();
        editor.clear();
        editor.commit();
    }

    // Set user logged in auth
    public static void setUserAuthenticated(Context ctx) {

        credentialsPref = ctx.getSharedPreferences(APP_USER_AUTH, PRIVATE_MODE);

        editor = credentialsPref.edit();
        editor.putBoolean(startStatus, true);
        editor.commit();
    }

    // Set user logged out
    public static void setUserLoggedOut(Context ctx) {

        credentialsPref = ctx.getSharedPreferences(APP_USER_AUTH, PRIVATE_MODE);

        editor = credentialsPref.edit();
        editor.putBoolean(startStatus, false);
        editor.commit();
    }

    // Check if user is authenticated
    public static boolean isUserAuthenticated(Context ctx) {

        credentialsPref = ctx.getSharedPreferences(APP_USER_AUTH, PRIVATE_MODE);

        return credentialsPref.getBoolean(startStatus, false);
    }

    public static void setSessionUserDetails(User user, Context ctx) {

        credentialsPref = ctx.getSharedPreferences(APP_USER_AUTH, PRIVATE_MODE);

        editor = credentialsPref.edit();
        editor.putInt("userId", user.getUserId());
        editor.putString("emailAddress", user.getEmailAddress());
        editor.putString("firstName", user.getFirstName());
        editor.putString("lastName", user.getLastName());
        editor.putInt("organisationId", user.getOrganizationId());
        editor.putInt("role", user.getRole());
        editor.commit();
    }

    // Get session user
    public static User getSessionUser(Context ctx) {

        credentialsPref = ctx.getSharedPreferences(APP_USER_AUTH, PRIVATE_MODE);

        User user = new User();
        user.setUserId(credentialsPref.getInt("userId", -1));
        user.setEmailAddress(credentialsPref.getString("emailAddress", null));
        user.setFirstName(credentialsPref.getString("firstName", null));
        user.setLastName(credentialsPref.getString("lastName", null));
        user.setOrganizationId(credentialsPref.getInt("organisationId", -1));
        user.setRole(credentialsPref.getInt("role", -1));

        return user;
    }

    // Clear session user
    public static void clearSessionUser(Context ctx) {

        credentialsPref = ctx.getSharedPreferences(APP_USER_AUTH, PRIVATE_MODE);

        editor = credentialsPref.edit();
        editor.clear();
        editor.commit();
    }

    // get language
    public static String getLanguage(Context ctx) {

        languagePref = ctx.getSharedPreferences(LANGUAGE, PRIVATE_MODE);

        return languagePref.getString(language_preference, "en");
    }

    // save language
    public static void saveLocale(String lang, Context ctx) {

        languagePref = ctx.getSharedPreferences(LANGUAGE, PRIVATE_MODE);

        editor = languagePref.edit();
        editor.putString(language_preference, lang);
        editor.commit();
    }

}
