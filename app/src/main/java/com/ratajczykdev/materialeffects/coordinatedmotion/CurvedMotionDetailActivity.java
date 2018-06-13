package com.ratajczykdev.materialeffects.coordinatedmotion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;

import com.ratajczykdev.materialeffects.R;

/**
 * @author Mikołaj Ratajczyk <mikolaj.ratajczyk@gmail.com>
 */
public class CurvedMotionDetailActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curved_motion_detail);

        Transition customTransition = TransitionInflater.from(this).inflateTransition(R.transition.transition_curve);
        //  load custom curve transition for shared element
        getWindow().setSharedElementEnterTransition(customTransition);
    }
}
