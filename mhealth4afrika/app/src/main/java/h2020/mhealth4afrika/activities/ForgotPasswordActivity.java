package h2020.mhealth4afrika.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import h2020.mhealth4afrika.R;
import h2020.mhealth4afrika.helpers.WidgetHelper;
import h2020.mhealth4afrika.utils.SnackUtils;
import h2020.mhealth4afrika.utils.SystemServicesUtils;


public class ForgotPasswordActivity extends AppCompatActivity {


    private EditText inputUsername, inputPassword;

    private String username, password, message;

    private CoordinatorLayout rootLayout;
    private WidgetHelper widgets;
    private Context context = ForgotPasswordActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        rootLayout = (CoordinatorLayout) findViewById(R.id.rootLayout);


        inputUsername = (EditText) findViewById(R.id.username);
        inputPassword = (EditText) findViewById(R.id.password);

        widgets = new WidgetHelper(context);


    }


    // Button click listener
    public void buttonClickListener(View view) {


        Intent intent;

        switch (view.getId()) {
            case R.id.btnSubmit:
                EditText[] inputs = {inputUsername, inputPassword};
                if (widgets.isEditInputValid(inputs, this, rootLayout)) {

                    boolean isConnected = SystemServicesUtils.isConnected(context);

                    if (!isConnected) {
                        SnackUtils.alert(rootLayout, getResources().getString(R.string.no_internet_connection));
                    } else {
                        // get details user
                        getFormData();


                        // Go to login activity
                        message = getResources().getString(R.string.successful_post_password);
                        intent = new Intent(context, LoginActivity.class);
                        intent.putExtra("message", message);
                        intent.putExtra("success", true);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();


                    }

                }

                break;


            default:
                break;

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // Go back?
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }


    // Get user input
    public void getFormData() {

        username = inputUsername.getText().toString();
        password = inputPassword.getText().toString();

    }

}
