package com.ratajczykdev.materialeffects.coordinatedmotion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

import com.ratajczykdev.materialeffects.R;

public class MovingCardsActivity extends AppCompatActivity
{
    private LinearLayout linearLayoutCardsRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving_cards);

        linearLayoutCardsRoot = findViewById(R.id.moving_cards_activity_cards_root_view);
        linearLayoutCardsRoot.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                animateCards();
            }
        });

        animateCards();
    }

    private void animateCards()
    {
        float cardOffsetY = getResources().getDimensionPixelSize(R.dimen.moving_cards_activity_card_offset_y);
        Interpolator cardInterpolator = AnimationUtils.loadInterpolator(this, android.R.interpolator.linear_out_slow_in);

        final float CARD_START_OPACITY = 0.85f;
        final float CARD_FINAL_OPACITY = 1f;
        final float CARD_FINAL_Y_AXIS_VALUE = 0f;
        final long CARD_ANIMATION_DURATION_MS = 1000L;
        final float CARD_OFFSET_MULTIPLIER = 1.5f;
        final int CARDS_COUNT = linearLayoutCardsRoot.getChildCount();

        for (int position = 0; position < CARDS_COUNT; position++)
        {
            View card = linearLayoutCardsRoot.getChildAt(position);
            card.setVisibility(View.VISIBLE);
            card.setTranslationY(cardOffsetY);
            //  change card opacity
            card.setAlpha(CARD_START_OPACITY);

            card.animate()
                    .translationY(CARD_FINAL_Y_AXIS_VALUE)
                    .alpha(CARD_FINAL_OPACITY)
                    .setInterpolator(cardInterpolator)
                    .setDuration(CARD_ANIMATION_DURATION_MS)
                    .start();

            cardOffsetY *= CARD_OFFSET_MULTIPLIER;
        }
    }
}
