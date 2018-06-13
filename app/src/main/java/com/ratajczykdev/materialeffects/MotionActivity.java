package com.ratajczykdev.materialeffects;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.transition.Slide;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class MotionActivity extends AppCompatActivity
{
    private Button buttonSlide;
    private Button buttonReset;
    private ConstraintLayout constraintLayoutRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion);

        setUiElementsReferences();

        setButtonSlideListener();   // here is animation
        setButtonResetListener();
    }

    private void setUiElementsReferences()
    {
        constraintLayoutRoot = findViewById(R.id.activity_motion_root);
        buttonSlide = findViewById(R.id.motion_activity_slide_button);
        buttonReset = findViewById(R.id.motion_activity_reset_button);
    }

    private void setButtonSlideListener()
    {
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

    private void setButtonResetListener()
    {
        buttonReset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                buttonSlide.setVisibility(View.VISIBLE);

                Slide slide = new Slide();
                slide.setSlideEdge(Gravity.BOTTOM);

                TransitionManager.beginDelayedTransition(constraintLayoutRoot, slide);
            }
        });
    }


}
