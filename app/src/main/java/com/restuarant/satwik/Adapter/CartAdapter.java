package com.restuarant.satwik.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.restuarant.satwik.Model.Cartmodel;
import com.restuarant.satwik.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    Context context;
    ArrayList<Cartmodel> cartmodelArrayList;

    public CartAdapter(Context context, ArrayList<Cartmodel> cartmodelArrayList) {
        this.context = context;
        this.cartmodelArrayList = cartmodelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cart_listview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(cartmodelArrayList.get(position).getTitle());
        holder.subtitle.setText(cartmodelArrayList.get(position).getSubtitle());
        holder.price.setText(cartmodelArrayList.get(position).getPrice());
        Glide.with(context).load(cartmodelArrayList.get(position).getImage_src()).into(holder.imageView);
        holder.quantity.setText(cartmodelArrayList.get(position).getQuantity());
    }

    @Override
    public int getItemCount() {
        return cartmodelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,subtitle,price,quantity;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.name_id);
            subtitle=itemView.findViewById(R.id.subtitle_id);
            price=itemView.findViewById(R.id.price_id);
            quantity=itemView.findViewById(R.id.textview_id);
            imageView=itemView.findViewById(R.id.profile_image);
        }
    }
}
