package io.github.vpaladino778.pacecalculator.ErgCalculation;

/**
 * Represents the users 500m split time.
 * Allows for conversion from ErgSplit to ErgTime and ErgDistance
 */
public class ErgSplit {

    private int minutes;
    private double seconds;

    public ErgSplit(int minutes, double seconds){
        this.minutes = minutes;
        this.seconds = seconds;

    }

    public double getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public double getTotalSeconds(){
        return (minutes * 60) + seconds;
    }
}
