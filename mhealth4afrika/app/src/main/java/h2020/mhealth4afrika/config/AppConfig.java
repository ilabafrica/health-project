package h2020.mhealth4afrika.config;

public class AppConfig {

    // URLS

    private static String POST_URL = "http://127.0.0.1/mhealth4Afrika/api/";
    private static String APP_URL = "http://127.0.0.1/mhealth4Afrika/";

    private static String SCRIPTS_URL = "http://127.0.0.1/mhealth4Afrika/uploadscripts/";
    private static String SERVER_URL = "http://127.0.0.1/";
    // SQLite DB
    private static String APP_DB_NAME = "mhealth4Afrika.sqlite";
    private static String tablesFile = "dbtables.txt";

    /**
     * @return the aPP_URL
     */
    public static String getAPP_URL() {
        return APP_URL;
    }

    /**
     * @param aPP_URL the aPP_URL to set
     */
    public static void setAPP_URL(String aPP_URL) {
        APP_URL = aPP_URL;
    }

    public static String getFile() {
        return tablesFile;
    }

    public static void setFile(String file) {
        AppConfig.tablesFile = file;
    }

    /**
     * @return the pOST_URL
     */
    public static String getPOST_URL() {
        return POST_URL;
    }

    public static void setPOST_URL(String pOST_URL) {
        POST_URL = pOST_URL;
    }

    // Getters for static to handle for any changes after compilation of the
    // class

    /**
     * @return the sERVER_URL
     */
    public static String getSERVER_URL() {
        return SERVER_URL;
    }

    public static void setSERVER_URL(String sERVER_URL) {
        SERVER_URL = sERVER_URL;
    }

    /**
     * @return the aPP_DB_NAME
     */
    public static String getAPP_DB_NAME() {
        return APP_DB_NAME;
    }

    /**
     * @param aPP_DB_NAME the aPP_DB_NAME to set
     */
    public static void setAPP_DB_NAME(String aPP_DB_NAME) {
        APP_DB_NAME = aPP_DB_NAME;
    }

    /**
     * @return the sCRIPTS_URL
     */
    public static String getSCRIPTS_URL() {
        return SCRIPTS_URL;
    }

    /**
     * @param sCRIPTS_URL the sCRIPTS_URL to set
     */
    public static void setSCRIPTS_URL(String sCRIPTS_URL) {
        SCRIPTS_URL = sCRIPTS_URL;
    }

}