package com.moshiurcse.classtest.shape_file_json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moshiurcse.classtest.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GeoJsonDataAdaptor extends RecyclerView.Adapter<GeoJsonDataAdaptor.GeoJsonDataViewHolder> {

    private Context context;
    private GeoJsonData dataList;

    public GeoJsonDataAdaptor(Context context, GeoJsonData dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public GeoJsonDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.data_raw,parent,false);
        return new GeoJsonDataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GeoJsonDataViewHolder holder, int position) {

        Properties aProperties=dataList.getFeatures().get(position).getProperties();

        //List<Properties> aProperties=dataList.setFeatures(dataList.getFeatures().get(position).getProperties()).;

        holder.magTV.setText(""+aProperties.getMag());
        holder.placeTV.setText(aProperties.getPlace());


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class GeoJsonDataViewHolder extends RecyclerView.ViewHolder {

        TextView magTV,placeTV;
        public GeoJsonDataViewHolder(@NonNull View itemView) {
            super(itemView);


            magTV=itemView.findViewById(R.id.row_mag_id);
            placeTV=itemView.findViewById(R.id.row_place_id);



        }
    }
}
