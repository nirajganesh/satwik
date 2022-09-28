package com.restuarant.satwik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.mzule.fantasyslide.FantasyDrawerLayout;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.restuarant.satwik.Adapter.BestsellerAdapter;
import com.restuarant.satwik.Adapter.CategoriesAdapter;
import com.restuarant.satwik.Adapter.OffersAdapter;
import com.restuarant.satwik.Adapter.RecommendedAdapter;
import com.restuarant.satwik.Model.Bestsellermodel;
import com.restuarant.satwik.Model.Categoriesmodel;
import com.restuarant.satwik.Model.Offersmodel;
import com.restuarant.satwik.Model.Recommendedmodel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    CategoriesAdapter categoriesAdapter;
    ArrayList<Categoriesmodel> categoriesmodelArrayList=new ArrayList<>();
    RecyclerView recyclerView,recyclerView1,recyclerView2,recyclerView3,recyclerView4,recyclerView5;
    Context context=MainActivity.this;

    BestsellerAdapter bestsellerAdapter;
    ArrayList<Bestsellermodel> bestsellermodelArrayList=new ArrayList<>();


    OffersAdapter offersAdapter;
    ArrayList<Offersmodel>  offersmodelArrayList=new ArrayList<>();

    RecommendedAdapter recommendedAdapter;
    ArrayList<Recommendedmodel>  recommendedmodelArrayList=new ArrayList<>();

    //bottom navigation
    BottomNavigationView bottomNavigationView;
    NestedScrollView nestedScrollView;
    CircleImageView circleImageView;

    // drawber declaration
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recyclerview declration
        recyclerView=findViewById(R.id.recyclerview_id);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView1=findViewById(R.id.recyclerview_id_1);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView1.setLayoutManager(linearLayoutManager1);

        recyclerView2=findViewById(R.id.recyclerview_id_2);
        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView2.setLayoutManager(linearLayoutManager2);

        recyclerView3=findViewById(R.id.recyclerview_id_3);
        LinearLayoutManager linearLayoutManager3=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView3.setLayoutManager(linearLayoutManager3);

        recyclerView4=findViewById(R.id.recyclerview_id_4);
        LinearLayoutManager linearLayoutManager4=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView4.setLayoutManager(linearLayoutManager4);

        recyclerView5=findViewById(R.id.recyclerview_id_5);
        LinearLayoutManager linearLayoutManager5=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView5.setLayoutManager(linearLayoutManager5);

        circleImageView=findViewById(R.id.profile_image);

        //
        navigationView=(NavigationView)findViewById(R.id.navigation_id);
        drawerLayout=findViewById(R.id.drawber);


        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.side_bar);

      


        //nestedscroolview
        nestedScrollView=findViewById(R.id.nested_id);
//        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                      if(scrollY>oldScrollY)
//                      {
//                          final RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams)circleImageView.getLayoutParams();
//                          layoutparams.setMargins(100,10,20,100);
//                          circleImageView.setLayoutParams(layoutparams);
//                      }
//                      else
//                      {
//                          final RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams)circleImageView.getLayoutParams();
//                          layoutparams.setMargins(100,100,100,100);
//                          circleImageView.setLayoutParams(layoutparams);
//                      }
//
//            }
//        });
        //bottomnavigationview
        bottomNavigationView=findViewById(R.id.navigationmenuid);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.cartid) {
                   Intent intent=new Intent(MainActivity.this,CartActivity.class);
                   startActivity(intent);
                }
                if (item.getItemId() == R.id.profileid) {

                }
                if (item.getItemId() == R.id.orderid1) {

                }
                return true;
            }
        });


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


        categoriesAdapter=new CategoriesAdapter(context,categoriesmodelArrayList);
        recyclerView.setAdapter(categoriesAdapter);


        // bestseller listview

        bestsellermodelArrayList.add(new Bestsellermodel("Tea","Cutting",R.drawable.tea));
        bestsellermodelArrayList.add(new Bestsellermodel("Poha","Half",R.drawable.poha));
        bestsellermodelArrayList.add(new Bestsellermodel("Panner butter masala","Full",R.drawable.chhole));
        bestsellerAdapter=new BestsellerAdapter(context,bestsellermodelArrayList);
        recyclerView1.setAdapter(bestsellerAdapter);

        // offer listview
        offersmodelArrayList.add(new Offersmodel("Get upto 50% off +free delivery","UPTO 50% OFF"));
        offersmodelArrayList.add(new Offersmodel("Use coupon code FIRST50 to get flat RS.50/- OFF","FLAT50"));
        offersAdapter=new OffersAdapter(context,offersmodelArrayList);
        recyclerView2.setAdapter(offersAdapter);

        // recommended listview
        recommendedmodelArrayList.add(new Recommendedmodel("Burnt garlic noodles","6 pcs large size this is not the info","0","₹40",R.drawable.dhokla));
        recommendedmodelArrayList.add(new Recommendedmodel("Panner tikka","Half","10","₹100",R.drawable.panner_tikka));
        recommendedmodelArrayList.add(new Recommendedmodel("Masala dosa","With sambhar & chutney","0","₹50",R.drawable.dosa));
        recommendedmodelArrayList.add(new Recommendedmodel("Moong bada","With sambhar & chutney","0","₹60",R.drawable.moong_bada));
        recommendedAdapter=new RecommendedAdapter(context,recommendedmodelArrayList);
        recyclerView3.setAdapter(recommendedAdapter);

        // today listview
        recyclerView4.setAdapter(bestsellerAdapter);

        // everything listview
        recyclerView5.setAdapter(recommendedAdapter);

        //navigationview select
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.searchid:
                        Intent intent=new Intent(MainActivity.this,CartActivity.class);
                        startActivity(intent);
                        return true;
                }
                return true;
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
}