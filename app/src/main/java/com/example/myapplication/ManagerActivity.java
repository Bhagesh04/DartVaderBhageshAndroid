package com.example.myapplication; //The Package Defination here

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ManagerActivity extends AppCompatActivity {             //The ManagerActivity extends to the AppCombatActivity

    private ArrayList<PurchasedProduct> purchasedProducts;           //An Array list of PurchasedProduct is created here
    private List<Product> productList;                              //Here another List of product class is created productList
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        Button HistoryButton=findViewById(R.id.history_btn);              //What we are doing here is connecting the historyButton in xml file to java code
        Button RestockButton=findViewById(R.id.Restock_btn);       //Similarly What we are doing here is connecting the RestockButton in xml file to java code
        Button BackButton=findViewById(R.id.back_btn);                  //What we are doing here is connecting the BackButton in xml file to java code

        //We are storing the purchasedProducts that we passed in Main.xml File
        purchasedProducts =(ArrayList<PurchasedProduct>)getIntent().getSerializableExtra("purchasedProducts");
        //Simlarly we are doing here
        productList=(List<Product>)getIntent().getSerializableExtra("productsList");
        HistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent historyIntent = new Intent(ManagerActivity.this, HistoryActivity.class); //Here we are connecting the ManagerAciivity to History activity
                historyIntent.putExtra("purchasedProducts", purchasedProducts); //The purchasedProducts are passed into history intent
                startActivity(historyIntent);   //The History intent is started here
            }
        });

        RestockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RestockIntent=new Intent(ManagerActivity.this,RestockActivity.class); //Here we are connecting the Restock intent
                RestockIntent.putExtra("restockList",(Serializable) productList);             //The product list is passed to Resotck intent
                startActivity(RestockIntent);         //The Restock intent is started here
            }
        });

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }        //Manager intent is stoped here
        });

    }
}