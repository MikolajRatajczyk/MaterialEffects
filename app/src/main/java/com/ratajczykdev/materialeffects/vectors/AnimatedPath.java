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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_path);

        avdCrossToTick = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_cross_to_tick);
        if (avdCrossToTick != null)
        {
            avdCrossToTick.reset();
        }

        imageViewAnimatedItem = findViewById(R.id.animated_path_activity_animated_item_imageview);
        imageViewAnimatedItem.setImageDrawable(avdCrossToTick);
        imageViewAnimatedItem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                avdCrossToTick.start();
            }
        });

    }
}
