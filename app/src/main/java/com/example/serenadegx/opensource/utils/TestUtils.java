package com.example.serenadegx.opensource.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestUtils {

    private String json;

    public TestUtils(String json) {
        this.json = json;
    }

    public void setPath(String path) {
        this.json = path;
    }

    public <T> T create(Class<T> clazz) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new MockInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.10.10.205:7109/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(clazz);
    }

    public Retrofit create() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new MockInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.10.10.205:7109/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    private class MockInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            // 模拟网络数据
            ResponseBody body = ResponseBody.create(MediaType.parse("application/x-www-form-urlencoded"), json);

            Response response = new Response.Builder().request(chain.request())
                    .protocol(Protocol.HTTP_1_1)
                    .code(200)
                    .body(body)
                    .message("success")
                    .build();
            return response;
        }
    }
}
