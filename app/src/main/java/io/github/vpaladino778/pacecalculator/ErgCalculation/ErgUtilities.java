package io.github.vpaladino778.pacecalculator.ErgCalculation;

/**
 * This class provides several static methods in order to calculate
 * the value of Distance/Split/Time using 2 of the other values
 */
public class ErgUtilities {

    public ErgUtilities(){};


    public static ErgDistance calculateDistance(ErgSplit split, ErgTime time){

        double timeSeconds = time.getTotalMinutes() * 60;
        double splitSeconds = (split.getMinutes() * 60) + split.getSeconds();

        double totalDistance = ((timeSeconds/splitSeconds)) *500;

        return new ErgDistance((int) Math.round(totalDistance) );

    }


    public static void main(String[] args){
        ErgSplit split = new ErgSplit(2,0);
        ErgTime time = new ErgTime(1,0,0);

        System.out.println(calculateDistance(split,time).getMeters());

    }
}

