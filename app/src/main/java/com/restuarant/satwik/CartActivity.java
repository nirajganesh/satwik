package com.restuarant.satwik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.restuarant.satwik.Adapter.CartAdapter;
import com.restuarant.satwik.Adapter.RecommendedAdapter;
import com.restuarant.satwik.Model.Cartmodel;
import com.restuarant.satwik.Model.Recommendedmodel;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Context context=CartActivity.this;
    Toolbar toolbar;


    CartAdapter cartAdapter;
    ArrayList<Cartmodel> cartmodelArrayList=new ArrayList<>();

    Button checkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView=findViewById(R.id.recyclerview_id_1);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        toolbar=findViewById(R.id.toolbar);


        // cart listview
        cartmodelArrayList.add(new Cartmodel("Burnt garlic noodles","6 pcs large size this is not the info","₹40","3",R.drawable.dhokla));
        cartmodelArrayList.add(new Cartmodel("Panner tikka","Half","₹100","10",R.drawable.panner_tikka));
        cartmodelArrayList.add(new Cartmodel("Masala dosa","With sambhar & chutney","₹50","4",R.drawable.dosa));
        cartmodelArrayList.add(new Cartmodel("Moong bada","With sambhar & chutney","₹60","2",R.drawable.moong_bada));
        cartAdapter=new CartAdapter(context,cartmodelArrayList);
        recyclerView.setAdapter(cartAdapter);

       // checkout button
        checkout=findViewById(R.id.checkout_id);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CartActivity.this,PaymentActivity.class);
                startActivity(intent);
            }
        });

        // toolbar back intent
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}