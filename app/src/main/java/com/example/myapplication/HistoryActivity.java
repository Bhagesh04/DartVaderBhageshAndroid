package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {


    private ArrayList<PurchasedProduct> purchasedProducts;
Button bckButton;
ListView historyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        bckButton=findViewById(R.id.historyBack);
        historyView=findViewById(R.id.H_list);
        purchasedProducts = (ArrayList<PurchasedProduct>) getIntent().getSerializableExtra("purchasedProducts");


       // ArrayAdapter<PurchasedProduct> arrayAdapter=new ArrayAdapter<PurchasedProduct>(this, android.R.layout.simple_spinner_dropdown_item,purchasedProducts);

        //We Have To use A Custom Layout For this

        PurchasedProductAdapter purchasedProductAdapter=new PurchasedProductAdapter(this,purchasedProducts);
       historyView.setAdapter(purchasedProductAdapter);


        //historyView.setAdapter(arrayAdapter);
        bckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}