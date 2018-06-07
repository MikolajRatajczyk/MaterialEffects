package com.ratajczykdev.materialeffects;

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

        buttonMotion = findViewById(R.id.activity_main_motion_button);
        buttonMotion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, MotionActivity.class);
                startActivity(intent);
            }
        });
    }
}
