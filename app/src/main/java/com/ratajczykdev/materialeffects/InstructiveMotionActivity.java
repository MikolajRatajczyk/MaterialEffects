package com.ratajczykdev.materialeffects;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

public class InstructiveMotionActivity extends AppCompatActivity
{
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructive_motion);

        scrollView = findViewById(R.id.instructive_motion_activity_scroll_view);
    }

    @Override
    public void onEnterAnimationComplete()
    {
        //  when window transition ends
        super.onEnterAnimationComplete();
        final int startScrollPosition = getResources().getDimensionPixelSize(R.dimen.init_scroll_up_distance);
        //  animate scrollY property of the scrollView
        Animator animator = ObjectAnimator.ofInt(scrollView, "scrollY", startScrollPosition).setDuration(300);
        animator.start();
    }
}
