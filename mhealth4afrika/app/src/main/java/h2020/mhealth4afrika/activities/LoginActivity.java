package h2020.mhealth4afrika.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import h2020.mhealth4afrika.R;
import h2020.mhealth4afrika.config.AppConfig;
import h2020.mhealth4afrika.helpers.WidgetHelper;
import h2020.mhealth4afrika.models.User;
import h2020.mhealth4afrika.utils.SessionManager;
import h2020.mhealth4afrika.utils.SnackUtils;
import h2020.mhealth4afrika.utils.SystemServicesUtils;

public class LoginActivity extends Activity {

    private EditText inputUsername, inputPassword;

    private CoordinatorLayout rootLayout;

    private WidgetHelper widgets;
    private Context context = LoginActivity.this;

    private String username, password, serverResult, refDataResult;

    private Activity activity = this;

    private String url = AppConfig.getPOST_URL() + "Users/auth";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        rootLayout = (CoordinatorLayout) findViewById(R.id.rootLayout);

        widgets = new WidgetHelper(context);

        inputUsername = (EditText) findViewById(R.id.username);
        inputPassword = (EditText) findViewById(R.id.password);


        // Display any messages coming from other activities navigating to home
        if (getIntent().hasExtra("message")) {

            String message = getIntent().getStringExtra("message");
            boolean success = getIntent().getBooleanExtra("success", false);
            if (success) {
                SnackUtils.confirm(rootLayout, message);
            } else {
                SnackUtils.alert(rootLayout, message);
            }

        }

    }

    // Button click listener
    public void buttonClickListener(View view) {


        Intent intent;

        switch (view.getId()) {
            case R.id.btnLogin:
                EditText[] inputs = {inputUsername, inputPassword};
                if (widgets.isEditInputValid(inputs, this, rootLayout)) {

                    boolean isConnected = SystemServicesUtils.isConnected(context);

                    if (!isConnected) {
                        SnackUtils.alert(rootLayout, getResources().getString(R.string.no_internet_connection));
                    } else {
                        // Authenticate user
                        getFormData();


                        //new LoginTask(widgets).execute();
                        User sessionUser = new User();
                        sessionUser.setUserId(Integer.parseInt("1"));
                        sessionUser.setFirstName("Test");
                        sessionUser.setLastName("User");
                        sessionUser.setEmailAddress("test@mHelath4Afrika.org");
                        sessionUser.setRole(Integer.parseInt("1"));
                        sessionUser.setOrganizationId(Integer.parseInt("1"));

                        SessionManager.setSessionUserDetails(sessionUser, context);
                        SessionManager.setUserAuthenticated(context);

                        Log.w("USER", String.valueOf(sessionUser.getOrganizationId()));


                        // Set session
                        SessionManager.setSessionUserDetails(sessionUser, context);
                        SessionManager.setUserAuthenticated(context);

                        // Go to main activity
                        intent = new Intent(context, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();


                    }

                }

                break;

            case R.id.btnSetup:


                // Go to setup activity
                intent = new Intent(context, SetupActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();


                break;


            default:
                break;

        }

    }

    public void onClickListener(View view) {
        int id = view.getId();
        switch (id) {

            case R.id.forgot_password:

                Intent intent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                startActivity(intent);

                break;

            default:
                break;
        }
    }

    // Get user input
    public void getFormData() {

        username = inputUsername.getText().toString();
        password = inputPassword.getText().toString();

    }


}
