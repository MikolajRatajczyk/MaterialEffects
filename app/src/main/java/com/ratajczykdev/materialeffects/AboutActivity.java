package com.ratajczykdev.materialeffects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Mikołaj Ratajczyk <mikolaj.ratajczyk@gmail.com>
 */
public class AboutActivity extends AppCompatActivity
{
    private static final int EXPLODE_TRANSITION_DURATION_IN_MS = 1000;
    private ImageView imageViewStar;
    private TextView textViewCreatedBy;
    private TextView textViewNameSurname;
    private TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        imageViewStar = findViewById(R.id.about_activity_star_imageview);
        textViewCreatedBy = findViewById(R.id.about_activity_created_by_textview);
        textViewNameSurname = findViewById(R.id.about_activity_name_surname_textview);
        textViewEmail = findViewById(R.id.about_activity_email_textview);

        //  create whole content transition animation from code (not XML)
        Explode explode = new Explode();
        explode.setDuration(EXPLODE_TRANSITION_DURATION_IN_MS);
        explode.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.interpolator.fast_out_slow_in));
        explode.addTarget(imageViewStar);
        explode.addTarget(textViewCreatedBy);
        explode.addTarget(textViewNameSurname);
        explode.addTarget(textViewEmail);
        getWindow().setEnterTransition(explode);

        setEasterEgg();
    }

    private void setEasterEgg()
    {
        final int FULL_ROTATION_IN_DEGREES = 360;
        final int ROTATION_ANIMATION_DURATION_IN_MS = 5000;
        imageViewStar.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View view)
            {
                imageViewStar.animate()
                        .rotation(imageViewStar.getRotation() + FULL_ROTATION_IN_DEGREES)
                        .setInterpolator(AnimationUtils.loadInterpolator(AboutActivity.this, android.R.interpolator.bounce))
                        .setDuration(ROTATION_ANIMATION_DURATION_IN_MS)
                        .start();
                return true;
            }
        });
    }
}
