package com.example.akankshasingh.ecommerce.models;

import java.util.List;

/**
 * Created by Akanksha.Singh on 2/6/2018.
 */
public class JsonData {

    private List<CategoriesData> categories;
    private List<RankingsData> rankings;

    public List<CategoriesData> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesData> categories) {
        this.categories = categories;
    }

    public List<RankingsData> getRankings() {
        return rankings;
    }

    public void setRankings(List<RankingsData> rankings) {
        this.rankings = rankings;
    }
}
