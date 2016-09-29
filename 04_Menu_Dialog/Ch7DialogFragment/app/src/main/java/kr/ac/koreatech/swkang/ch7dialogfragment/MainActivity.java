package kr.ac.koreatech.swkang.ch7dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static class ButtonDialogFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("종료 확인 대화 상자")
                    .setMessage("애플리케이션을 종료하시겠습니까?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getActivity().finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //dialog.dismiss();
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button);

        // 버튼을 클릭했을 때 대화상자를 표시하도록 처리
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 위에서 정의한 ButtonDialogFragment 클래스의 객체를 생성
                DialogFragment myFragment = new ButtonDialogFragment();

                // show 메소드 호출을 통하여 대화상자가 화면에 표시되도록 함
                myFragment.show(getFragmentManager(), "FinishDialog");

                // FragmentManager: public abstract class
                // android.app.FragmentManager
                // Interface for interacting with Fragment objects inside of an Activity
            }
        });
    }
}
