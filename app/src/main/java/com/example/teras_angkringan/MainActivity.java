package com.example.teras_angkringan;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.teras_angkringan.About.AboutActivity;
import com.example.teras_angkringan.Deskripsi.DeskripsiActivity;
import com.example.teras_angkringan.adapter.Adapter;
import com.example.teras_angkringan.data.Data;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView itemKu;
    private ArrayList<Data> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemKu = findViewById(R.id.item_ku);
        itemKu.setHasFixedSize(true);
        list.addAll(getListDokter());
        showRecyclerList();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_about) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
    private ArrayList<Data> getListDokter() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Data> listAngkringan = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Data angkringan = new Data(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1));
            listAngkringan.add(angkringan);
        }
        dataPhoto.recycle();
        return listAngkringan;
    }
    private void showRecyclerList() {
        itemKu.setLayoutManager(new LinearLayoutManager(this));
        Adapter listHeroAdapter = new Adapter(list);
        itemKu.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new Adapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Data data) {
                Intent intent = new Intent(MainActivity.this, DeskripsiActivity.class);
                intent.putExtra(DeskripsiActivity.DATA_ANGKRINGAN, data);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onClick(View view) {
        // Implementasi onClick
    }
}
