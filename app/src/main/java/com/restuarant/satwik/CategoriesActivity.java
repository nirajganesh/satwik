package com.restuarant.satwik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.restuarant.satwik.Adapter.CategoriesAdapter;
import com.restuarant.satwik.Adapter.CategorySelectAdapter;
import com.restuarant.satwik.Adapter.RecommendedAdapter;
import com.restuarant.satwik.Model.Categoriesmodel;
import com.restuarant.satwik.Model.Recommendedmodel;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity {

    String nameintent;
    CategorySelectAdapter categoriesAdapter;
    ArrayList<Categoriesmodel> categoriesmodelArrayList=new ArrayList<>();
    RecyclerView recyclerView,recyclerView1;
    Context context=CategoriesActivity.this;
    Toolbar toolbar;


    RecommendedAdapter recommendedAdapter;
    ArrayList<Recommendedmodel>  recommendedmodelArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        recyclerView=findViewById(R.id.recyclerview_id);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView1=findViewById(R.id.recyclerview_id_1);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        toolbar=findViewById(R.id.toolbar);

        nameintent= getIntent().getStringExtra("name");


        // categories add data
        Categoriesmodel categoriesmodel=new Categoriesmodel();
        categoriesmodel.setName("SNACKS");
        categoriesmodel.setImage_src(R.drawable.samosa);
        categoriesmodelArrayList.add(categoriesmodel);

        Categoriesmodel categoriesmodel1=new Categoriesmodel();
        categoriesmodel1.setName("SANWICH");
        categoriesmodel1.setImage_src(R.drawable.sandwich);
        categoriesmodelArrayList.add(categoriesmodel1);

        Categoriesmodel categoriesmodel2=new Categoriesmodel();
        categoriesmodel2.setName("SOUTH INDIAN");
        categoriesmodel2.setImage_src(R.drawable.dosa);
        categoriesmodelArrayList.add(categoriesmodel2);


        categoriesAdapter=new CategorySelectAdapter(context,categoriesmodelArrayList,nameintent);
        recyclerView.setAdapter(categoriesAdapter);

        // recommended listview
        recommendedmodelArrayList.add(new Recommendedmodel("Burnt garlic noodles","6 pcs large size this is not the info","0","₹40",R.drawable.dhokla));
        recommendedmodelArrayList.add(new Recommendedmodel("Panner tikka","Half","10","₹100",R.drawable.panner_tikka));
        recommendedmodelArrayList.add(new Recommendedmodel("Masala dosa","With sambhar & chutney","0","₹50",R.drawable.dosa));
        recommendedmodelArrayList.add(new Recommendedmodel("Moong bada","With sambhar & chutney","0","₹60",R.drawable.moong_bada));
        recommendedAdapter=new RecommendedAdapter(context,recommendedmodelArrayList);
        recyclerView1.setAdapter(recommendedAdapter);


        // toolbar back intent
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(CategoriesActivity.this,MainActivity.class);
              startActivity(intent);
              CategoriesActivity.this.finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(CategoriesActivity.this,MainActivity.class);
        startActivity(intent);
        CategoriesActivity.this.finish();
    }
}