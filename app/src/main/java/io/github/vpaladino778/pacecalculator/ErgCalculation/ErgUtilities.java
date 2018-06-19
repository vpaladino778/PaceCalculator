package io.github.vpaladino778.pacecalculator.ErgCalculation;

/**
 * This class provides several static methods in order to calculate
 * the value of Distance/Split/Time using 2 of the other values
 */
public class ErgUtilities {

    public ErgUtilities(){};


    public static ErgDistance calculateDistance(ErgDistance distance, ErgSplit split, ErgTime time){

        double timeSeconds = time.getTotalTime() * 60 + time.getSeconds();
        double splitSeconds = split.getTotalSeconds();

        double totalDistance = ((timeSeconds/splitSeconds)) *500;

        distance.setMeters((int) totalDistance);
        return distance;
    }


    public static ErgSplit calculateSplit(ErgDistance distance, ErgSplit split, ErgTime time){
        double timeSeconds = time.getTotalTime() * 60 + time.getSeconds();
        double splitSeconds = 500 * (timeSeconds / distance.getMeters());
        split.setMinutes((int)Math.floor(splitSeconds/60));
        split.setSeconds(splitSeconds%60);
        return split;
    }

    public static ErgTime calculateTime(ErgDistance distance, ErgSplit split, ErgTime time){
        double totalTimeSeconds = split.getTotalSeconds() * (distance.getMeters()/500);
        int minutes = (int)Math.floor(totalTimeSeconds/60.0);
        time.setHours((int)Math.floor(minutes/60.0));
        time.setMinutes(minutes);
        time.setSeconds((double) totalTimeSeconds%60);
        return time;
    }

}

