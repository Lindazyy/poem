package com.example.acer.poem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class Tab2Fragment extends android.support.v4.app.Fragment {
    //The interface to introduce history

    private List <Fragment> catalog; //the list to introduce
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_layout, container, false);
        view.setBackgroundResource(R.drawable.tab2_background_resource);

        return view;
    }

}