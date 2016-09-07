package com.dou361.jjdxm_pay.module;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * ========================================
 * <p>
 * 版 权：dou361.com 版权所有 （C） 2015
 * <p>
 * 作 者：陈冠明
 * <p>
 * 个人网站：http://www.dou361.com
 * <p>
 * 版 本：1.0
 * <p>
 * 创建日期：2016/3/7
 * <p>
 * 描 述：具体的网络接口请求，分阻塞线程和异步线程
 * <p>
 * <p>
 * 修订历史：
 * <p>
 * ========================================
 */
public class ApiServiceUtils {

    public static void getWinChatBean(retrofit2.Callback<String> cb) {
        OkHttpClient client = new OkHttpClient
                .Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://wxpay.weixin.qq.com")
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService mApiServicePresenter = retrofit.create(ApiService.class);
        Call<String> call = mApiServicePresenter.live("android");
        call.enqueue(cb);
//        try {
//            response = call.execute();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
    }

}