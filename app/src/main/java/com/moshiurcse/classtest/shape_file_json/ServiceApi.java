package com.moshiurcse.classtest.shape_file_json;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("query?format=geojson&starttime=2020-02-01&endtime=2020-02-13&minmagnitude=5")
    Call<GeoJsonData> getAllData();
}
