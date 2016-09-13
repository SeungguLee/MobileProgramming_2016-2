package kr.ac.koreatech.swkang.ch6buttoneventinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class MyListenerClass implements View.OnClickListener {
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "Button pressed!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        MyListenerClass buttonListener = new MyListenerClass();
        button.setOnClickListener(buttonListener);
    }
}
