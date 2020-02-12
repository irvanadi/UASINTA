package com.xeylyne.uasinta;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIPackage {

    @GET("pl_getPlace.php")
    Call<ReqAPI> request();

    @FormUrlEncoded
    @POST("clustering")
    Call<ClusteringRespond> CLUSTERING_RESPOND_CALL(@Field("region") String region,
                                                    @Field("item") String item);

    @FormUrlEncoded
    @POST("estimation")
    Call<EstimationRespond> ESTIMATION_RESPOND_CALL(@Field("item") String item);

}
