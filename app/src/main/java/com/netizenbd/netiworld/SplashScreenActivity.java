package com.netizenbd.netiworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.netizenbd.netiworld.loginsignup.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView imageView_splashLogo,
            imageView_splashText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);


        imageView_splashLogo = (ImageView) findViewById(R.id.imageView_splashLogo);
        imageView_splashText = (ImageView) findViewById(R.id.imageView_splashText);




        Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim_rotate_splash_screen);
        Animation animationText = AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim_scale_splash_screen_text);
        imageView_splashLogo.startAnimation(animation);
        imageView_splashText.startAnimation(animationText);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                finish();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

}
