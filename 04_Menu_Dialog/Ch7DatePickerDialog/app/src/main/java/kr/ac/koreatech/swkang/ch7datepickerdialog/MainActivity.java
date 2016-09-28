package kr.ac.koreatech.swkang.ch7datepickerdialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        TextView mT;

        public void setEditText(TextView et) {
            mT = et;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar cal = Calendar.getInstance();

            // DatePickerDialog 클래스의 생성자
            // DatePickerDialog(Context context, DatePickerDialog.OnDateSetListener listener, int year, int month, int dayOfMonth)
            // Creates a new date picker dialog for the specified date using the parent context's default date picker dialog theme.

            return new DatePickerDialog(getActivity(), this, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
        }

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mT.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
        }
    }

    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

        TextView mT;

        public void setEditText(TextView et) {
            mT = et;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar cal = Calendar.getInstance();

            // TimePickerDialog 클래스의 생성자
            // TimePickerDialog(Context context, TimePickerDialog.OnTimeSetListener listener, int hourOfDay, int minute, boolean is24HourView)
            // Creates a new time picker dialog.

            return new TimePickerDialog(getActivity(), this, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true);
        }

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int min) {
            mT.setText("Time: " + hourOfDay + ":" + min);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView editText = (TextView) findViewById(R.id.dateText);

                DatePickerFragment dpf = new DatePickerFragment();
                dpf.setEditText(editText);
                dpf.show(getFragmentManager(), "datePicker");
            }
        });

        Button bt2 = (Button) findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView timeText = (TextView) findViewById(R.id.timeText);

                TimePickerFragment dpf = new TimePickerFragment();
                dpf.setEditText(timeText);
                dpf.show(getFragmentManager(), "timePicker");
            }
        });
    }
}
