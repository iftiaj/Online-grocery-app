package com.example.assignment.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.assignment.Adaptor.CategoryAdaptor;
import com.example.assignment.Adaptor.PromotionAdaptor;
import com.example.assignment.Domain.CategoryDomain;
import com.example.assignment.Domain.FoodDomain;
import com.example.assignment.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;
    private ImageView btnUserProfile;
    private ImageView btnAdminHome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();



        btnUserProfile = (ImageView) findViewById(R.id.btnProfile);
        btnUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CustomerRegActivity.class);
                startActivity(intent);
            }
        });

        btnAdminHome = (ImageView) findViewById(R.id.btnAdmin);
        btnAdminHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AdminActivity.class);
                startActivity(intent);
            }
        });




        // pdf



        // pdf

    }

     // pdf ****************




 // pdf **************************



    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Snacks", "category_1"));
        category.add(new CategoryDomain("Dairy", "category-2"));
        category.add(new CategoryDomain("Frozen", "category_3"));
        category.add(new CategoryDomain("Vegetables", "category_4"));
        category.add(new CategoryDomain("Bakery", "category_5"));

        adapter = new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewPopular() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(gridLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Fresh Milk", "item_milk", "Farm fresh pure australian milk. 1 liter", 9.00));
        foodList.add(new FoodDomain("Frozen Beef", "item_beef", "Australian chilled beef Per KG", 18.00));
        foodList.add(new FoodDomain("Apple", "item_apple", "Red Apple Per KG", 6.00));
        foodList.add(new FoodDomain("Banana", "item_bananas", "Per KG", 3.00));
        foodList.add(new FoodDomain("Broccoli", "item_broccoli", "Per Piece", 4.50));
        foodList.add(new FoodDomain("Coke Can", "item_can", "Coke Can", 2.00));
        foodList.add(new FoodDomain("Carrot", "item_carrot", "Per KG", 2.50));
        foodList.add(new FoodDomain("Chicken", "item_chicken", "Chicken cut 9 piece estimated 1.2 KG", 8.50));
        foodList.add(new FoodDomain("Choco Cookie", "item_cookie", "World's best choco cookies per KG", 12.00));
        foodList.add(new FoodDomain("Cookies", "item_cookies", "Peanut cookies per KG", 10.00));
        foodList.add(new FoodDomain("Eggs", "item_eggs", "10 eggs", 6.00));
        foodList.add(new FoodDomain("Fish", "item_fish", "Rohu Fish per KG", 8.5));
        foodList.add(new FoodDomain("Ramen", "item_noodles", "Spicy korean ramen", 12.00));
        foodList.add(new FoodDomain("Apple Juice", "item_juice", "Pure apple juice 1 liter", 10.00));
        foodList.add(new FoodDomain("Lime", "item_lemon", "Big limes per piece", 2.00));
        foodList.add(new FoodDomain("Nuggets", "item_nuggets", "Ramly chicken nuggets 800 Gram", 12.00));
        foodList.add(new FoodDomain("Orange", "item_orange_juice", "4 piece orange", 4.00));
        foodList.add(new FoodDomain("Salmon", "item_salmon", "Salmon steak", 18.00));
        foodList.add(new FoodDomain("Coke", "item_coke", "1.5 Liter Coke", 3.50));
        foodList.add(new FoodDomain("Strawberry", "item_strawberry", "Strawberry 200 Gram", 14.00));
        foodList.add(new FoodDomain("Lays", "item_chips", "BBQ favour chips", 3.50));
        foodList.add(new FoodDomain("Ice Cream", "item_icecream", "Mix Ice-cream", 16.00));
        foodList.add(new FoodDomain("Flour", "item_flour", "Australian flour", 2.00));
        foodList.add(new FoodDomain("Cereal", "item_cereal", "Rainbow cereal", 6.00));
        foodList.add(new FoodDomain("Chocolate", "item_chocolate_bar", "Dark chocolate", 7.00));
        foodList.add(new FoodDomain("Candy", "item_candy", "Magic candy", 1.00));
        foodList.add(new FoodDomain("Onion", "item_onion", "Onion per KG", 3.50));

        adapter2 = new PromotionAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}