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

public class TimeDialogFragment extends DialogFragment{

    public interface OnInputListener {
        void sendTime(String time);
    }

    public TimeDialogFragment.OnInputListener mOnInputListener;


    //Picker Values
    private NumberPicker hourPicker;
    private NumberPicker minutePicker;
    private NumberPicker secondsPicker;
    private NumberPicker decimalPicker;

    public static TimeDialogFragment newInstance(String title) {
        TimeDialogFragment splitFrag = new TimeDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("timeString","0:02:00.0");
        splitFrag.setArguments(args);
        return splitFrag;
    }
    public static TimeDialogFragment newInstance(String title, String timeString) {
        TimeDialogFragment splitFrag = new TimeDialogFragment();
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
        View dialogView = factory.inflate(R.layout.time_picker_dialog, null);
        builder.setTitle(R.string.time_dialog_title)
                .setView(dialogView)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mOnInputListener.sendTime(getTimeString());
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mOnInputListener = (TimeDialogFragment.OnInputListener) getActivity();
        } catch (ClassCastException e) {
            Log.e("TimeDialogFragment", "onAttach ClassCastException: " + e.getMessage());
        }
    }

    /**
     * Sets minimum and maximum values for split selection
     *
     * @param view
     */
    public void onDialogCreated(View view) {
        hourPicker = (NumberPicker) view.findViewById(R.id.np_time_hours);
        hourPicker.setMinValue(0);
        hourPicker.setMaxValue(99);

        NumberPicker.Formatter formatter = new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return String.format("%02d", value);
            }
        };

        minutePicker = (NumberPicker) view.findViewById(R.id.np_time_minutes);
        minutePicker.setMinValue(0);
        minutePicker.setMaxValue(59);
        minutePicker.setFormatter(formatter);

        secondsPicker = (NumberPicker) view.findViewById(R.id.np_time_seconds);
        secondsPicker.setMinValue(0);
        secondsPicker.setMaxValue(59);
        secondsPicker.setFormatter(formatter);

        decimalPicker = (NumberPicker) view.findViewById(R.id.np_time_decimal);
        decimalPicker.setMinValue(0);
        decimalPicker.setMaxValue(9);
    }

    /**
     * Sets the numberpickers to the specified values
     * @param timeString 00:00:00.0 formatted time value
     */
    public boolean setValue(String timeString){
        String[] timeSplit = timeString.split(":"); // Splits (timeSplit[0]) minutes from seconds (timeSplit[1])
        String[] secondsDecimal = timeSplit[2].split("\\."); //Splits 00.0 into 2 separate numbers
        if(timeSplit.length > 3 )
            return false;

        try {
            hourPicker.setValue(Integer.parseInt(timeSplit[0].trim()));
            minutePicker.setValue(Integer.parseInt(timeSplit[1]));
            secondsPicker.setValue(Integer.parseInt(secondsDecimal[0]));
            decimalPicker.setValue(Integer.parseInt(secondsDecimal[1].trim()));
        }catch(NumberFormatException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Gets the time value from the number pickers and returns it as a string
     * @return HH:MM:SS.S Formated time string
     */
    public String getTimeString(){
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(hourPicker.getValue())
                .append(':')
                .append(minutePicker.getValue())
                .append(':')
                .append(secondsPicker.getValue())
                .append('.')
                .append(decimalPicker.getValue());
        return sBuilder.toString();
    }
}
