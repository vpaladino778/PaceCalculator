package io.github.vpaladino778.pacecalculator.ErgCalculation;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ErgDistance {

    private EditText metersText;

    private int meters;


    public ErgDistance(final EditText metersText){
        this.metersText = metersText;
        reset();

        setMetersTextListener();
    }

    public void setMetersTextListener(){
        metersText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    int metersValue = Integer.parseInt(metersText.getText().toString());
                    meters = metersValue;
                } catch (NumberFormatException e) {
                    // Input is not an Integer
                    //TODO Error handling
                    //metersText.getText().clear();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /**
     * Sets the values of the meters and also
     * changes the Meter's edit text to reflect
     * @param m New Meters value
     */
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
