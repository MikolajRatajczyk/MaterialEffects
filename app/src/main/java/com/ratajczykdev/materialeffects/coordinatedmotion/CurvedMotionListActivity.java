package com.ratajczykdev.materialeffects.coordinatedmotion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.ratajczykdev.materialeffects.R;

public class CurvedMotionListActivity extends AppCompatActivity
{
    private FrameLayout frameLayoutItemRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curved_motion_list);

        frameLayoutItemRoot = findViewById(R.id.curved_motion_activity_item_root);
        frameLayoutItemRoot.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CurvedMotionListActivity.this, CurvedMotionDetailActivity.class);
                startActivity(intent);
            }
        });
    }
}
