package com.ratajczykdev.materialeffects.vectors;


import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.ratajczykdev.materialeffects.R;

public class AnimatedPath extends AppCompatActivity
{
    private ImageView imageViewAnimatedItem;
    private AnimatedVectorDrawable avdCrossToTick;
    private AnimatedVectorDrawable avdTickToCross;
    private boolean isTick;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_path);

        avdCrossToTick = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_cross_to_tick);
        avdTickToCross = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_tick_to_cross);

        resetAnimatedVectorDrawables();

        imageViewAnimatedItem = findViewById(R.id.animated_path_activity_animated_item_imageview);
        imageViewAnimatedItem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                animateAvd();
            }
        });

    }

    private void resetAnimatedVectorDrawables()
    {
        if (avdCrossToTick != null)
        {
            avdCrossToTick.reset();
        }
        if (avdTickToCross != null)
        {
            avdTickToCross.reset();
        }
    }

    private void animateAvd()
    {
        //  when activity starts for the first time this condition is always true
        if (!isTick)
        {
            imageViewAnimatedItem.setImageDrawable(avdCrossToTick);
            avdCrossToTick.start();
            isTick = true;
        } else if (isTick)
        {
            imageViewAnimatedItem.setImageDrawable(avdTickToCross);
            avdTickToCross.start();
            isTick = false;
        }
    }
}
