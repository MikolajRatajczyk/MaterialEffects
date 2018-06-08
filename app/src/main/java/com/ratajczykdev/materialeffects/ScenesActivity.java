package com.ratajczykdev.materialeffects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

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

        imageButtonInfo = findViewById(R.id.scenes_activity_fox_info_imagebutton);
        imageButtonInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //  default transition
                TransitionManager.go(Scene.getSceneForLayout(linearLayoutRoot, R.layout.activity_scenes_detailed, ScenesActivity.this));
            }
        });

    }
}
