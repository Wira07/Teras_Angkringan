package com.example.teras_angkringan.Deskripsi;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.teras_angkringan.data.Data;
import com.example.teras_angkringan.databinding.ActivityDeskripsiBinding;
public class DeskripsiActivity extends AppCompatActivity {
    public static final String DATA_ANGKRINGAN = "extra_data";
    private ActivityDeskripsiBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeskripsiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Data data = getIntent().getParcelableExtra(DATA_ANGKRINGAN);
        if (data != null) {
            binding.detailfoto.setImageResource(data.getPhoto());
            binding.deskripsi.setText(data.getDescription());
            binding.nama.setText(data.getName());
        }
    }
}
