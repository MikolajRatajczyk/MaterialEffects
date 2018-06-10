package com.ratajczykdev.materialeffects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class InterpolationActivity extends AppCompatActivity
{
    private Spinner spinnerInterpolators;
    private Spinner spinnerDurations;
    private String selectedInterpolator;
    private String selectedDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolation);

        ArrayAdapter<CharSequence> arrayAdapterForInterpolatorsSpinner = ArrayAdapter.createFromResource(this, R.array.interpolators_array, android.R.layout.simple_spinner_item);
        arrayAdapterForInterpolatorsSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInterpolators = findViewById(R.id.interpolation_activity_interpolators_spinner);
        spinnerInterpolators.setAdapter(arrayAdapterForInterpolatorsSpinner);
        spinnerInterpolators.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                String selectionString = adapterView.getItemAtPosition(position).toString();
                //  TODO: delete
                Toast.makeText(InterpolationActivity.this, selectionString, Toast.LENGTH_SHORT).show();
                //  TODO: finish
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

        ArrayAdapter<CharSequence> arrayAdapterForDurationsSpinner = ArrayAdapter.createFromResource(this, R.array.durations_array, android.R.layout.simple_spinner_item);
        arrayAdapterForDurationsSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDurations = findViewById(R.id.interpolation_activity_durations_spinner);
        spinnerDurations.setAdapter(arrayAdapterForDurationsSpinner);
        spinnerDurations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                String selectionString = adapterView.getItemAtPosition(position).toString();
                //  use regular expression to get only number from spinner selection
                selectedDuration = selectionString.replaceAll("[^0-9]", "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
    }
}
