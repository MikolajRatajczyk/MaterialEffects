package com.ratajczykdev.materialeffects.coordinatedmotion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ratajczykdev.materialeffects.R;

public class CoordinatedMotionMenuActivity extends AppCompatActivity
{
    private Button buttonMovingCards;
    private Button buttonTransformingSurfaces;
    private Button buttonCurvedMotion;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinated_motion_menu);

        setUiButtonsReferences();
        setButtonsListeners();
    }

    private void setUiButtonsReferences()
    {
        buttonMovingCards = findViewById(R.id.coordinated_motion_menu_activity_moving_cards_button);
        buttonTransformingSurfaces = findViewById(R.id.coordinated_motion_menu_activity_surfaces_button);
        buttonCurvedMotion = findViewById(R.id.coordinated_motion_menu_activity_curved_motion_button);
    }

    private void setButtonsListeners()
    {
        buttonMovingCards.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CoordinatedMotionMenuActivity.this, MovingCardsActivity.class);
                startActivity(intent);
            }
        });


        buttonTransformingSurfaces.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CoordinatedMotionMenuActivity.this, TransformingSurfacesActivity.class);
                startActivity(intent);
            }
        });


        buttonCurvedMotion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CoordinatedMotionMenuActivity.this, CurvedMotionListActivity.class);
                startActivity(intent);
            }
        });
    }
}
