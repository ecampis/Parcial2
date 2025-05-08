package com.example.parcial2.adaptador;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.media.RouteListingPreference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


    public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    List itemList;
    Context context;

    public ItemAdapter(List<ClipData.Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        CircleImageView imagen;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            imagen = itemView.findViewById(R.id.imgPerfil);
        }
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(v);
    }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        }

        @NonNull
    @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ClipData.Item item = itemList.get(position);
        holder.nombre.setText(item.nombre);
        holder.imagen.setImageResource(item.imagenResId);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetalleActivity.class);
            intent.putExtra("nombre", item.nombre);
            intent.putExtra("imagen", item.imagenResId);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
