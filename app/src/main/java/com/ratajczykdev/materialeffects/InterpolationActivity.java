package com.ratajczykdev.materialeffects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class InterpolationActivity extends AppCompatActivity
{
    private Spinner spinnerInterpolators;
    private Spinner spinnerDurations;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolation);

        ArrayAdapter<CharSequence> arrayAdapterForInterpolatorsSpinner = ArrayAdapter.createFromResource(this, R.array.interpolators_array, android.R.layout.simple_spinner_item);
        arrayAdapterForInterpolatorsSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInterpolators = findViewById(R.id.interpolation_activity_interpolators_spinner);
        spinnerInterpolators.setAdapter(arrayAdapterForInterpolatorsSpinner);

        ArrayAdapter<CharSequence> arrayAdapterForDurationsSpinner = ArrayAdapter.createFromResource(this, R.array.durations_array, android.R.layout.simple_spinner_item);
        arrayAdapterForDurationsSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDurations = findViewById(R.id.interpolation_activity_durations_spinner);
        spinnerDurations.setAdapter(arrayAdapterForDurationsSpinner);
    }
}
