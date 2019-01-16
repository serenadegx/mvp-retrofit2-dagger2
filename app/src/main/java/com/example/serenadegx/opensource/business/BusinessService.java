package com.example.serenadegx.opensource.business;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface BusinessService {
    @POST("mdd-papp-web/base/web/login")
    Call<BusinessResult> getBusiness(@HeaderMap Map<String, String> headers, @Body BusinessParams params);
}
