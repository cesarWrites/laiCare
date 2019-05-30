package com.example.laicare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
    Animation anim;
    ImageView imageView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView=(ImageView)findViewById(R.id.image1); // Declare an imageView to show the

        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in); // Create the

        anim.setAnimationListener(new Animation.AnimationListener() {
                                      @Override
                                      public void onAnimationStart(Animation animation) {

                                      }

                                      @Override
                                      public void onAnimationEnd(Animation animation) {
                                          startActivity(new Intent(getApplicationContext(), Landing.class));
                                      }

                                      @Override
                                      public void onAnimationRepeat(Animation animation) {

                                      }
                                  });

                imageView.startAnimation(anim);
}
    }