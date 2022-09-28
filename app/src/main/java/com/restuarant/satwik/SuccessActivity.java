package com.restuarant.satwik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuccessActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button order_more;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        toolbar=findViewById(R.id.toolbar);
        order_more=findViewById(R.id.order_now_id);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SuccessActivity.this,MainActivity.class);
                startActivity(intent);
                SuccessActivity.this.finish();
            }
        });
        order_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SuccessActivity.this,MainActivity.class);
                startActivity(intent);
                SuccessActivity.this.finish();
            }
        });
    }
}