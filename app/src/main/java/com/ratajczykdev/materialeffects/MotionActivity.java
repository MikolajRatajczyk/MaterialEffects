package com.ratajczykdev.materialeffects;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.transition.Slide;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

//  TODO: make enter MotionActivity animation
public class MotionActivity extends AppCompatActivity
{
    private Button buttonSlide;
    private ConstraintLayout constraintLayoutRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion);

        constraintLayoutRoot = findViewById(R.id.activity_motion_root);

        buttonSlide = findViewById(R.id.motion_activity_slide_button);
        buttonSlide.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Slide slide = new Slide();
                slide.setSlideEdge(Gravity.TOP);

                TransitionManager.beginDelayedTransition(constraintLayoutRoot, slide);
                buttonSlide.setVisibility(View.INVISIBLE);

            }
        });
    }
}
