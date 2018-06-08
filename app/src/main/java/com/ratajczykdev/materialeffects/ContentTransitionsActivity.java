package com.ratajczykdev.materialeffects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.animation.AnimationUtils;

public class ContentTransitionsActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_transitions);

        //  create whole animation from code (not XML)
        Slide slide = new Slide(Gravity.BOTTOM);
        slide.addTarget(R.id.content_transitions_activity_title_textview);
        slide.addTarget(R.id.content_transitions_activity_description_textview);
        slide.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.interpolator.linear_out_slow_in));
        slide.setDuration(300);
        getWindow().setEnterTransition(slide);
    }
}
