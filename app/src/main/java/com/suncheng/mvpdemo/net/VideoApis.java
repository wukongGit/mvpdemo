package com.suncheng.mvpdemo.net;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by suncheng on 2016/11/15.
 */
public interface VideoApis {
    String HOST = "http://api.svipmovie.com/front/";

    @GET("homePageApi/homePage.do")
    Observable<VideoHttpResponse<VideoRes>> getHomePage();
}
