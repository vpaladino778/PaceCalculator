package io.github.vpaladino778.pacecalculator.ErgCalculation;

import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ErgTime {

    private EditText timeText;

    private int hours;
    private int minutes;
    private double seconds;

    public ErgTime(EditText timeText){
        this.timeText = timeText;
        reset();
    }


    public boolean parseTimeString(String timeString){
        String[] timeSplit = timeString.split(":"); // Splits (timeSplit[0]) minutes from seconds (timeSplit[1])
        //String[] secondsDecimal = timeSplit[2].split("\\."); //Splits 00.0 into 2 separate numbers
        if(timeSplit.length > 3 )
            return false;

        try {
            setHours(Integer.parseInt(timeSplit[0].trim()));
            setMinutes(Integer.parseInt(timeSplit[1]));
            setSeconds(Double.parseDouble(timeSplit[2]));
        }catch(NumberFormatException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public void updateTimeText(){
        DecimalFormat df = new DecimalFormat("00.0");

        StringBuilder timeTextBuilder = new StringBuilder();
        timeTextBuilder.append(getHours())
                .append(':')
                .append(String.format("%02d", getMinutes()))
                .append(':')
                .append(df.format(getSeconds()));
        timeText.setText(timeTextBuilder.toString());
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

    public void setMinutes(int m){
        minutes = m;
        updateTimeText();
    }
    public int getMinutes(){
        return minutes;
    }

    public void setSeconds(Double s) {
        this.seconds = s;
        updateTimeText();
    }

    public double getSeconds() {
        return seconds;
    }
    public int getHours(){
        return hours;
    }

    public void setHours(int h) {
        this.hours = h;
        updateTimeText();
    }

}
