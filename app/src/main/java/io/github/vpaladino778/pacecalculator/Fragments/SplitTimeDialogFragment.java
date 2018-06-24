package io.github.vpaladino778.pacecalculator.Fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import java.util.zip.Inflater;

import io.github.vpaladino778.pacecalculator.R;

public class SplitTimeDialogFragment extends DialogFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.split_picker_dialog,null);
        setCancelable(true);
        getDialog().setTitle(R.string.split_dialog_title);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        NumberPicker minutePicker = (NumberPicker) view.findViewById(R.id.np_split_minutes);
        minutePicker.setMinValue(1);
        minutePicker.setMaxValue(9);

        NumberPicker secondTensPicker = (NumberPicker) view.findViewById(R.id.np_split_seconds_tens);
        NumberPicker secondOnesPicker = (NumberPicker) view.findViewById(R.id.np_split_seconds_ones);
        secondTensPicker.setMinValue(0);
        secondTensPicker.setMaxValue(9);

        secondOnesPicker.setMinValue(0);
        secondOnesPicker.setMaxValue(9);
    }
}
