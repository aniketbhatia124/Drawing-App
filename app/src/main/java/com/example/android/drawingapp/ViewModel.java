package com.example.android.drawingapp;

import android.view.MotionEvent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {
    MutableLiveData<MotionEvent> points = new MutableLiveData<>();

    public void setevent(MotionEvent event){
        points.setValue(event);
    }

    public LiveData<MotionEvent> getEvent(){
        return points;
    }

}
