package io.github.vpaladino778.pacecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText distanceText;
    private EditText splitMinutesText;
    private EditText splitSecondsText;
    private EditText timeHoursText;
    private EditText timeMinutesText;
    private EditText timeSecondsText;

    private Button calcDistanceButton;
    private Button calcSplitButton;
    private Button calcTimeButton;
    private Button clearCalcButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
