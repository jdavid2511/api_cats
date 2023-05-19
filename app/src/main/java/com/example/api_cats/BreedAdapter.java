package com.example.api_cats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BreedAdapter extends RecyclerView.Adapter<BreedAdapter.ViewHolder> {

    private ArrayList<CatBreed> dataset;
    private Context context;

    public BreedAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CatBreed p = dataset.get(position);
        holder.name.setText(p.getName());
        holder.origin.setText(p.getOrigin());
        holder.inteligence.setText(p.getIntelligence());
      /* Glide.with(context)
                .load("")
                .apply(RequestOptions.centerCropTransform())
                .into(holder.foto);*/
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaBreeds(List<CatBreed> listaBreed) {
        dataset.addAll(listaBreed);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView foto;
        private TextView name;
        private TextView origin;
        private TextView inteligence;

        public ViewHolder(View itemView) {
            super(itemView);
            //foto= itemView.findViewById(R.id.foto);
            name = itemView.findViewById(R.id.name);
            origin = itemView.findViewById(R.id.country);
            inteligence = itemView.findViewById(R.id.inteligence);
        }
    }
}
