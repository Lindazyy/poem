package com.example.acer.poem;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Button;

public class Tab3Fragment extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3_layout, container, false);
        ImageView iv = (ImageView) view.findViewById(R.id.fragment3imag);
        iv.setImageResource(R.drawable.write);

        Button WriteTest = (Button) view.findViewById(R.id.btn_WriteTest);
        WriteTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getActivity(), WriteEdit.class);
                startActivity(intent);
            }
        });
        return view;
    }

}