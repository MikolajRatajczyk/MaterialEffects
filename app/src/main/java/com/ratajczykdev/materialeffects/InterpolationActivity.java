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
    private ArrayAdapter<CharSequence> arrayAdapterForInterpolatorsSpinner;
    private ArrayAdapter<CharSequence> arrayAdapterForDurationsSpinner;
    private Interpolator selectedInterpolator;
    private long selectedDuration;
    private final String LOG_TAG = InterpolationActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolation);

        setUiElementsReferences();

        configureSpinnerInterpolators();
        configureSpinnerDurations();
    }

    private void setUiElementsReferences()
    {
        spinnerInterpolators = findViewById(R.id.interpolation_activity_interpolators_spinner);
        spinnerDurations = findViewById(R.id.interpolation_activity_durations_spinner);
        textViewInterpolation = findViewById(R.id.interpolation_activity_interpolation_textview);
    }

    private void configureSpinnerInterpolators()
    {
        arrayAdapterForInterpolatorsSpinner = ArrayAdapter.createFromResource(this, R.array.interpolators_array, android.R.layout.simple_spinner_item);
        arrayAdapterForInterpolatorsSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerInterpolators.setAdapter(arrayAdapterForInterpolatorsSpinner);
        setSpinnerInterpolatorsListener();
    }

    private void setSpinnerInterpolatorsListener()
    {
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
    }

    void startTextViewAnimation()
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        textViewInterpolation.setTranslationY(displayMetrics.heightPixels);
        final int DEFAULT_ANIMATION_START_DELAY = 500;
        try
        {
            textViewInterpolation.animate().setInterpolator(selectedInterpolator)
                    .setDuration(selectedDuration)
                    .setStartDelay(DEFAULT_ANIMATION_START_DELAY)
                    .translationYBy(-displayMetrics.heightPixels)
                    .start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void configureSpinnerDurations()
    {
        final int DEFAULT_SPINNER_DURATIONS_SELECTION = 1;
        arrayAdapterForDurationsSpinner = ArrayAdapter.createFromResource(this, R.array.durations_array, android.R.layout.simple_spinner_item);
        arrayAdapterForDurationsSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerDurations.setAdapter(arrayAdapterForDurationsSpinner);
        spinnerDurations.setSelection(DEFAULT_SPINNER_DURATIONS_SELECTION);
        setSpinnerDurationsListener();
    }

    private void setSpinnerDurationsListener()
    {
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
        final String BASE_INTERPOLATOR_CLASS_PATH = "android.view.animation.";
        Interpolator interpolator = null;
        try
        {
            interpolator = (Interpolator) Class.forName(BASE_INTERPOLATOR_CLASS_PATH + name).newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e(LOG_TAG, "Can not create Interpolator for name: " + name);
        }
        return interpolator;
    }
}
