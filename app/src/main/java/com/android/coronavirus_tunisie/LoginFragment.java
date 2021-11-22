package com.android.coronavirus_tunisie;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import database.DataBaseHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    Button b1;
    EditText t1,t2;
    Activity context;
    DataBaseHelper db;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false);
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        b1 = (Button)   view.findViewById(R.id.bt);
        t1 = (EditText) view.findViewById(R.id.t1);
        t2 = (EditText) view.findViewById(R.id.t2);

        db = new DataBaseHelper(getContext());


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = t1.getText().toString().trim();
                String pwd = t2.getText().toString().trim();
                Boolean res = db.checkUser(user, pwd);
                if(res == true)
                {
                    Toast.makeText(context.getApplicationContext(), "Successfully Logged In", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(context,BottomActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                else
                {
                    Toast.makeText(context.getApplicationContext(), "Login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}
