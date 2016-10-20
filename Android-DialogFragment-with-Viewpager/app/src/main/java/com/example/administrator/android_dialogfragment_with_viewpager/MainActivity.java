package com.example.administrator.android_dialogfragment_with_viewpager;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        Button button = (Button) findViewById(R.id.dialog);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DialogFragmentWindow().show(getSupportFragmentManager(), "");
            }
        });

    }
}