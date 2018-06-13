package com.ratajczykdev.materialeffects;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ratajczykdev.materialeffects.coordinatedmotion.CoordinatedMotionMenuActivity;
import com.ratajczykdev.materialeffects.vectors.AnimatedVectorDrawablesMenuActivity;

/**
 * @author Mikołaj Ratajczyk <mikolaj.ratajczyk@gmail.com>
 */
public class MainActivity extends AppCompatActivity
{

    private Button buttonButtons;
    private Button buttonConstraintLayout;
    private Button buttonMotion;
    private Button buttonScenes;
    private Button buttonContentTransitions;
    private Button buttonSharedElementTransitions;
    private Button buttonInstructiveMotion;
    private Button buttonInterpolation;
    private Button buttonCoordinatedMotion;
    private Button buttonVector;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setButtonsUiReferences();
        setButtonsListeners();
    }

    private void setButtonsUiReferences()
    {
        buttonButtons = findViewById(R.id.main_activity_buttons_button);
        buttonConstraintLayout = findViewById(R.id.main_activity_constraint_layout_button);
        buttonMotion = findViewById(R.id.main_activity_motion_button);
        buttonScenes = findViewById(R.id.main_activity_scenes_button);
        buttonContentTransitions = findViewById(R.id.main_activity_content_transitions_button);
        buttonSharedElementTransitions = findViewById(R.id.main_activity_shared_elements_transitions_button);
        buttonInstructiveMotion = findViewById(R.id.main_activity_instructive_motion_button);
        buttonInterpolation = findViewById(R.id.main_activity_interpolation_button);
        buttonCoordinatedMotion = findViewById(R.id.main_activity_coordinated_motion_button);
        buttonVector = findViewById(R.id.main_activity_vector_button);
    }

    private void setButtonsListeners()
    {
        buttonButtons.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, ButtonsActivity.class);
                startActivity(intent);
            }
        });

        buttonConstraintLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, ConstraintLayoutActivity.class);
                startActivity(intent);
            }
        });

        buttonMotion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, MotionActivity.class);
                startActivity(intent);
            }
        });

        buttonScenes.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, ScenesActivity.class);
                startActivity(intent);
            }
        });

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

        buttonSharedElementTransitions.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, SharedElementTransitionsFirstActivity.class);
                startActivity(intent);
            }
        });

        buttonInterpolation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, InterpolationActivity.class);
                startActivity(intent);
            }
        });

        buttonCoordinatedMotion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, CoordinatedMotionMenuActivity.class);
                startActivity(intent);
            }
        });

        buttonVector.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, AnimatedVectorDrawablesMenuActivity.class);
                startActivity(intent);
            }
        });

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
