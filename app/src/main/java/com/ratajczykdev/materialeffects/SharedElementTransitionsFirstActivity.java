package com.ratajczykdev.materialeffects;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class SharedElementTransitionsFirstActivity extends AppCompatActivity
{
    private ImageButton imageButtonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element_transitions_first);

        imageButtonInfo = findViewById(R.id.shared_elements_transitions_first_activity_info_imagebutton);
        imageButtonInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SharedElementTransitionsFirstActivity.this, SharedElementTransitionsSecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
