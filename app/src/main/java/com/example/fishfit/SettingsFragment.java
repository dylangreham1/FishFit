package com.example.fishfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SettingsFragment extends Fragment {

    public SettingsFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_fragment, container, false);

        Button notificationsbuffer = (Button) view.findViewById(R.id.notificationsbuffer);
        notificationsbuffer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent in = new Intent(getActivity(), NotificationActivity.class);
                in.putExtra("1", "Notifications Test");
                startActivity(in);
            }
        });

        Button resetbuffer = (Button) view.findViewById(R.id.resetbuffer);
        resetbuffer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent in = new Intent(getActivity(), ResetPasswordActivity.class);
                in.putExtra("2", "Password Resetter");
                startActivity(in);
            }
        });

        return view;
    }
}
