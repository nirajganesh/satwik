package com.restuarant.satwik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {

    Button finish_btn;
    TextView delivery_btn,take_btn,select;
    CardView take_card,address_card;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        delivery_btn=findViewById(R.id.item1);
        take_btn=findViewById(R.id.item2);
        finish_btn=findViewById(R.id.finish_id);
        take_card=findViewById(R.id.take_card_id);
        address_card=findViewById(R.id.address_card_id);
        select=findViewById(R.id.select);
        toolbar=findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PaymentActivity.this,SuccessActivity.class);
                startActivity(intent);
            }
        });
        delivery_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                take_btn.setTextColor(Color.BLACK);
                delivery_btn.setTextColor(Color.WHITE);
                select.animate().x(0).setDuration(100);
                address_card.setVisibility(View.VISIBLE);
                take_card.setVisibility(View.GONE);

            }
        });
        take_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delivery_btn.setTextColor(Color.BLACK);
                take_btn.setTextColor(Color.WHITE);
                int size=take_btn.getWidth();
                select.animate().x(size).setDuration(100);
               address_card.setVisibility(View.GONE);
               take_card.setVisibility(View.VISIBLE);

            }
        });
    }
}