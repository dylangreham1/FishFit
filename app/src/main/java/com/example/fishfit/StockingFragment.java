package com.example.fishfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class StockingFragment extends Fragment {

    public StockingFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stocking_fragment, container, false);

        Button fragmentbuffer1 = (Button) view.findViewById(R.id.fragmentbuffer1);
        fragmentbuffer1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent in = new Intent(getActivity(), MainActivity2.class);
                in.putExtra("-", "Photo Uploader");
                startActivity(in);
            }
        });
        return view;
    }
}
