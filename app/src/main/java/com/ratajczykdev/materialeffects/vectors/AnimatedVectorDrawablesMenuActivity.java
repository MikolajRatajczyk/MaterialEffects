package com.ratajczykdev.materialeffects.vectors;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ratajczykdev.materialeffects.R;

public class AnimatedVectorDrawablesMenuActivity extends AppCompatActivity
{

    private Button buttonPath;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_vector_drawables_menu);

        buttonPath = findViewById(R.id.animated_vector_drawables_menu_activity_path_button);
        buttonPath.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AnimatedVectorDrawablesMenuActivity.this, AnimatedPathActivity.class);
                startActivity(intent);
            }
        });
    }
}
