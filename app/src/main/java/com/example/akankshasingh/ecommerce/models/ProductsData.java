package com.example.akankshasingh.ecommerce.models;

import java.util.List;

/**
 * Created by Akanksha.Singh on 2/6/2018.
 */
public class ProductsData {

    private int id;
    private String name;
    private String date_added;
    private List<VariantsData> variants;
    private String order_count;
    private String view_count;
    private String shares;

    public String getOrder_count() {
        return order_count;
    }

    public void setOrder_count(String order_count) {
        this.order_count = order_count;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }

    public String getView_count() {
        return view_count;
    }

    public void setView_count(String view_count) {
        this.view_count = view_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public List<VariantsData> getVariants() {
        return variants;
    }

    public void setVariants(List<VariantsData> variants) {
        this.variants = variants;
    }
}
