package com.simplesite.mdhalim.dewaara;

import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity implements Animation.AnimationListener {
    ImageView imageView;
    private static int SFLASH_TIME_OUT = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN ,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        imageView = (ImageView) findViewById( R.id.imageView );

        Animation animation = AnimationUtils.loadAnimation( this, R.anim.anim );
        imageView.setAnimation(animation);

        animation.setAnimationListener( this );
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        },SFLASH_TIME_OUT);
    }


    @Override
    public void onAnimationStart(Animation animation) {
        Toast.makeText(WelcomeActivity.this, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast.makeText(WelcomeActivity.this, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

        Toast.makeText(WelcomeActivity.this, "", Toast.LENGTH_SHORT).show();
    }
}
