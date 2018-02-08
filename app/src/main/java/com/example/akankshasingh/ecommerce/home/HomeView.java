package com.example.akankshasingh.ecommerce.home;


import com.example.akankshasingh.ecommerce.models.JsonData;

/**
 * Created by Akanksha.Singh on 2/5/2018.
 */
public interface HomeView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);
    void getJsonDataSuccess(JsonData jsonData);
}
