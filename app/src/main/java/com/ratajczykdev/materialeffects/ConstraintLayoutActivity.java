package com.ratajczykdev.materialeffects;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Group;
import android.support.constraint.Placeholder;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ConstraintLayoutActivity extends AppCompatActivity
{

    private Spinner spinnerVisibilityChanger;
    private Group groupItems;
    private Placeholder placeholder;
    private Button buttonChangeContent;
    private ConstraintLayout constraintLayoutRoot;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

        setUiElementsReferences();

        configureSpinner();

        buttonChangeContent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                TransitionManager.beginDelayedTransition(constraintLayoutRoot);
                placeholder.setContentId(view.getId());
            }
        });
    }

    private void setUiElementsReferences()
    {
        constraintLayoutRoot = findViewById(R.id.constraint_layout_activity_root);
        groupItems = findViewById(R.id.constraint_layout_activity_items_group);
        spinnerVisibilityChanger = findViewById(R.id.constraint_layout_activity_visibility_spinner);
        buttonChangeContent = findViewById(R.id.constraint_layout_activity_change_content_button);
        placeholder = findViewById(R.id.placeholder_image_template_main_item);
    }

    private void configureSpinner()
    {
        setSpinnerAdapter();
        setSpinnerListener();
    }

    private void setSpinnerAdapter()
    {
        ArrayAdapter<CharSequence> spinnerArrayAdapter = ArrayAdapter.createFromResource(this, R.array.visibility_array, android.R.layout.simple_spinner_item);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVisibilityChanger.setAdapter(spinnerArrayAdapter);
    }

    private void setSpinnerListener()
    {
        spinnerVisibilityChanger.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedVisibilityString = parent.getItemAtPosition(position).toString();
                if (selectedVisibilityString.equals("VISIBLE"))
                {
                    groupItems.setVisibility(View.VISIBLE);
                } else if (selectedVisibilityString.equals("GONE"))
                {
                    groupItems.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                Toast.makeText(ConstraintLayoutActivity.this, "Nothing was chosen", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
