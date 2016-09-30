package kr.ac.koreatech.swkang.ch10activitypractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        //
        Intent intent = new Intent(this, MemoTextActivity.class);
        startActivity(intent);
    }
}
