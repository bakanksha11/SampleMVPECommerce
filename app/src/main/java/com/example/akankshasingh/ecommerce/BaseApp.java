package com.example.akankshasingh.ecommerce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.akankshasingh.ecommerce.deps.DaggerDeps;
import com.example.akankshasingh.ecommerce.deps.Deps;
import com.example.akankshasingh.ecommerce.networking.NetworkModule;

import java.io.File;

/**
 * Created by ennur on 6/28/16.
 */
public class BaseApp  extends AppCompatActivity{
    Deps deps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        deps = DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();

    }

    public Deps getDeps() {
        return deps;
    }
}
