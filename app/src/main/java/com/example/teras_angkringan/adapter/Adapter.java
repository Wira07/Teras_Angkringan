package com.example.teras_angkringan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.teras_angkringan.R;
import com.example.teras_angkringan.data.Data;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ListViewHolder> {

    private ArrayList<Data> listDokter;
    private OnItemClickCallback onItemClickCallback;

    public Adapter(ArrayList<Data> listDokter) {
        this.listDokter = listDokter;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        Data data = listDokter.get(position);

        holder.imgPhoto.setImageResource(data.getPhoto());
        holder.tvName.setText(data.getName());
        holder.tvDescription.setText(data.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickCallback != null) {
                    onItemClickCallback.onItemClicked(listDokter.get(holder.getAdapterPosition()));
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return listDokter.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;

        public ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(Data data);
    }
}
