package com.example.acer.poem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Tab3Fragment extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3_layout, container, false);
        ImageView iv = (ImageView) view.findViewById(R.id.fragment3imag);
        iv.setImageResource(R.drawable.write);

        return view;
    }

}