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

        getViews(); //Retrieve layout instances
    }

    /**
     * Instantiates all member variables
     */
    public void getViews(){
        distanceText = (EditText) findViewById(R.id.et_distance);
        splitMinutesText = (EditText) findViewById(R.id.split_minutes);
        splitSecondsText = (EditText) findViewById(R.id.split_seconds);
        timeHoursText = (EditText) findViewById(R.id.time_hours);
        timeMinutesText = (EditText) findViewById(R.id.time_minutes);
        timeSecondsText = (EditText) findViewById(R.id.time_seconds);

        //Buttons
        calcDistanceButton = (Button) findViewById(R.id.calc_distance_button);
        calcSplitButton = (Button) findViewById(R.id.calc_split_button);
        calcTimeButton = (Button) findViewById(R.id.calc_time_button);
        clearCalcButton = (Button) findViewById(R.id.clear_calc_button);
    }
}
