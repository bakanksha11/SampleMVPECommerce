package com.example.akankshasingh.ecommerce.models;

import java.util.List;

/**
 * Created by Akanksha.Singh on 2/6/2018.
 */
public class CategoriesData {


    private String id;
    private String name;
    private List<ProductsData> products;
    private int view_count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductsData> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsData> products) {
        this.products = products;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }
}
