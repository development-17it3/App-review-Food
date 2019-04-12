package com.app.user.reviewfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar PB ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PB = (ProgressBar) findViewById(R.id.PB);
        PB.setMax(100);
        PB.setProgress(0);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++){
                        PB.setProgress(i);
                        sleep(200);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(getApplicationContext(),Main1Activity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }
}
