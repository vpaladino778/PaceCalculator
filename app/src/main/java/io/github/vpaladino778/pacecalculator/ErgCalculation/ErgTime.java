package io.github.vpaladino778.pacecalculator.ErgCalculation;

public class ErgTime {


    private int minutes;
    private double seconds;

    public ErgTime(int hours, int minutes, double seconds){
        this.minutes = minutes;
        this.minutes += (hours * 60); //Convert hours to minutes
        this.seconds = seconds;
    }

    public ErgTime(int min, double sec){
        minutes = min;
        seconds = sec;
    }


    public int getMinutes() {
        return (minutes%60);
    }

    public double getSeconds() {
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
    public double getTotalTime(){
        double decimalSeconds = seconds/60;
        //Rounds seconds to 2 decimal places
        decimalSeconds = (double) Math.round(decimalSeconds * 100) / 100;
        return (minutes + decimalSeconds);
    }
}
