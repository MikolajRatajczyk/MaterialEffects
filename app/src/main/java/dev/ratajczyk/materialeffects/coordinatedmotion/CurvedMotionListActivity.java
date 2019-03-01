package dev.ratajczyk.materialeffects.coordinatedmotion;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import dev.ratajczyk.materialeffects.R;


/**
 * @author Mikołaj Ratajczyk <mikolaj.ratajczyk@gmail.com>
 */
public class CurvedMotionListActivity extends AppCompatActivity {
    private FrameLayout frameLayoutItemRoot;
    private View viewAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curved_motion_list);

        viewAvatar = findViewById(R.id.curved_motion_list_activity_avatar_view);

        frameLayoutItemRoot = findViewById(R.id.curved_motion_list_activity_item_root);
        frameLayoutItemRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CurvedMotionListActivity.this, CurvedMotionDetailActivity.class);
                //  use default animation, specify shared element
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(CurvedMotionListActivity.this, viewAvatar, viewAvatar.getTransitionName()).toBundle();
                startActivity(intent, bundle);
            }
        });
    }
}
