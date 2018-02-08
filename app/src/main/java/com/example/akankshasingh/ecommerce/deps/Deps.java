package com.example.akankshasingh.ecommerce.deps;


import com.example.akankshasingh.ecommerce.home.HomeActivity;
import com.example.akankshasingh.ecommerce.networking.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ennur on 6/28/16.
 */
@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject(HomeActivity homeActivity);
}
