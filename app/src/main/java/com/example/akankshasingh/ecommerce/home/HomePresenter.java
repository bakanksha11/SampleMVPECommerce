package com.example.akankshasingh.ecommerce.home;


import com.example.akankshasingh.ecommerce.models.JsonData;
import com.example.akankshasingh.ecommerce.networking.NetworkError;
import com.example.akankshasingh.ecommerce.networking.Service;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ennur on 6/25/16.
 */
public class HomePresenter {
    private final Service service;
    private final HomeView view;
    private CompositeSubscription subscriptions;

    HomePresenter(Service service, HomeView view) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    void getJsonList() {
        view.showWait();

        Subscription subscription = service.getJsonData(new Service.GetJsonDataCallback() {
            @Override
            public void onSuccess(JsonData jsonData) {
                view.removeWait();
                view.getJsonDataSuccess(jsonData);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }

        });

        subscriptions.add(subscription);
    }

    public void onStop() {
        subscriptions.unsubscribe();
    }
}
