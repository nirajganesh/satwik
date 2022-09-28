package com.restuarant.satwik.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.restuarant.satwik.CategoriesActivity;
import com.restuarant.satwik.Model.Categoriesmodel;
import com.restuarant.satwik.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    Context context;
    ArrayList<Categoriesmodel> categoriesmodelArrayList;

    public CategoriesAdapter(Context context, ArrayList<Categoriesmodel> categoriesmodelArrayList) {
        this.context = context;
        this.categoriesmodelArrayList = categoriesmodelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.categories_listview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(categoriesmodelArrayList.get(position).getName());
        Glide.with(context).load(categoriesmodelArrayList.get(position).getImage_src()).into(holder.circleImageView);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, CategoriesActivity.class);
                intent.putExtra("name",categoriesmodelArrayList.get(position).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoriesmodelArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView name;
         ImageView circleImageView;
         RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name_id);
            circleImageView=itemView.findViewById(R.id.profile_image);
            relativeLayout=itemView.findViewById(R.id.card_id);
        }
    }
}
