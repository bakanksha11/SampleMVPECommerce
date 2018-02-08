package com.example.akankshasingh.ecommerce.networking;


import com.example.akankshasingh.ecommerce.models.JsonData;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ennur on 6/25/16.
 */
public interface NetworkService {

    @GET("json")
    Observable<JsonData> getJsonData();

}
