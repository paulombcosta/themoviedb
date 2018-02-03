package io.paulocosta.themoviedb.data.remote;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class AuthInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        final Request original = chain.request();
        final HttpUrl originalUrl = original.url();

        final HttpUrl url = originalUrl
                .newBuilder()
                .addQueryParameter("api_key", Endpoint.AUTH_KEY)
                .build();

        final Request request = original.newBuilder()
                .url(url)
                .build();

        return chain.proceed(request);
    }

}
