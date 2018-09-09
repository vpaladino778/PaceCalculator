package io.github.vpaladino778.pacecalculator;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.github.vpaladino778.pacecalculator.ErgCalculation.ErgDistance;
import io.github.vpaladino778.pacecalculator.ErgCalculation.ErgSplit;
import io.github.vpaladino778.pacecalculator.ErgCalculation.ErgTime;
import io.github.vpaladino778.pacecalculator.Fragments.SplitTimeDialogFragment;
import io.github.vpaladino778.pacecalculator.Fragments.TimeDialogFragment;

public class MainActivity extends AppCompatActivity implements SplitTimeDialogFragment.OnInputListener, TimeDialogFragment.OnInputListener{

    private EditText distanceText;
    private EditText splitText;
    private EditText timeText;


    private Button calcDistanceButton;
    private Button calcSplitButton;
    private Button calcTimeButton;
    private Button clearCalcButton;


    private ErgSplit ergSplit;
    private ErgTime ergTime;
    private ErgDistance ergDistance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews(); //Retrieve layout instances
    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.calc_distance_button:
                    break;
                case R.id.calc_split_button:
                    break;

                case R.id.calc_time_button:
                    break;

                case R.id.clear_calc_button:
                    clearCalculator();
                    break;
                case R.id.et_split:
                    showSplitDialog();
                    break;
                case R.id.et_time:
                    showTimeDialog();
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * Instantiates all member variables
     */
    public void getViews(){
        distanceText = (EditText) findViewById(R.id.et_distance);
        splitText = (EditText) findViewById(R.id.et_split);
        timeText = (EditText) findViewById(R.id.et_time);

        //Buttons
        calcDistanceButton = (Button) findViewById(R.id.calc_distance_button);
        calcSplitButton = (Button) findViewById(R.id.calc_split_button);
        calcTimeButton = (Button) findViewById(R.id.calc_time_button);
        clearCalcButton = (Button) findViewById(R.id.clear_calc_button);

        ergDistance = new ErgDistance(distanceText);
        ergSplit = new ErgSplit(splitText);
        ergTime = new ErgTime(timeText);

        //Attach clickListener
        calcDistanceButton.setOnClickListener(onClickListener);
        calcSplitButton.setOnClickListener(onClickListener);
        calcTimeButton.setOnClickListener(onClickListener);
        clearCalcButton.setOnClickListener(onClickListener);
        splitText.setOnClickListener(onClickListener);
        timeText.setOnClickListener(onClickListener);


    }

    public void calcDistance(){

    }

    public void showSplitDialog(){
        FragmentManager manager = getFragmentManager();
        String splitString = splitText.getText().toString();
        SplitTimeDialogFragment splitDialog = SplitTimeDialogFragment.newInstance("Enter Split:",splitString);
        splitDialog.show(manager,"SplitTimeDialogFragment");
    }

    public void showTimeDialog(){
        FragmentManager manager = getFragmentManager();
        String timeString = timeText.getText().toString();
        TimeDialogFragment timeDialog = TimeDialogFragment.newInstance("Enter Time:",timeString);
        timeDialog.show(manager,"timeDialogFragment");
    }

    public void clearCalculator(){
        ergDistance.reset();
        ergSplit.reset();
        ergTime.reset();
    }

    @Override
    public void sendSplit(String time) {
        ergSplit.parseTimeString(time);
    }

    @Override
    public void sendTime(String time) {
        ergTime.parseTimeString(time);
    }
}
