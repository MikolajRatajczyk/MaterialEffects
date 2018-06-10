package com.ratajczykdev.materialeffects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class InterpolationActivity extends AppCompatActivity
{
    private Spinner spinnerInterpolators;
    private Spinner spinnerDurations;
    private TextView textViewInterpolation;
    private Interpolator selectedInterpolator;
    private long selectedDuration;
    private final String LOG_TAG = InterpolationActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolation);

        textViewInterpolation = findViewById(R.id.interpolation_activity_interpolation_textview);

        ArrayAdapter<CharSequence> arrayAdapterForInterpolatorsSpinner = ArrayAdapter.createFromResource(this, R.array.interpolators_array, android.R.layout.simple_spinner_item);
        arrayAdapterForInterpolatorsSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInterpolators = findViewById(R.id.interpolation_activity_interpolators_spinner);
        spinnerInterpolators.setAdapter(arrayAdapterForInterpolatorsSpinner);
        spinnerInterpolators.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                String selectedInterpolatorName = adapterView.getItemAtPosition(position).toString();
                selectedInterpolator = createInterpolatorForName(selectedInterpolatorName);
                if (selectedInterpolator != null && selectedDuration > 0)
                {
                    startTextViewAnimation();
                }

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
        spinnerDurations.setSelection(1);
        spinnerDurations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                String selectionString = adapterView.getItemAtPosition(position).toString();
                //  use regular expression to get only number from spinner selection
                String selectionStringOnlyNumbers = selectionString.replaceAll("[^0-9]", "");
                selectedDuration = Long.valueOf(selectionStringOnlyNumbers);
                if (selectedInterpolator != null && selectedDuration > 0)
                {
                    startTextViewAnimation();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
    }

    Interpolator createInterpolatorForName(String name)
    {
        Interpolator interpolator = null;
        try
        {
            interpolator = (Interpolator) Class.forName("android.view.animation." + name).newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e(LOG_TAG, "Can not create Interpolator for name: " + name);
        }
        return interpolator;
    }

    void startTextViewAnimation()
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        textViewInterpolation.setTranslationY(displayMetrics.heightPixels);
        try
        {
            textViewInterpolation.animate().setInterpolator(selectedInterpolator)
                    .setDuration(selectedDuration)
                    .setStartDelay(500)
                    .translationYBy(-displayMetrics.heightPixels)
                    .start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
