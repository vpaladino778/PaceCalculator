package io.github.vpaladino778.pacecalculator.ErgCalculation;

import android.widget.EditText;
import android.widget.TextView;

/**
 * Represents the users 500m split time.
 * Allows for conversion from ErgSplit to ErgTime and ErgDistance
 */
public class ErgSplit {

    private EditText minutesText;
    private EditText secondsText;

    private int minutes;
    private double seconds;

    public ErgSplit(EditText minutesText, EditText secondsText){
        this.minutesText = minutesText;
        this.secondsText = secondsText;
        reset();
    }

    public double getSeconds() {
        seconds = Double.parseDouble(secondsText.getText().toString());
        return seconds;
    }

    public int getMinutes() {
        minutes = Integer.getInteger(minutesText.getText().toString());
        return minutes;
    }

    /**
     * Sets seconds text of EditText
     * @param s Seconds value
     */
    public void setSeconds(Double s){
        secondsText.setText(s.toString(), TextView.BufferType.EDITABLE);
        seconds = s;
    }

    /**
     * Sets minutes of EditText and updates minutes
     * @param m Minutes value
     */
    public void setMinutes(int m){
        minutesText.setText("" + m,TextView.BufferType.EDITABLE);
        minutes = m;
    }

    public double getTotalSeconds(){
        return (getMinutes() * 60) + getSeconds();
    }

    public void reset(){
        setMinutes(0);
        setSeconds(0.0);
    }
}
