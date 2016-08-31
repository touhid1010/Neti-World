package com.netizenbd.netiworld.loginsignup;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.netizenbd.netiworld.R;

public class ForgotPassword extends AppCompatActivity {

    TextInputLayout textInputLayout_user_id,
            textInputLayout_recovery_code,
            textInputLayout_newPass,
            textInputLayout_newPass_again;

    EditText editText_user_id,
            editText_recovery_code,
            editText_newPass,
            editText_newPass_again;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // set back button on toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // initialization
        textInputLayout_user_id = (TextInputLayout) findViewById(R.id.textInputLayout_user_id);
        textInputLayout_recovery_code = (TextInputLayout) findViewById(R.id.textInputLayout_recovery_code);
        textInputLayout_newPass = (TextInputLayout) findViewById(R.id.textInputLayout_newPass);
        textInputLayout_newPass_again = (TextInputLayout) findViewById(R.id.textInputLayout_newPass_again);

        editText_user_id = (EditText) findViewById(R.id.editText_user_id);
        editText_recovery_code = (EditText) findViewById(R.id.editText_recovery_code);
        editText_newPass = (EditText) findViewById(R.id.editText_newPass);
        editText_newPass_again = (EditText) findViewById(R.id.editText_newPass_again);






    } // end of onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.action_save:

                if (editText_user_id.getText().toString().isEmpty()) {
                    textInputLayout_user_id.setError("ID must be given.");
                } else {
                    textInputLayout_user_id.setError(null);
                }

                if (editText_recovery_code.getText().toString().isEmpty()) {
                    textInputLayout_recovery_code.setError("Please type recovery code");
                } else {
                    textInputLayout_recovery_code.setError(null);
                }

                if (!isValidPassword(editText_newPass.getText().toString())) {
                    textInputLayout_newPass.setError("Min 8, Max 20 Character");
                } else {
                    textInputLayout_newPass.setError(null);
                }

                if (!editText_newPass.getText().toString().equals(editText_newPass_again.getText().toString())) {
                    textInputLayout_newPass_again.setError("Password mismatch");
                } else {
                    textInputLayout_newPass_again.setError(null);
                }

                /**
                 * If all error null then post data to server and
                 * If some editText not empty
                 */
                if (textInputLayout_user_id.getError() == null &&
                        textInputLayout_recovery_code.getError() == null &&
                        textInputLayout_newPass.getError() == null &&
                        textInputLayout_newPass_again.getError() == null &&
                        !editText_user_id.getText().toString().isEmpty() &&
                        !editText_recovery_code.getText().toString().isEmpty()) {

                    Toast.makeText(ForgotPassword.this, "No error found", Toast.LENGTH_SHORT).show();

                    // TODO volley code here

                } else {

                    Toast.makeText(ForgotPassword.this, "Error found", Toast.LENGTH_SHORT).show();

                }


                return true;




            default:
                return super.onOptionsItemSelected(item);
        }
    }


    // Validating first name and last name
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 7 && pass.length() < 21) {
            return true;
        } else {
            return false;
        }
    }


}
