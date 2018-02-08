package com.example.akankshasingh.ecommerce.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.akankshasingh.ecommerce.R;


/**
 * Created by Akanksha.Singh on 2/5/2018.
 */

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_categories;
    private Button btn_ranking;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btn_categories = findViewById(R.id.button_categories);
        btn_ranking = findViewById(R.id.button_ranking);
        btn_categories.setOnClickListener(this);
        btn_ranking.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(btn_categories)) {
            Intent myIntent = new Intent(StartActivity.this, HomeActivity.class);
            myIntent.putExtra("key", "CategoriesData");
            this.startActivity(myIntent);
        } else if (view.equals(btn_ranking)) {
            Intent myIntent = new Intent(StartActivity.this, HomeActivity.class);
            myIntent.putExtra("key", "RankingsData");
            this.startActivity(myIntent);
        }
    }
}
