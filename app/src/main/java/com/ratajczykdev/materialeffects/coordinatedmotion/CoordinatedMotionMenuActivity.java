package com.ratajczykdev.materialeffects.coordinatedmotion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ratajczykdev.materialeffects.R;

public class CoordinatedMotionMenuActivity extends AppCompatActivity
{
    private Button movingCardsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinated_motion_menu);

        movingCardsButton = findViewById(R.id.coordinated_motion_activity_moving_cards_button);
        movingCardsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CoordinatedMotionMenuActivity.this, MovingCardsActivity.class);
                startActivity(intent);
            }
        });
    }
}
