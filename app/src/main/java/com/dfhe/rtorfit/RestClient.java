package com.dfhe.rtorfit;

import com.dfhe.rtorfit.http.LoopBackService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名称：Rtorfit
 * 类描述：
 * 创建人：zgm
 * 创建时间：2016/3/30 11:31
 * 修改人：Administrator
 * 修改时间：2016/3/30 11:31
 * 修改备注：
 *
 * @param
 */
public class RestClient {
    private static LoopBackService service;
    public RestClient(){}

    public static LoopBackService getService(){

        if(null == service){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Config.POST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = retrofit.create(LoopBackService.class);
        }

        return  service;
    }
}
