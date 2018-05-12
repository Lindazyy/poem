package com.example.acer.poem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Tab1Fragment extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.tab1_layout, container,false);
        ImageView iv = (ImageView) view.findViewById(R.id.fragment1imag);
        iv.setImageResource(R.drawable.home);

        return view;
    }




}
