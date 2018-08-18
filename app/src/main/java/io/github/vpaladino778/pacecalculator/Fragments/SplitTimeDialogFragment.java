package io.github.vpaladino778.pacecalculator.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import io.github.vpaladino778.pacecalculator.R;

public class SplitTimeDialogFragment extends DialogFragment {

    public interface OnInputListener {
        void sendInput(String time);
    }

    public OnInputListener mOnInputListener;


    //Picker Values
    NumberPicker minutePicker;
    NumberPicker secondsPicker;
    NumberPicker decimalPicker;

    public static SplitTimeDialogFragment newInstance(String title) {
        SplitTimeDialogFragment splitFrag = new SplitTimeDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("timeString","2:00.0");
        splitFrag.setArguments(args);
        return splitFrag;
    }
    public static SplitTimeDialogFragment newInstance(String title, String timeString) {
        SplitTimeDialogFragment splitFrag = new SplitTimeDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("timeString",timeString);
        splitFrag.setArguments(args);
        return splitFrag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater factory = LayoutInflater.from(getActivity());
        int int1;
        ViewGroup parent; // android.view.ViewGroup
        View dialogView = factory.inflate(R.layout.split_picker_dialog, null);
        builder.setTitle(R.string.split_dialog_title)
                .setView(dialogView)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mOnInputListener.sendInput(getTimeString());
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                    }
                });

        Dialog dialog = builder.create();
        String timeString = getArguments().getString("timeString");
        onDialogCreated(dialogView);
        setValue(timeString);
        return dialog;
    }


    /**
     * Sets minimum and maximum values for split selection
     *
     * @param view
     */
    public void onDialogCreated(View view) {
        minutePicker = (NumberPicker) view.findViewById(R.id.np_split_minutes);
        minutePicker.setMinValue(1);
        minutePicker.setMaxValue(9);

        NumberPicker.Formatter formatter = new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return String.format("%02d", value);
            }
        };
        secondsPicker = (NumberPicker) view.findViewById(R.id.np_split_seconds);
        secondsPicker.setMinValue(0);
        secondsPicker.setMaxValue(59);
        secondsPicker.setFormatter(formatter);

        decimalPicker = (NumberPicker) view.findViewById(R.id.np_split_decimal);
        decimalPicker.setMinValue(0);
        decimalPicker.setMaxValue(9);
    }


    /**
     * Gets the time value from the number pickers and returns it as a string
     * @return M:SS.S Formated time string
     */
    public String getTimeString(){
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(minutePicker.getValue())
                .append(':')
                .append(secondsPicker.getValue())
                .append('.')
                .append(decimalPicker.getValue());
        return sBuilder.toString();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mOnInputListener = (OnInputListener) getActivity();
        } catch (ClassCastException e) {
            Log.e("SplitTimeDialogFragment", "onAttach ClassCastException: " + e.getMessage());
        }
    }

    /**
     * Sets the numberpickers to the specified values
     * @param timeString 0:00.0 formatted time value
     */
    public boolean setValue(String timeString){
        String[] timeSplit = timeString.split(":"); // Splits (timeSplit[0]) minutes from seconds (timeSplit[1])
        String[] secondsDecimal = timeSplit[1].split("\\."); //Splits 00.0 into 2 separate numbers
        if(timeSplit.length > 2 )
            return false;

        try {
            minutePicker.setValue(Integer.parseInt(timeSplit[0]));
            secondsPicker.setValue(Integer.parseInt(secondsDecimal[0]));
            decimalPicker.setValue(Integer.parseInt(secondsDecimal[1]));
        }catch(NumberFormatException e){
            e.printStackTrace();
            return false;
        }
    return true;
    }

    public void setMinutePicker(int min){
        minutePicker.setValue(min);
    }
    public void setSecondsPicker(int sec){
        secondsPicker.setValue(sec);
    }
    public void setDecimalPicker(int dec){
        decimalPicker.setValue(dec);
    }
}
