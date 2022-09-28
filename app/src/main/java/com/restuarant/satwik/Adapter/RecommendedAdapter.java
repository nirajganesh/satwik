package com.restuarant.satwik.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.restuarant.satwik.Model.Recommendedmodel;
import com.restuarant.satwik.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {
    Context context;
    ArrayList<Recommendedmodel> recommendedmodelArrayList;

    public RecommendedAdapter(Context context, ArrayList<Recommendedmodel> recommendedmodelArrayList) {
        this.context = context;
        this.recommendedmodelArrayList = recommendedmodelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recommended_listview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(recommendedmodelArrayList.get(position).getOffers().equals("0")) {
            holder.title.setText(recommendedmodelArrayList.get(position).getTitle());
            holder.subtitle.setText(recommendedmodelArrayList.get(position).getSubtitle());
            holder.price.setText(recommendedmodelArrayList.get(position).getPrice());
            Glide.with(context).load(recommendedmodelArrayList.get(position).getImage_src()).into(holder.circleImageView);
        }
        else
        {
            holder.relativeLayout.setVisibility(View.VISIBLE);
            holder.offer_text.setText(recommendedmodelArrayList.get(position).getOffers()+"% off");
            holder.title.setText(recommendedmodelArrayList.get(position).getTitle());
            holder.subtitle.setText(recommendedmodelArrayList.get(position).getSubtitle());
            holder.price.setText(recommendedmodelArrayList.get(position).getPrice());
            Glide.with(context).load(recommendedmodelArrayList.get(position).getImage_src()).into(holder.circleImageView);
        }

    }

    @Override
    public int getItemCount() {
        return recommendedmodelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,subtitle,price,offer_text;
        CircleImageView circleImageView;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.name_id);
            subtitle=itemView.findViewById(R.id.subtitle_id);
            price=itemView.findViewById(R.id.price_id);
            circleImageView=itemView.findViewById(R.id.profile_image);
            relativeLayout=itemView.findViewById(R.id.offer_show_id);
            offer_text=itemView.findViewById(R.id.offer_text_id);

        }
    }
}
