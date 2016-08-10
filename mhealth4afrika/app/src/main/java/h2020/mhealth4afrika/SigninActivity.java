package h2020.mhealth4afrika;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SigninActivity extends Activity implements View.OnClickListener {

    EditText password;
    TextView name;
    Button loginBtn;
    CheckBox remember;
    LinearLayout loginL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        password = (EditText) findViewById(R.id.pword);
        loginBtn = (Button) findViewById(R.id.login);
        remember = (CheckBox) findViewById(R.id.checkBox);
        loginL = (LinearLayout) findViewById(R.id.loginLayout);
        name = (TextView) findViewById(R.id.username);

        name.setText(lName);

        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == loginBtn) {
            final String pw = password.getText().toString();

            if (!isValidPassword(pw)){
                password.requestFocus();
                password.setError("Password must be more than 4 characters");
            }
            else
            {
                SharedPreferences sharedPreferences = getSharedPreferences("Account", Context.MODE_PRIVATE);
                String pState = sharedPreferences.getString("Password", null);

                if(pState.equals(pw) && remember.isChecked()) {
                    SharedPreferences sharedPreferences1 = getSharedPreferences("Account", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences1.edit();
                    editor.putBoolean("LoginStatus", true);
                    editor.commit();

                    Intent intent = new Intent(SigninActivity.this, LandingActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(pState.equals(pw) && (!remember.isChecked())){
                    Intent intent = new Intent(SigninActivity.this, LandingActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    password.requestFocus();
                    password.setError("Incorrect Password, Try again");
                }

            }

        }
    }
    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 4) {
            return true;
        }
        return false;
    }
    private long lastTime = 0;

    @Override
    public void onBackPressed() {

        if (System.currentTimeMillis() - lastTime < 2000) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}