package io.github.vpaladino778.pacecalculator.ErgCalculation;

public class ErgTime {


    private int minutes;
    private int seconds;

    public ErgTime(int hours, int minutes, int seconds){
        this.minutes = minutes;
        this.minutes += (hours * 60); //Convert hours to minutes
        this.seconds = seconds;
    }

    public ErgTime(int min, int sec){
        minutes = min;
        seconds = sec;
    }


    public int getMinutes() {
        return (minutes%60);
    }

    public int getSeconds() {
        return seconds;
    }

    /**
     *
     * @return Number of hours
     */
    public int getHours(){
        double hours = minutes/60;
        Double h = Math.floor(hours);
        return h.intValue();
    }

    //Returns total time in minutes
    public double getTotalMinutes(){
        double decimalSeconds = seconds/60;
        //Rounds seconds to 2 decimal places
        decimalSeconds = (double) Math.round(decimalSeconds * 100) / 100;
        return (minutes + decimalSeconds);
    }
}
