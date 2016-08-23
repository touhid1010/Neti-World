package com.netizenbd.netiworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout textInputLayout_userId,
            textInputLayout_password;

    EditText editText_userId,
            editText_password;

    Button button_logIn,
            button_signup,
            button_forgotPassword;

    ImageView imageView_splashLogo,
            imageView_splashText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // Initialization
        textInputLayout_userId = (TextInputLayout) findViewById(R.id.textInputLayout_userId);
        textInputLayout_password = (TextInputLayout) findViewById(R.id.textInputLayout_password);

        editText_userId = (EditText) findViewById(R.id.editText_userId);
        editText_password = (EditText) findViewById(R.id.editText_password);


        button_logIn = (Button) findViewById(R.id.button_logIn);
        button_signup = (Button) findViewById(R.id.button_signup);
        button_forgotPassword = (Button) findViewById(R.id.button_forgotPassword);
        button_logIn.setOnClickListener(this);
        button_signup.setOnClickListener(this);
        button_forgotPassword.setOnClickListener(this);

        imageView_splashLogo = (ImageView) findViewById(R.id.imageView_splashLogo);
        imageView_splashText = (ImageView) findViewById(R.id.imageView_splashText);


        Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim_rotate_login_screen);
        Animation animationText = AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim_scale_login_screen_text);
        imageView_splashLogo.startAnimation(animation);
        imageView_splashText.startAnimation(animationText);














    } // end of onCreate


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button_logIn:

                final String emailMobile = editText_userId.getText().toString();
                if (!isValidEmail(emailMobile)) {
                    if (!isValidMobile(emailMobile)) {
                        textInputLayout_userId.setError("Invalid Email or Mobile");
                    } else {
                        textInputLayout_userId.setError(null);
                    }
                } else {
                    textInputLayout_userId.setError(null);
                }

                final String pass = editText_password.getText().toString();
                if (!isValidPassword(pass)) {
                    textInputLayout_password.setError("Invalid Password. Min 8 Max 20 Character");
                } else {
                    textInputLayout_password.setError(null);
                }


                if (textInputLayout_userId.getError() == null) {
                    if (textInputLayout_password.getError() == null) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                }


                break;

            case R.id.button_signup:

                startActivity(new Intent(getApplicationContext(), Signup.class));

                break;


            case R.id.button_forgotPassword:

                startActivity(new Intent(getApplicationContext(), ForgotPassword.class));

                break;


        }
    }

    // validating email id
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

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() < 21 && pass.length() > 7) {

            return true;
        } else {
            return false;
        }
    }


}
