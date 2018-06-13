package io.github.vpaladino778.pacecalculator;

import org.junit.Test;

import io.github.vpaladino778.pacecalculator.ErgCalculation.ErgDistance;
import io.github.vpaladino778.pacecalculator.ErgCalculation.ErgSplit;
import io.github.vpaladino778.pacecalculator.ErgCalculation.ErgTime;
import io.github.vpaladino778.pacecalculator.ErgCalculation.ErgUtilities;

import static junit.framework.Assert.assertEquals;

public class ErgCalculationUnitTest {


    @Test
    public void CalcDistance_isCorrect(){
        ErgTime ergTime = new ErgTime(60,0);
        ErgSplit ergSplit = new ErgSplit(2,0);

        assertEquals(ErgUtilities.calculateDistance(ergSplit,ergTime).getMeters(), 15000);
    }

    @Test
    public void CalcSplit_isCorrect(){
        ErgTime ergTime = new ErgTime(60,0);
        ErgDistance distance = new ErgDistance(15000);

        ErgSplit split = ErgUtilities.calculateSplit(distance,ergTime);
        assertEquals(split.getMinutes(),2);
        assertEquals(split.getSeconds(),0.0);
    }

    @Test
    public void CalcTime_isCorrect(){
        ErgDistance distance = new ErgDistance(15000);
        ErgSplit split = new ErgSplit(2,0.0);

        ErgTime time = ErgUtilities.calculateTime(distance,split);

        assertEquals(time.getTotalTime(), 60.0);
    }
}
