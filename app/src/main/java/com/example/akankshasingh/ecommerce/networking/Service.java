package com.example.akankshasingh.ecommerce.networking;

import com.example.akankshasingh.ecommerce.models.JsonData;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Akanksha.Singh on 2/6/2018.
 */
public class Service {
    private final MyApiInterface myApiInterface;

    Service(MyApiInterface myApiInterface) {
        this.myApiInterface = myApiInterface;
    }

    public Subscription getJsonData(final GetJsonDataCallback callback) {

        return myApiInterface.getJsonData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends JsonData>>() {
                    @Override
                    public Observable<? extends JsonData> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<JsonData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(JsonData jsonData) {
                        callback.onSuccess(jsonData);

                    }
                });
    }

    public interface GetJsonDataCallback{
        void onSuccess(JsonData jsonData);

        void onError(NetworkError networkError);
    }

}
