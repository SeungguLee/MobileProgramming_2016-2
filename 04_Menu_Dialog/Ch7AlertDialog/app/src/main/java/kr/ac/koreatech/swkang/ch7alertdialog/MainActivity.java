package kr.ac.koreatech.swkang.ch7alertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int DIALOG_YES_NO_MESSAGE = 1;
    private static final int DIALOG_COLOR_MESSAGE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_YES_NO_MESSAGE);
            }
        });

        Button radioBtn = (Button) findViewById(R.id.dialogForRadioButton);
        radioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_COLOR_MESSAGE);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_YES_NO_MESSAGE:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("종료 확인 대화 상자")
                        .setMessage("애플리케이션을 종료하시겠습니까?")
                        //.setPositiveButton("Yes", null)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        //.setNegativeButton("No", null);
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog alert = builder.create();
                return alert;

            case DIALOG_COLOR_MESSAGE:
                final CharSequence[] items = {"Red", "Green", "Blue"};

                AlertDialog.Builder builderRadio = new AlertDialog.Builder(this);
                builderRadio.setTitle("색상을 선택하시오")
                        .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int item) {
                                Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alertRadio = builderRadio.create();
                return alertRadio;
        }
        return null;
    }
}
