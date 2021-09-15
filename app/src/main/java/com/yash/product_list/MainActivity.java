package com.yash.product_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import com.yash.product_list.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
                R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};
        String[] name = {"Apple iPhone XR (64GB) - Black","New Apple iPhone 11 (64GB) - Yellow","New Apple iPhone XR (128GB) - Black",
                "New Apple iPhone 11 (256GB) - Purple","New Apple iPhone 12 Pro Max (256GB) - Pacific Blue","New Apple iPhone 11 (128GB) - Green",
                "New Apple iPhone 11 (64GB) - Purple","New Apple iPhone 11 (64GB) - Black","New Apple iPhone 11 (64GB) - Green"};
        String[] price = {"Rs.42999","Rs.51999","Rs.46999","Rs.89999","Rs.62999",
                "Rs.59999","Rs.92999","Rs.68999","Rs.52999"};
        String[] country = {"India","India","India","India","India","India","India","India","India"};

        ArrayList<Product> productArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            Product product = new Product(name[i],price[i],country[i],imageId[i]);
            productArrayList.add(product);

        }


        ListAdapter listAdapter = new ListAdapter(MainActivity.this,productArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this, ProductActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("price",price[position]);
                i.putExtra("country",country[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}