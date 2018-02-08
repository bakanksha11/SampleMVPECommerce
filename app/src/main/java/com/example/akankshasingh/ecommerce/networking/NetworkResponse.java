package com.example.akankshasingh.ecommerce.networking;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Akanksha.Singh on 2/6/2018.
 */
public class NetworkResponse {
    @SerializedName("status")
    public String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @SuppressWarnings({"unused", "used by Retrofit"})
    public NetworkResponse() {
    }

    public NetworkResponse(String status) {
        this.status = status;
    }
}
