package com.example.acer.poem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Tab4Fragment extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab4_layout, container, false);
        ImageView iv = (ImageView) view.findViewById(R.id.fragment4imag);
        iv.setImageResource(R.drawable.user);

        return view;
    }

}