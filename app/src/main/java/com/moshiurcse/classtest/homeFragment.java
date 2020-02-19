package com.moshiurcse.classtest;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.moshiurcse.classtest.shape_file_json.GeoJsonData;
import com.moshiurcse.classtest.shape_file_json.GeoJsonDataAdaptor;
import com.moshiurcse.classtest.shape_file_json.ServiceApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment {

    private final String BASE_URL="https://earthquake.usgs.gov/fdsnws/event/1/";
    private RecyclerView recyclerView;


    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.dataRV);

        String startDate=getArguments().getString("startDt");;
        String endDate=getArguments().getString("endDt");;

        Toast.makeText(getActivity(), "Show data from "+startDate+ " to "+endDate, Toast.LENGTH_SHORT).show();

/*        String endUrl = String.format("forecast/daily?lat=%f&lon=%f&cnt=16&units=%s&appid=%s",
                location.getLatitude(), location.getLongitude(), units, apiKey);*/

        String endUrl = String.format("query?format=geojson&starttime=%s&endtime=%s&minmagnitude=5", startDate, endDate);



        final Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        final ServiceApi serviceApi=retrofit.create(ServiceApi.class);

        serviceApi.getAllData(endUrl).enqueue(new Callback<GeoJsonData>() {
            @Override
            public void onResponse(Call<GeoJsonData> call, Response<GeoJsonData> response) {

                if(response.isSuccessful()){
                    GeoJsonData dataList=response.body();

                    //Log.e("flower","Respone"+flowerList.getType());

                    GeoJsonDataAdaptor adapter=new GeoJsonDataAdaptor(getActivity(),dataList);
                    LinearLayoutManager llm=new LinearLayoutManager(getActivity());


                    recyclerView.setLayoutManager(llm);
                    recyclerView.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<GeoJsonData> call, Throwable t) {

                Log.e("flower","Failer: "+t.getLocalizedMessage()+" Moshiur");
            }
        });


    }
}
