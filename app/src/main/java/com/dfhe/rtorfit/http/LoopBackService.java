package com.dfhe.rtorfit.http;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 项目名称：Rtorfit
 * 类描述：
 * 创建人：zgm
 * 创建时间：2016/3/30 11:21
 * 修改人：Administrator
 * 修改时间：2016/3/30 11:21
 * 修改备注：
 *
 * @param
 */
public interface LoopBackService {
    @GET("index")
    Call<UserInfo> getResponse(@Query("cityname") String cityname,@Query("key") String key);
}
