package com.example.akankshasingh.ecommerce.deps;


import com.example.akankshasingh.ecommerce.home.HomeActivity;
import com.example.akankshasingh.ecommerce.networking.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Akanksha.Singh on 2/6/2018.
 */
@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject(HomeActivity homeActivity);
}
