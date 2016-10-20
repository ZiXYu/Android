package com.example.administrator.android_custom_popupwindow;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 * Created by Administrator on 2016/10/14.
 */

public class ShowPopupWindow {

    public PopupWindow popupWindow;

    public ShowPopupWindow(Activity context){
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View popupView = layoutInflater.inflate(R.layout.popupwindow, null);
        popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        popupWindow.setOutsideTouchable(false); //The window will not dismiss when clicking outside

        Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
        btnDismiss.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                popupWindow.dismiss();
            }});
    }

    public void showPopup(View view){
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0); //Display in the center of the view
    }
}
