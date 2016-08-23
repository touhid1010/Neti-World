package com.netizenbd.netiworld;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout textInputLayout_firstName,
            textInputLayout_lastName,
            textInputLayout_mobile,
            textInputLayout_email,
            textInputLayout_id,
            textInputLayout_pass,
            textInputLayout_pass_again;

    EditText editText_user_first_name,
            editText_user_last_name,
            editText_user_mobile,
            editText_user_email,
            editText_user_id,
            editText_pass,
            editText_pass_again;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ToolBar back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // initialization
        textInputLayout_firstName = (TextInputLayout) findViewById(R.id.textInputLayout_firstName);
        textInputLayout_lastName = (TextInputLayout) findViewById(R.id.textInputLayout_lastName);
        textInputLayout_mobile = (TextInputLayout) findViewById(R.id.textInputLayout_mobile);
        textInputLayout_email = (TextInputLayout) findViewById(R.id.textInputLayout_email);
        textInputLayout_id = (TextInputLayout) findViewById(R.id.textInputLayout_id);
        textInputLayout_pass = (TextInputLayout) findViewById(R.id.textInputLayout_pass);
        textInputLayout_pass_again = (TextInputLayout) findViewById(R.id.textInputLayout_pass_again);

        editText_user_first_name = (EditText) findViewById(R.id.editText_user_first_name);
        editText_user_last_name = (EditText) findViewById(R.id.editText_user_last_name);
        editText_user_mobile = (EditText) findViewById(R.id.editText_user_mobile);
        editText_user_email = (EditText) findViewById(R.id.editText_user_email);
        editText_user_id = (EditText) findViewById(R.id.editText_user_id);
        editText_pass = (EditText) findViewById(R.id.editText_pass);
        editText_pass_again = (EditText) findViewById(R.id.editText_pass_again);


    }

    @Override
    public void onClick(View v) {

    }


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

                if (editText_user_first_name.getText().toString().isEmpty()) {
                    textInputLayout_firstName.setError("Name must be ginen");
                } else {
                    textInputLayout_firstName.setError(null);
                }

                if (!isValidMobile(editText_user_mobile.getText().toString())) {
                    textInputLayout_mobile.setError("Must be 11 character");
                } else {
                    textInputLayout_mobile.setError(null);
                }

                if (!isValidEmail(editText_user_email.getText().toString())) {
                    textInputLayout_email.setError("Invalid Email");
                } else {
                    textInputLayout_email.setError(null);
                }

                if (!isValidPassword(editText_pass.getText().toString())) {
                    textInputLayout_pass.setError("Min 8, Max 20 Character");
                } else {
                    textInputLayout_pass.setError(null);
                }

                if (!editText_pass.getText().toString().equals(editText_pass_again.getText().toString())) {
                    textInputLayout_pass_again.setError("Password mismatch");
                } else {
                    textInputLayout_pass_again.setError(null);
                }

                /**
                 * If all error null then post data to server and
                 * If some editText not empty
                 */
                if (textInputLayout_firstName.getError() == null &&
                        textInputLayout_lastName.getError() == null &&
                        textInputLayout_mobile.getError() == null &&
                        textInputLayout_email.getError() == null &&
                        textInputLayout_id.getError() == null &&
                        textInputLayout_pass.getError() == null &&
                        textInputLayout_pass_again.getError() == null &&
                        !editText_user_first_name.getText().toString().isEmpty() &&
                        !editText_user_id.getText().toString().isEmpty()) {

                    Toast.makeText(Signup.this, "No error found", Toast.LENGTH_SHORT).show();

                    // TODO volley code here

                } else {

                    Toast.makeText(Signup.this, "Error found", Toast.LENGTH_SHORT).show();

                }

                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }


    // Validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating mobile
    private boolean isValidMobile(String mobile) {
        if (mobile != null && mobile.length() == 11) {
            return true;
        } else {
            return false;
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
