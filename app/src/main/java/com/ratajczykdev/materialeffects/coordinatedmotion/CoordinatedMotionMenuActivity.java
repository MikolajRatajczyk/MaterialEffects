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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinated_motion_menu);

        buttonMovingCards = findViewById(R.id.coordinated_motion_menu_activity_moving_cards_button);
        buttonMovingCards.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CoordinatedMotionMenuActivity.this, MovingCardsActivity.class);
                startActivity(intent);
            }
        });

        buttonTransformingSurfaces = findViewById(R.id.coordinated_motion_menu_activity_surfaces_button);
        buttonTransformingSurfaces.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CoordinatedMotionMenuActivity.this, TransformingSurfacesActivity.class);
                startActivity(intent);
            }
        });
    }
}
