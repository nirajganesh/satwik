package com.restuarant.satwik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.restuarant.satwik.Adapter.CategoriesAdapter;
import com.restuarant.satwik.Adapter.RecommendedAdapter;
import com.restuarant.satwik.Model.Categoriesmodel;
import com.restuarant.satwik.Model.Recommendedmodel;

import java.util.ArrayList;

public class OffersActivity extends AppCompatActivity {


    RecommendedAdapter recommendedAdapter;
    ArrayList<Recommendedmodel>  recommendedmodelArrayList=new ArrayList<>();

    RecyclerView recyclerView;
    Context context=OffersActivity.this;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        recyclerView=findViewById(R.id.recyclerview_id_1);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        toolbar=findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        // recommended listview
        recommendedmodelArrayList.add(new Recommendedmodel("Burnt garlic noodles","6 pcs large size this is not the info","0","₹40",R.drawable.dhokla));
        recommendedmodelArrayList.add(new Recommendedmodel("Panner tikka","Half","10","₹100",R.drawable.panner_tikka));
        recommendedmodelArrayList.add(new Recommendedmodel("Masala dosa","With sambhar & chutney","0","₹50",R.drawable.dosa));
        recommendedmodelArrayList.add(new Recommendedmodel("Moong bada","With sambhar & chutney","0","₹60",R.drawable.moong_bada));
        recommendedAdapter=new RecommendedAdapter(context,recommendedmodelArrayList);
        recyclerView.setAdapter(recommendedAdapter);


        // toolbar back intent
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}