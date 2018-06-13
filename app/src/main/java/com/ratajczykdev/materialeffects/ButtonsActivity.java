package com.ratajczykdev.materialeffects;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;

/**
 * @author Mikołaj Ratajczyk <mikolaj.ratajczyk@gmail.com>
 */
public class ButtonsActivity extends AppCompatActivity
{
    private Button buttonReveal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        buttonReveal = findViewById(R.id.buttons_activity_reveal_button);
        buttonReveal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int buttonCenterX = view.getWidth() / 2;
                int buttonCenterY = view.getHeight() / 2;
                float startRadius = 0;
                float endRadius = (float) Math.hypot(buttonCenterX, buttonCenterY);

                Animator animator = ViewAnimationUtils.createCircularReveal(view, buttonCenterX, buttonCenterY, startRadius, endRadius);

                view.setBackgroundColor(getColor(R.color.colorAccent));
                animator.start();
            }
        });
    }
}
