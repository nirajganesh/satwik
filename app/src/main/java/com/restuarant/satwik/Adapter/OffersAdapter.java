package com.restuarant.satwik.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.restuarant.satwik.CategoriesActivity;
import com.restuarant.satwik.Model.Offersmodel;
import com.restuarant.satwik.OffersActivity;
import com.restuarant.satwik.R;

import java.util.ArrayList;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.ViewHolder> {
    Context context;
    ArrayList<Offersmodel> offersmodelArrayList;

    public OffersAdapter(Context context, ArrayList<Offersmodel> offersmodelArrayList) {
        this.context = context;
        this.offersmodelArrayList = offersmodelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_order_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     holder.title.setText(offersmodelArrayList.get(position).getTitle());
  //   holder.offer_text.setText(offersmodelArrayList.get(position).getOffers());
     holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, OffersActivity.class);
                context.startActivity(intent);
            }
     });
    }

    @Override
    public int getItemCount() {
        return offersmodelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,offer_text;
     //   ImageButton arrow_btn;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title_id);
       //     offer_text=itemView.findViewById(R.id.offer_text_id);
            relativeLayout=itemView.findViewById(R.id.card_id);
        }
    }
}
