package com.example.teras_angkringan.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import androidx.appcompat.app.AppCompatActivity;
import com.example.teras_angkringan.R;
import com.example.teras_angkringan.databinding.ActivitySplashScreenBinding;
import com.example.teras_angkringan.start.StartActivity;


public class SplashScreenActivity extends AppCompatActivity {
    private ActivitySplashScreenBinding binding;
    private final long splashTimeOut = 3000;
    private Animation topAnim;
    private Animation bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Animations
        topAnim = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        binding.gambar.startAnimation(topAnim);
        binding.textView2.startAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, StartActivity.class);
                startActivity(intent);
                finish();
            }
        }, splashTimeOut);
    }
}
