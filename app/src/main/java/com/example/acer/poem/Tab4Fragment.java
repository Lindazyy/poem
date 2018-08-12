package com.example.acer.poem;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Tab4Fragment extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab4_layout, container, false);
        ImageView iv = (ImageView) view.findViewById(R.id.fragment4imag);
        iv.setImageResource(R.drawable.user);

        LinearLayout MyWorks = view.findViewById(R.id.MyWorks);
        MyWorks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getActivity(), MyWorks.class);
                startActivity(intent);
            }
        });

        return view;
    }

}