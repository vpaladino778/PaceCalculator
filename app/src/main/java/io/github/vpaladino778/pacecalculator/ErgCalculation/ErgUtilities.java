package io.github.vpaladino778.pacecalculator.ErgCalculation;

/**
 * This class provides several static methods in order to calculate
 * the value of Distance/Split/Time using 2 of the other values
 */
public class ErgUtilities {

    public ErgUtilities(){};


    /**
     * Calculates the number of meters rowed from the split and time
     * @param split 500m split to calculate
     * @param time Total time to use for calculating
     * @return Total meters
     */
    public static ErgDistance calculateDistance(ErgSplit split, ErgTime time){

        double timeSeconds = time.getTotalTime() * 60 + time.getSeconds();
        double splitSeconds = split.getTotalSeconds();

        double totalDistance = ((timeSeconds/splitSeconds)) *500;

        return new ErgDistance((int) Math.round(totalDistance) );

    }

    public static ErgDistance calculateDistance(ErgTime time, ErgSplit split){
        return calculateDistance(split,time);
    }

    public static ErgSplit calculateSplit(ErgDistance distance, ErgTime time){
        double timeSeconds = time.getTotalTime() * 60 + time.getSeconds();
        double split = 500 * (timeSeconds / distance.getMeters());
        return new ErgSplit((int)Math.floor(split/60),split%60);
    }
    public static ErgSplit calculateSplit(ErgTime time, ErgDistance distance){
        return calculateSplit(distance,time);
    }

    public static ErgTime calculateTime(ErgDistance distance, ErgSplit split){
        double totalTimeSeconds = split.getTotalSeconds() * (distance.getMeters()/500);
        ErgTime totalTime = new ErgTime((int)Math.floor(totalTimeSeconds/60.0),(double) totalTimeSeconds%60);
        return totalTime;
    }

    public static void main(String[] args){
        ErgSplit split = new ErgSplit(2,15.39);
        ErgTime time = new ErgTime(45,20);

        System.out.println(calculateDistance(split,time).getMeters());

    }
}

