package com.ratajczykdev.materialeffects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * @author Mikołaj Ratajczyk <mikolaj.ratajczyk@gmail.com>
 */
public class ScenesActivity extends AppCompatActivity
{
    private ImageButton imageButtonInfo;
    private LinearLayout linearLayoutRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenes);

        linearLayoutRoot = findViewById(R.id.scenes_activity_root);

        //  for custom transition
        final Transition transition = TransitionInflater.from(ScenesActivity.this).inflateTransition(R.transition.transition_activity_scenes_default_to_detailed);

        imageButtonInfo = findViewById(R.id.scenes_activity_fox_info_imagebutton);
        imageButtonInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //  custom transition between scenes
                TransitionManager.go(Scene.getSceneForLayout(linearLayoutRoot, R.layout.activity_scenes_detailed, ScenesActivity.this),transition );
            }
        });

    }
}
