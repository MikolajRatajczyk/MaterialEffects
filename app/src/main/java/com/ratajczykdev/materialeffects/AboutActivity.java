package com.ratajczykdev.materialeffects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Mikołaj Ratajczyk <mikolaj.ratajczyk@gmail.com>
 */
public class AboutActivity extends AppCompatActivity
{
    private ImageView imageViewStar;
    private TextView textViewCreatedBy;
    private TextView textViewNameSurname;
    private TextView textViewEmail;
    private static final int EXPLODE_TRANSITION_DURATION_IN_MS = 1000;

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
    }
}
