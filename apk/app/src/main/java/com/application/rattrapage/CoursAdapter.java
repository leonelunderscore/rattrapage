package com.application.rattrapage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CoursAdapter extends RecyclerView.Adapter<CoursAdapter.Holder> {


    private Context context;
    private View view;
    private ArrayList<Cours> cours;

    private Activity activity;

    public CoursAdapter(Context context, ArrayList<Cours> cours, Activity activity) {
        this.context = context;
        this.cours = cours;
        this.activity = activity;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.item_cours,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        holder.niveau_cours.setText(cours.get(i).getLevel());
        holder.nom_cours.setText(cours.get(i).getName());
        holder.view_cours.setOnClickListener(v -> {
            Intent intent = new Intent(context,DetailsActivity.class);
            intent.putExtra("COURS",cours.get(i));
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return cours.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{

        private TextView nom_cours,niveau_cours;
        ImageView view_cours;


        public Holder(@NonNull View itemView){
            super(itemView);

            nom_cours = itemView.findViewById(R.id.name_cours);
            view_cours = itemView.findViewById(R.id.view_cours);
            niveau_cours = itemView.findViewById(R.id.niveau_cours);
        }
    }
}
