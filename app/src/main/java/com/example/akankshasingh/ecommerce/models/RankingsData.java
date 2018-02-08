package com.example.akankshasingh.ecommerce.models;

import java.util.List;

/**
 * Created by Akanksha.Singh on 1/29/2018.
 */

public class RankingsData {
    private String ranking;
    private List<ProductsData> products;

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public List<ProductsData> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsData> products) {
        this.products = products;
    }
}
