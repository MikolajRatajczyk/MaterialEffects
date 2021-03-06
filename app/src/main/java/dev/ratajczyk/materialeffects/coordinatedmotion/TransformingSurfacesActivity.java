package dev.ratajczyk.materialeffects.coordinatedmotion;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;

import dev.ratajczyk.materialeffects.R;


/**
 * @author Mikołaj Ratajczyk <mikolaj.ratajczyk@gmail.com>
 */
public class TransformingSurfacesActivity extends AppCompatActivity {

    private static final long SHORT_ANIMATION_TIME_IN_MS = 300L;
    private static final long LONG_ANIMATION_TIME_IN_MS = 600L;
    private CardView cardViewSurface;
    private Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transforming_surfaces);

        cardViewSurface = findViewById(R.id.transforming_surfaces_activity_surface_cardview);
        cardViewSurface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increaseCardSizeWithAnimation();
            }
        });

        buttonReset = findViewById(R.id.transforming_surfaces_activity_reset_button);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetSurfaceDimensions();
            }
        });
    }

    private void increaseCardSizeWithAnimation() {
        Interpolator interpolator = AnimationUtils.loadInterpolator(this, android.R.interpolator.bounce);
        final float SCALES_MULTIPLIER = 1.5f;

        ObjectAnimator objectAnimatorScaleX = ObjectAnimator.ofFloat(cardViewSurface, View.SCALE_X, SCALES_MULTIPLIER * cardViewSurface.getScaleX());
        objectAnimatorScaleX.setInterpolator(interpolator);
        objectAnimatorScaleX.setDuration(SHORT_ANIMATION_TIME_IN_MS);

        ObjectAnimator objectAnimatorScaleY = ObjectAnimator.ofFloat(cardViewSurface, View.SCALE_Y, SCALES_MULTIPLIER * cardViewSurface.getScaleY());
        objectAnimatorScaleY.setInterpolator(interpolator);
        objectAnimatorScaleY.setDuration(LONG_ANIMATION_TIME_IN_MS);

        objectAnimatorScaleX.start();
        objectAnimatorScaleY.start();
    }

    private void resetSurfaceDimensions() {
        Interpolator interpolator = AnimationUtils.loadInterpolator(this, android.R.interpolator.overshoot);

        final float INITIAL_SCALE = 1f;

        ObjectAnimator objectAnimatorScaleX = ObjectAnimator.ofFloat(cardViewSurface, View.SCALE_X, INITIAL_SCALE);
        objectAnimatorScaleX.setInterpolator(interpolator);
        objectAnimatorScaleX.setDuration(SHORT_ANIMATION_TIME_IN_MS);

        ObjectAnimator objectAnimatorScaleY = ObjectAnimator.ofFloat(cardViewSurface, View.SCALE_Y, INITIAL_SCALE);
        objectAnimatorScaleY.setInterpolator(interpolator);
        objectAnimatorScaleY.setDuration(LONG_ANIMATION_TIME_IN_MS);

        objectAnimatorScaleX.start();
        objectAnimatorScaleY.start();
    }
}
