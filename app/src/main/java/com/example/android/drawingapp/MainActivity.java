package com.example.android.drawingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Fragmentclass.fragmentlistener,Fragmentclass1.fragment1listener {

    Fragmentclass fragmentclass;
    Fragmentclass1 fragmentclass1;

    Button resetbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentclass = new Fragmentclass();
        fragmentclass1 = new Fragmentclass1();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentcontainer,fragmentclass).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentcontainer1,fragmentclass1).commit();

        resetbtn= findViewById(R.id.reset);
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSupportFragmentManager().beginTransaction().detach(fragmentclass).commit();
                getSupportFragmentManager().beginTransaction().detach(fragmentclass1).commit();
                fragmentclass = new Fragmentclass();
                fragmentclass1 = new Fragmentclass1();
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentcontainer,fragmentclass).commit();
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentcontainer1,fragmentclass1).commit();


            }
        });


    }

    @Override
    public void onInputsent(MotionEvent event) {
        fragmentclass1.updatefragment(event);
    }

    @Override
    public void onInput1sent(MotionEvent event) {
        fragmentclass.updatefragment(event);
    }
}
