package com.example.teras_angkringan.start;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import androidx.appcompat.app.AppCompatActivity;
import com.example.teras_angkringan.MainActivity;
import com.example.teras_angkringan.databinding.ActivityStartBinding;

public class StartActivity extends AppCompatActivity {
    private ActivityStartBinding binding;
    private Animation topAnim;
    private Animation bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Animations
        topAnim = android.view.animation.AnimationUtils.loadAnimation(this, com.example.teras_angkringan.R.anim.top_animation);
        bottomAnim = android.view.animation.AnimationUtils.loadAnimation(this, com.example.teras_angkringan.R.anim.bottom_animation);

        // Set animations to ImageView and Logo using ViewBinding
        binding.imageView.startAnimation(topAnim);
        binding.text1.startAnimation(bottomAnim);
        binding.btnNavigate.startAnimation(bottomAnim);

        binding.btnNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                intent.putExtra("kunci", "Nilai yang akan Anda kirim");
                startActivity(intent);
            }
        });
    }
}
