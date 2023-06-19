package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RestockActivity extends AppCompatActivity {   //The Restock Activity extends the AppCompat Activity

    Button backButton;           //A backButton is created here of Button type
    Button okButton;              // A okButton is created here of buttontype

    ListView restockView;          //a listView Type element is created here and is given name restockView

    EditText updateText;             //A editText element is created here and is given name "updateText"
    String inputText;              //input text is a string
    int value;                       //int value created

    private ProductAdapter adapter;             //A productAdapter type adapter created
    private List<Product> restockList;              //A list of products type created and is given name restock List

    Product selectedProduct;                             //An object of selectedProductType created here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);

           //We are assinging the RestockActity elements in .xml file to respective Java Code
        backButton = findViewById(R.id.restockBack);
        okButton = findViewById(R.id.restockOk);
        restockView = findViewById(R.id.restockListView);
        updateText = findViewById(R.id.restockEditText);

        //Here we are reciving the intent
        Intent intent = getIntent();
        restockList = (List<Product>) intent.getSerializableExtra("restockList"); //The restock list is recived here which is passed in mangager intent

        adapter = new ProductAdapter(this, restockList);
        restockView.setAdapter(adapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //This all controls the editor plane actions
        updateText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    inputText = updateText.getText().toString();
                    value = Integer.parseInt(inputText);
                    return true;
                }
                return false;
            }
        });

        restockView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedProduct = adapter.getItem(position);  //Reciving the selectedItem Position
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText = updateText.getText().toString(); //Updateing the text
                value = Integer.parseInt(inputText);           //updating the value
                selectedProduct.setQuantity(value);                //Updateing the quatity of the procut
                adapter.notifyDataSetChanged();             //Now notifying the data
            }
        });
    }
}
