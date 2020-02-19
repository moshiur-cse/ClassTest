package com.moshiurcse.classtest;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class GetDateFragment extends Fragment {

    private Button getDateBtn;
    private EditText startDate,endDate;


    public GetDateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_get_date, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        startDate=view.findViewById(R.id.startDateET);
        endDate=view.findViewById(R.id.endDateET);
        getDateBtn=view.findViewById(R.id.getDateBtn);


        getDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startDt=startDate.getText().toString();
                String endDt=endDate.getText().toString();

                Bundle bundle=new Bundle();
                bundle.putString("startDt",startDt);
                bundle.putString("endDt",endDt);
                Navigation.findNavController(v).navigate(R.id.action_getDateFragment_to_homeFragment,bundle);



            }
        });
    }
}
