package com.restuarant.satwik.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.restuarant.satwik.CategoriesActivity;
import com.restuarant.satwik.Model.Categoriesmodel;
import com.restuarant.satwik.R;

import java.util.ArrayList;

public class CategorySelectAdapter extends RecyclerView.Adapter<CategorySelectAdapter.ViewHolder> {
    Context context;
    ArrayList<Categoriesmodel> categoriesmodelArrayList;
    String nameintent;

    public CategorySelectAdapter(Context context, ArrayList<Categoriesmodel> categoriesmodelArrayList,String nameintent) {
        this.context = context;
        this.categoriesmodelArrayList = categoriesmodelArrayList;
        this.nameintent=nameintent;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.categories_listview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(nameintent.equals(categoriesmodelArrayList.get(position).getName()))
        {
            holder.relativeLayout.setBackgroundResource(R.drawable.button_design);
            holder.name.setTextColor(Color.WHITE);
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
        else
        {
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
