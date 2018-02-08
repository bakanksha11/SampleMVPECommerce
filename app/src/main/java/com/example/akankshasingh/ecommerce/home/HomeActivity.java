package com.example.akankshasingh.ecommerce.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.akankshasingh.ecommerce.BaseApplicationClass;
import com.example.akankshasingh.ecommerce.R;
import com.example.akankshasingh.ecommerce.models.CategoriesData;
import com.example.akankshasingh.ecommerce.models.JsonData;
import com.example.akankshasingh.ecommerce.models.ProductsData;
import com.example.akankshasingh.ecommerce.models.RankingsData;
import com.example.akankshasingh.ecommerce.networking.Service;

import java.util.Collections;
import java.util.Comparator;

import javax.inject.Inject;

/**
 * Created by Akanksha.Singh on 2/5/2018.
 */
public class HomeActivity extends BaseApplicationClass implements HomeView {

    @Inject
    public Service service;
    ProgressBar progressBar;
    private RecyclerView list;
    private LinearLayout ll_list;
    private TextView tv_no_data_found;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);

        renderView();
        init();

        HomePresenter presenter = new HomePresenter(service, this);
        presenter.getJsonList();
    }

    public void renderView() {
        setContentView(R.layout.activity_home);
        list = findViewById(R.id.list);
        progressBar = findViewById(R.id.progress);
        ll_list = findViewById(R.id.ll_list);
        tv_no_data_found = findViewById(R.id.text_no_data_found);

    }

    public void init() {
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {
    }

    @Override
    public void getJsonDataSuccess(final JsonData jsonData) {

        if (getIntent().hasExtra("key")) {
            if (getIntent().getStringExtra("key").equals("CategoriesData")) {
                if (jsonData.getCategories() != null && jsonData.getCategories().size() > 0) {
                    HomeAdapter adapter = new HomeAdapter(getApplicationContext(), jsonData.getCategories(),
                            new HomeAdapter.OnItemClickListener() {
                                @Override
                                public void onClick(CategoriesData categoriesData) {
                                    if (categoriesData.getProducts() != null && categoriesData.getProducts().size() > 0) {
                                        CategoriesAdapter adapter = new CategoriesAdapter(getApplicationContext(), categoriesData.getProducts(),
                                                new CategoriesAdapter.OnItemClickListener() {
                                                    @Override
                                                    public void onClick(ProductsData productsData) {
                                                        if (productsData.getVariants() != null && productsData.getVariants().size() > 0) {

                                                            CategoriesProductsAdapter adapter = new CategoriesProductsAdapter(getApplicationContext(), productsData.getVariants());
                                                            list.setAdapter(adapter);
                                                            if (productsData.getName() != null)
                                                                setTitle(productsData.getName().trim());
                                                            else
                                                                setTitle(getString(R.string.text_product_variants));
                                                        } else {
                                                            ll_list.setVisibility(View.GONE);
                                                            tv_no_data_found.setVisibility(View.VISIBLE);
                                                        }
                                                    }
                                                });
                                        list.setAdapter(adapter);
                                        if (categoriesData.getName() != null)
                                            setTitle(categoriesData.getName().trim());
                                        else
                                            setTitle(getString(R.string.text_products));
                                    } else {
                                        ll_list.setVisibility(View.GONE);
                                        tv_no_data_found.setVisibility(View.VISIBLE);
                                    }
                                }
                            });
                    list.setAdapter(adapter);
                    setTitle(getResources().getString(R.string.text_categories));
                } else {
                    ll_list.setVisibility(View.GONE);
                    tv_no_data_found.setVisibility(View.VISIBLE);
                }
            } else if (getIntent().getStringExtra("key").equals("RankingsData")) {
                if (jsonData.getRankings() != null && jsonData.getRankings().size() > 0) {
                    RankingDataAdapter adapter = new RankingDataAdapter(getApplicationContext(), jsonData.getRankings(),
                            new RankingDataAdapter.OnItemClickListener() {
                                @Override
                                public void onClick(RankingsData rankingsData) {
                                    sortedList(rankingsData);
                                    if (rankingsData.getProducts() != null && rankingsData.getProducts().size() > 0) {

                                        ProductsRankingAdapter adapter = new ProductsRankingAdapter(getApplicationContext(), rankingsData.getProducts());
                                        list.setAdapter(adapter);
                                        if (rankingsData.getRanking() != null)
                                            setTitle(rankingsData.getRanking().trim());
                                        else
                                            setTitle(getString(R.string.text_product_variants));
                                    } else {
                                        ll_list.setVisibility(View.GONE);
                                        tv_no_data_found.setVisibility(View.VISIBLE);
                                    }
                                }
                            });
                    list.setAdapter(adapter);
                    setTitle(getResources().getString(R.string.text_ranking_wise_products));
                } else {
                    ll_list.setVisibility(View.GONE);
                    tv_no_data_found.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    private void sortedList(RankingsData rankingsData) {
        Collections.sort(rankingsData.getProducts(), new Comparator<ProductsData>() {
            @Override
            public int compare(ProductsData left, ProductsData right) {

                if (right.getView_count() != null)
                    return right.getView_count().compareTo(left.getView_count());
                else if (right.getOrder_count() != null)
                    return right.getOrder_count().compareTo(left.getOrder_count());
                else if (right.getShares() != null)
                    return right.getShares().compareTo(left.getShares());
                else
                    return 0;
            }
        });
    }
}
