/**
 *
 */
package h2020.mhealth4afrika.helpers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import h2020.mhealth4afrika.R;
import h2020.mhealth4afrika.activities.HelpActivity;
import h2020.mhealth4afrika.activities.LanguageSettings;
import h2020.mhealth4afrika.activities.MainActivity;
import h2020.mhealth4afrika.utils.SnackUtils;


/**
 * Helper class for common interface widgets for use throughout the app
 *
 * @author allay
 */
public class WidgetHelper {

    private Context context;
    private ProgressDialog dialog;

    public WidgetHelper(Context context) {
        this.context = context;
    }

    // Show progress dialog
    public void showProgressDialog(String message) {
        dialog = new ProgressDialog(context);
        dialog.setCancelable(false);
        dialog.setMessage(message);
        dialog.show();
    }

    // Dismiss progress dialog
    public void dismissProgessDialog() {
        dialog.dismiss();
    }

    // Validate editTexts' user input
    @SuppressLint("NewApi")
    public boolean isEditInputValid(EditText[] inputs, Activity act, View view) {
        for (EditText input : inputs) {
            // Clear any previous errors set
            input.setError(null);
            if (input.getText().toString().trim().isEmpty() || input.getText().toString().trim() == null) {
                input.setError(act.getResources().getString(R.string.field_is_required));
                input.requestFocus();
                // ToastUtils.toastAlert(act, act.getResources().getString(R.string.fill_all_required));
                SnackUtils.alert(view, act.getResources().getString(R.string.fill_all_required));
                return false;
            }
        }

        // default
        return true;

    }


    // Validate editTexts' user input
    @SuppressLint("NewApi")
    public boolean isEditInputValid(List<EditText> inputs, Activity act, View view) {
        for (EditText input : inputs) {
            // Clear any previous errors set
            input.setError(null);
            if (input.getText().toString().trim().isEmpty() || input.getText().toString().trim() == null) {
                input.setError(act.getResources().getString(R.string.field_is_required));
                input.requestFocus();
                SnackUtils.alert(view, act.getResources().getString(R.string.fill_all_required));
                return false;
            }
        }

        // default
        return true;
    }

    public boolean isSpinnerSelected(Spinner[] options, Activity act, View view) {

        String selectOneMessage = act.getResources().getString(R.string.select_one);

        for (Spinner option : options) {
            if (selectOneMessage.equals(option.getSelectedItem())) {
                option.requestFocusFromTouch();
                SnackUtils.alert(view, selectOneMessage);
                return false;
            }
        }

        return true;
    }

    public boolean isSpinnerSelected(List<Spinner> options, Activity act, View view) {

        String selectOneMessage = act.getResources().getString(R.string.select_one);

        for (Spinner option : options) {
            if (selectOneMessage.equals(option.getSelectedItem())) {
                option.requestFocusFromTouch();
                SnackUtils.alert(view, selectOneMessage);
                return false;
            }
        }

        return true;
    }

    // Set adapter to Spinner
    public void setAdapter(Spinner spinner, ArrayList<String> list) {

        // Array adapter with string array and default spinner view
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, list);
        // layout for list of choices
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // apply adapter to spinner
        spinner.setAdapter(typeAdapter);
    }

    // Get value for selected spinner
    public String getValue(String itemClicked, ArrayList<String> namesDisplayed, ArrayList<String> values) {

        int index;
        index = namesDisplayed.indexOf(itemClicked);
        return values.get(index - 1); // Minus adjustment for "Please select one " additional option

    }

    // Go to main with message to toast
    public void goToMainActivity(Context ctx, String message) {

        Intent intent = new Intent(ctx, MainActivity.class);
        intent.putExtra("message", message);
        intent.putExtra("success", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ctx.startActivity(intent);

    }

    // Go to settings activity
    public void goToSettingsActivity(Context ctx, Intent intent) {

        //For now go to Language
        intent = new Intent(ctx, LanguageSettings.class);
        ctx.startActivity(intent);

//        intent = new Intent(ctx, SettingsActivity.class);
//        ctx.startActivity(intent);
    }


    // Go to help activity
    public void goToHelpActivity(Context ctx, Intent intent) {
        intent = new Intent(ctx, HelpActivity.class);
        ctx.startActivity(intent);
    }


}
