package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PurchasedProductAdapter extends ArrayAdapter<PurchasedProduct> {  //The PurchasedProductAdapter is extended

    ArrayList<PurchasedProduct>purchasedProductsList;      //ArrayList is created her of PurchasedPRoductType

    public PurchasedProductAdapter(Context context, ArrayList<PurchasedProduct> products) {
        super(context, 0, products);
        this.purchasedProductsList=products;                   //here the purchasedProdutsList
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.listitem,parent,false);
        }
        PurchasedProduct p_product= purchasedProductsList.get(position);   //Here we are getting the position of the element that we click in app

        String productName=p_product.getName();   //We made a string productName and we are retreving the name of selected element throught getter method which is in this case getName() as name is private element
        double productPrice= p_product.getPrice();   //Simplarly here but of double type
        int productQuantity=p_product.getQuantity();    //Here of int type

       //Let's find and set data attributes
        TextView purchasedProductPrice=convertView.findViewById(R.id.price);
        TextView purchasedProductName=convertView.findViewById(R.id.product_name);
        TextView purchasedProductQuantity=convertView.findViewById(R.id.quantity);

        //Assigning the values

        purchasedProductName.setText(productName);
        purchasedProductPrice.setText("Price: $" +String.valueOf(productPrice));
        purchasedProductQuantity.setText("Quantity: "+String.valueOf(productQuantity));

        return convertView;
    }
}