package com.gerosprime.gmoviedb.components.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDBApi {

    private String url;

    private Retrofit retrofit;

    public MovieDBApi(String url) {
        this.url = url;
    }

    private Retrofit getRetrofit() {

        if (retrofit == null) {

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd")
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }

    public String getUrl() {
        return url;
    }

    public <T> T use(Class<T> retrofitClass) {
        return getRetrofit().create(retrofitClass);
    }

}
