package com.ratajczykdev.materialeffects;

import android.os.Bundle;
import android.support.constraint.Group;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ConstraintLayoutActivity extends AppCompatActivity
{

    private Spinner spinnerVisibilityChanger;
    private Group groupItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

        groupItems = findViewById(R.id.constraint_layout_activity_items_group);

        spinnerVisibilityChanger = findViewById(R.id.constraint_layout_activity_visibility_spinner);
        spinnerVisibilityChanger.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedVisibilityString = parent.getItemAtPosition(position).toString();
                if (selectedVisibilityString.equals("VISIBLE"))
                {
                    groupItems.setVisibility(View.VISIBLE);
                } else if (selectedVisibilityString.equals("INVISIBLE"))
                {
                    groupItems.setVisibility(View.INVISIBLE);
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
        ArrayAdapter<CharSequence> spinnerArrayAdapter = ArrayAdapter.createFromResource(this, R.array.visibility_array, android.R.layout.simple_spinner_item);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVisibilityChanger.setAdapter(spinnerArrayAdapter);


    }
}
