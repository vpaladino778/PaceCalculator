package io.github.vpaladino778.pacecalculator.ErgCalculation;

import android.widget.EditText;
import android.widget.TextView;

public class ErgTime {

    private EditText hoursText;
    private EditText minutesText;
    private EditText secondsText;

    private int hours;
    private int minutes;
    private double seconds;

    public ErgTime(EditText hoursText, EditText minutesText, EditText secondsText){
        this.hoursText = hoursText;
        this.minutesText = minutesText;
        this.secondsText = secondsText;
        reset();
    }


    public void setMinutes(int m){
        minutes = m;
        minutesText.setText(""+ m, TextView.BufferType.EDITABLE);
    }
    public int getMinutes(){
        minutes = Integer.getInteger(minutesText.getText().toString());
        return minutes;
    }

    public void setSeconds(Double s) {
        this.seconds = s;
        secondsText.setText(s.toString(), TextView.BufferType.EDITABLE);
    }

    public double getSeconds() {
        seconds = Double.parseDouble(secondsText.getText().toString());
        return seconds;
    }

    /**
     * Gets the number of hours
     * @return Number of hours
     */
    public int getHours(){
        hours = Integer.getInteger(hoursText.getText().toString());
        return hours;
    }

    public void setHours(int h) {
        this.hours = h;
        hoursText.setText("" + h,TextView.BufferType.EDITABLE);
    }

    //Returns total time in minutes
    public double getTotalTime(){
        double decimalSeconds = getSeconds()/60;
        //Rounds seconds to 2 decimal places
        decimalSeconds = (double) Math.round(decimalSeconds * 100) / 100;
        return (getMinutes() + (getHours() *60)+ decimalSeconds);
    }

    public void reset(){
        setHours(0);
        setMinutes(0);
        setSeconds(0.0);
    }

}
