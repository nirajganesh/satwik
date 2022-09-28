package com.restuarant.satwik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mzule.fantasyslide.FantasyDrawerLayout;

public class MainActivity2 extends AppCompatActivity {
    Toolbar toolbar;
    FantasyDrawerLayout fantasyDrawerLayout;
    LinearLayout linearLayout;

    TextView edit_text;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar=findViewById(R.id.toolbar);
//        fantasyDrawerLayout=findViewById(R.id.drawber_id);
        linearLayout=findViewById(R.id.linear_search);
        edit_text=findViewById(R.id.textview_edit);
        editText=findViewById(R.id.edit_id);
        if(editText.requestFocus())
        {
            edit_text.setVisibility(View.INVISIBLE);
        }
        else
        {
            edit_text.setVisibility(View.VISIBLE);
        }

//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fantasyDrawerLayout.openDrawer(GravityCompat.START);
//            }
//        });
    }
}