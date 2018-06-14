package com.ratajczykdev.materialeffects;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * @author Mikołaj Ratajczyk <mikolaj.ratajczyk@gmail.com>
 */
public class SharedElementTransitionsFirstActivity extends AppCompatActivity
{
    private ImageView imageStork;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element_transitions_first);

        Toast.makeText(this, getString(R.string.toast_stork_is_clickable), Toast.LENGTH_SHORT).show();

        imageStork = findViewById(R.id.shared_elements_transitions_first_activity_stork_image);
        imageStork.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SharedElementTransitionsFirstActivity.this, SharedElementTransitionsSecondActivity.class);
                //  use default animation, specify shared element
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(SharedElementTransitionsFirstActivity.this, imageStork, imageStork.getTransitionName()).toBundle();
                startActivity(intent, bundle);
            }
        });
    }
}
