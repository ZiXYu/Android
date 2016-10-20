package com.example.administrator.android_custom_popupwindow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    private Button popupwindowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
    }

    private void initViews() {
        popupwindowButton = (Button) findViewById(R.id.popupwindow);
        popupwindowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow(v);
            }
        });

    }

    private void initData() {

    }

    private void showPopupWindow(View view) {
        ShowPopupWindow showPopupWindow = new ShowPopupWindow(MainActivity.this);
        showPopupWindow.showPopup(view);
    }
}
