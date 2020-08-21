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

    public class Drawview extends View {

        Paint dot;
        public Paint line;
        public Paint box;
        Paint draw;
        Bitmap myBitmap;
        Canvas canvas;
        Path path;
        public MotionEvent motionEvent;
        ViewModel model;




        public Drawview(Context context) {
            super(context);
            init(null);


        }

        public Drawview(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
            init(attrs);
        }

        public Drawview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(attrs);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public Drawview(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
            init(attrs);
        }

        private void init(@Nullable AttributeSet set) {


            Resources resources = getResources();          //    java.lang.NullPointerException: Attempt to invoke virtual method 'long android.graphics.Paint.getNativeInstance()' on a null object reference
            dot = new Paint();                                  //    at android.graphics.Canvas.drawCircle(Canvas.java:1169)-- Paint object values must be defined in init() for all constructors
            dot.setFlags(Paint.ANTI_ALIAS_FLAG);
            dot.setStyle(Paint.Style.FILL);
            dot.setColor(Color.WHITE);
            line = new Paint();
            line.setStrokeWidth(7);
            box = new Paint();
            box.setStyle(Paint.Style.FILL);
            path = new Path();

            draw = new Paint();
            draw.setColor(Color.BLACK);
            draw.setStyle(Paint.Style.STROKE);
            draw.setStrokeWidth(10);



        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            myBitmap = createBitmap(w, h, Bitmap.Config.ARGB_8888);
            canvas = new Canvas(myBitmap);



        }

        @RequiresApi(api = Build.VERSION_CODES.M)


        @Override
        protected void onDraw(Canvas canvas) {

            canvas.drawBitmap(myBitmap, 0, 0, null);
            canvas.drawPath(path,draw);
        }

        @Override
        public boolean performClick() {
            return super.performClick();
        }


        //Drawing line
        public boolean onTouchEvent(MotionEvent event) {
            super.onTouchEvent(event);
            performClick();
            motionEvent=event;

            float pointX = event.getX();
            float pointY= event.getY();

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                path.moveTo(pointX,pointY);

            }
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                path.lineTo(pointX,pointY);

            }

            Fragmentclass.listener.onInputsent(event);
            Fragmentclass1.fragment1listener.onInput1sent(event);
            invalidate();

            return true;
        }

        public void pathEvent(MotionEvent event){


            float pointX = event.getX();
            float pointY= event.getY();

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                path.moveTo(pointX,pointY);

            }
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                path.lineTo(pointX,pointY);

            }


            invalidate();
        }
    }

}


