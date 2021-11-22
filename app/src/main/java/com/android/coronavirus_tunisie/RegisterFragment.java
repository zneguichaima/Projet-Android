package com.android.coronavirus_tunisie;


import android.app.Activity;
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
public class RegisterFragment extends Fragment {

    Button b1;
    EditText t1,t2,t3,t4;
    DataBaseHelper db;
    Activity context;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_register, container, false);
        View view= inflater.inflate(R.layout.fragment_register, container, false);
        db = new DataBaseHelper(getContext());
        b1 = (Button)   view.findViewById(R.id.btn_register);

        t1 = (EditText) view.findViewById(R.id.et_name);
        t2 = (EditText) view.findViewById(R.id.et_email);
        t3 = (EditText) view.findViewById(R.id.et_password);
        t4 = (EditText) view.findViewById(R.id.et_repassword);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = t2.getText().toString().trim();
                String pwd = t3.getText().toString().trim();
                String cnf_pwd = t4.getText().toString().trim();

                if(pwd.equals(cnf_pwd)){
                    long val = db.addUser(user,pwd);
                    if(val > 0){
                        Toast.makeText(context.getApplicationContext(),"You have registered",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(context,LoginFragment.class);
                        startActivity(moveToLogin);
                    }
                    else
                        Toast.makeText(context.getApplicationContext(),"Registeration Error",Toast.LENGTH_SHORT).show();


                }
                else
                    Toast.makeText(context.getApplicationContext(),"Password is not matching",Toast.LENGTH_SHORT).show();


            }
        });
        return view;
    }

}
