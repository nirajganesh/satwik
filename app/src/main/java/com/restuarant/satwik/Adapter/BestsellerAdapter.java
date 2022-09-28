package com.restuarant.satwik.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.restuarant.satwik.Model.Bestsellermodel;
import com.restuarant.satwik.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BestsellerAdapter extends RecyclerView.Adapter<BestsellerAdapter.ViewHoler> {

    Context context;
    ArrayList<Bestsellermodel> bestsellermodelArrayList;

    public BestsellerAdapter(Context context, ArrayList<Bestsellermodel> bestsellermodelArrayList) {
        this.context = context;
        this.bestsellermodelArrayList = bestsellermodelArrayList;
    }


    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.bestseller_listview,parent,false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        holder.title.setText(bestsellermodelArrayList.get(position).getName());
        holder.subtitle.setText(bestsellermodelArrayList.get(position).getSubtitle());
        Glide.with(context).load(bestsellermodelArrayList.get(position).getImage_src()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return bestsellermodelArrayList.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
         TextView title,subtitle;
         ImageView imageView;
         Button addbtn;
        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.name_id);
            subtitle=itemView.findViewById(R.id.subtitle_id);
            imageView=itemView.findViewById(R.id.profile_image);
            addbtn=itemView.findViewById(R.id.add_button_id);
        }
    }
}
