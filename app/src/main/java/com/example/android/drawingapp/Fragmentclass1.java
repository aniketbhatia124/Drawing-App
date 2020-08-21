package com.example.android.drawingapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class Fragmentclass1 extends Fragment {
    Drawview drawview;
    private ViewModel model;
    public interface fragment1listener{
        void onInput1sent(MotionEvent event);
    }
    static fragment1listener fragment1listener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.drawfragment,null);
        drawview= new Drawview(view.getContext());


//        drawview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                model.setevent(drawview.motionEvent);
//            }
//        });


        return view;
    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        model= new ViewModelProvider(getActivity()).get(ViewModel.class);
//        model.getEvent().observe(getViewLifecycleOwner(), new Observer<MotionEvent>() {
//            @Override
//            public void onChanged(MotionEvent event) {
//                drawview.onTouchEvent(event);
//            }
//        });
//
//    }

    public void updatefragment(MotionEvent newevent){
        drawview.pathEvent(newevent);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Fragmentclass1.fragment1listener){
            fragment1listener=(Fragmentclass1.fragment1listener)context;
        }
        else
            throw  new RuntimeException(context.toString()+ "must implement fragment1listener");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragment1listener= null;
    }

}

