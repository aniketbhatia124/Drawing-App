package com.example.android.drawingapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import static android.graphics.Bitmap.createBitmap;


public class Fragmentclass extends Fragment {

    static fragmentlistener listener;
   Drawview drawview;
   public interface fragmentlistener{
       void onInputsent(MotionEvent event);
   }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        drawview= new Drawview(getContext());


        return drawview;
    }

    public void updatefragment(MotionEvent newevent){
    drawview.pathEvent(newevent);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof fragmentlistener){
            listener=(fragmentlistener)context;
        }
        else
            throw new RuntimeException(context.toString()+ "must implement fragmentlistener");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener= null;
    }



}


