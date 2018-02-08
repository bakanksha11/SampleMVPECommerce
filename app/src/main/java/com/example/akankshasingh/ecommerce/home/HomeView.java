package com.example.akankshasingh.ecommerce.home;


import com.example.akankshasingh.ecommerce.models.JsonData;

/**
 * Created by ennur on 6/25/16.
 */
public interface HomeView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);
    void getJsonDataSuccess(JsonData jsonData);
}
