package io.github.vpaladino778.pacecalculator.ErgCalculation;

import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Represents the users 500m split time.
 * Allows for conversion from ErgSplit to ErgTime and ErgDistance
 */
public class ErgSplit {

    private EditText splitText;

    private int minutes;
    private double seconds;

    public ErgSplit(EditText splitText){
        this.splitText = splitText;
        reset();
    }

    /**
     * Parses a time string into an ErgSplit object
     * @return True if string was parsed correctly, false if there was an error
     */
    public boolean parseTimeString(String timeString){
        String[] timeSplit = timeString.split(":"); // Splits (timeSplit[0]) minutes from seconds (timeSplit[1])
        if(timeSplit.length > 2)
            return false;

        try {
            setMinutes(Integer.parseInt(timeSplit[0]));
            setSeconds(Double.parseDouble(timeSplit[1]));
        }catch(NumberFormatException e){
            e.printStackTrace();
            return false;
        }
    return true;
    }

    public double getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    /**
     * Sets seconds text of EditText
     * @param s Seconds value
     */
    public void setSeconds(Double s){
        seconds = s;
        updateSplitText();
    }

    /**
     * Sets minutes of EditText and updates minutes
     * @param m Minutes value
     */
    public void setMinutes(int m){
        minutes = m;
        updateSplitText();
    }

    public void updateSplitText(){
        DecimalFormat df = new DecimalFormat("00.0");
        splitText.setText(getMinutes() + ":" + df.format(getSeconds()));
    }
    public double getTotalSeconds(){
        return (getMinutes() * 60) + getSeconds();
    }

    public void reset(){
        setMinutes(1);
        setSeconds(00.0);
        updateSplitText();
    }
}
