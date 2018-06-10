package com.ratajczykdev.materialeffects;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    private Button buttonButtons;
    private Button buttonConstraintLayout;
    private Button buttonMotion;
    private Button buttonScenes;
    private Button buttonContentTransitions;
    private Button buttonSharedElementTransitions;
    private Button buttonInstructiveMotion;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonButtons = findViewById(R.id.main_activity_buttons_button);
        buttonButtons.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, ButtonsActivity.class);
                startActivity(intent);
            }
        });

        buttonConstraintLayout = findViewById(R.id.main_activity_constraint_layout_button);
        buttonConstraintLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, ConstraintLayoutActivity.class);
                startActivity(intent);
            }
        });

        buttonMotion = findViewById(R.id.main_activity_motion_button);
        buttonMotion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, MotionActivity.class);
                startActivity(intent);
            }
        });

        buttonScenes = findViewById(R.id.main_activity_scenes_button);
        buttonScenes.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, ScenesActivity.class);
                startActivity(intent);
            }
        });

        buttonContentTransitions = findViewById(R.id.main_activity_content_transitions_button);
        buttonContentTransitions.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Intent intent = new Intent(MainActivity.this, ContentTransitionsActivity.class);
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle();
                //  alter call to start activity to use variant which takes bundle
                startActivity(intent, bundle);
            }
        });

        buttonSharedElementTransitions = findViewById(R.id.main_activity_shared_elements_transitions_button);
        buttonSharedElementTransitions.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, SharedElementTransitionsFirstActivity.class);
                startActivity(intent);
            }
        });

        buttonInstructiveMotion = findViewById(R.id.main_activity_instructive_motion_button);
        buttonInstructiveMotion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, InstructiveMotionActivity.class);
                startActivity(intent);
            }
        });
    }
}
