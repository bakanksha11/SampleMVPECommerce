package com.example.akankshasingh.ecommerce.networking;


import com.example.akankshasingh.ecommerce.models.JsonData;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Akanksha.Singh on 2/6/2018.
 */
public interface MyApiInterface {

    @GET("json")
    Observable<JsonData> getJsonData();

}
