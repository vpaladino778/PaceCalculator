package io.github.vpaladino778.pacecalculator;

import org.junit.Test;

import io.github.vpaladino778.pacecalculator.ErgCalculation.ErgSplit;
import io.github.vpaladino778.pacecalculator.ErgCalculation.ErgTime;
import io.github.vpaladino778.pacecalculator.ErgCalculation.ErgUtilities;

import static junit.framework.Assert.assertEquals;

public class ErgCalculationUnitTest {


    @Test
    public void CalcDistance_isCorrect(){
        ErgTime ergTime = new ErgTime(60,0);
        ErgSplit ergSplit = new ErgSplit(2,0);

        assertEquals(ErgUtilities.calculateDistance(ergSplit,ergTime), 15000);
    }
}
