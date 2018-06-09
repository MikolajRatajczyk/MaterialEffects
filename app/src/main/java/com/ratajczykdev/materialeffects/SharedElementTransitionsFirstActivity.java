package com.ratajczykdev.materialeffects;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class SharedElementTransitionsFirstActivity extends AppCompatActivity
{
    private ImageView imageStork;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element_transitions_first);

        Toast.makeText(this, "The stork is clickable", Toast.LENGTH_SHORT).show();


        imageStork = findViewById(R.id.shared_elements_transitions_first_activity_stork_image);

        //  use default animation, specify shared element
        final Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this, imageStork, imageStork.getTransitionName()).toBundle();

        imageStork.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SharedElementTransitionsFirstActivity.this, SharedElementTransitionsSecondActivity.class);
                startActivity(intent, bundle);
            }
        });
    }
}
