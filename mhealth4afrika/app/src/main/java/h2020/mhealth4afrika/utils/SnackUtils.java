package h2020.mhealth4afrika.utils;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;


public class SnackUtils {

    private static final int red = 0xfff44336;
    private static final int green = 0xff3A5F0B;
    private static final int blue = 0xff2195f3;
    private static final int orange = 0xffffc107;
    private static final int black = 0xff000000;
    private static final int white = 0xffffffff;

    private static Snackbar colorSnackBar(Snackbar snackbar, int colorId) {
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(colorId);
        TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(white);
        snackbar.show();
        return snackbar;
    }

    private static Snackbar makeSnackBar(View view, String message) {
        return Snackbar.make(view, message, Snackbar.LENGTH_LONG);
    }

    public static void info(View view, String message) {

        colorSnackBar(makeSnackBar(view, message), blue).show();
    }

    public static void warning(View view, String message) {
        colorSnackBar(makeSnackBar(view, message), orange).show();
    }

    public static void alert(View view, String message) {
        colorSnackBar(makeSnackBar(view, message), red).show();
    }

    public static void confirm(View view, String message) {
        colorSnackBar(makeSnackBar(view, message), green).show();
    }

}
