package io.github.vpaladino778.pacecalculator.ErgCalculation;

import android.widget.EditText;
import android.widget.TextView;

public class ErgDistance {

    private EditText metersText;

    private int meters;

    public ErgDistance(EditText metersText){
        this.metersText = metersText;
        reset();
    }

    public void setMeters(int m){
        metersText.setText("" + m, TextView.BufferType.EDITABLE);
        meters = m;
    }

    public int getMeters() {
        return meters;
    }

    public void reset(){
        setMeters(0);
    }
}
