package com.example.administrator.android_dialogfragment_with_viewpager;

import android.app.assist.AssistStructure;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */

public class DialogFragmentWindow extends DialogFragment {

    private View[] btns;
    private int previousBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //full screen dialog fragment
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_viewpager, container);

        final ViewPager viewPager;
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        List fragments = getFragments();
        ViewpagerAdapter ama = new ViewpagerAdapter(getChildFragmentManager(), fragments);
        viewPager.setAdapter(ama);

        Window window = getDialog().getWindow();

        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, 700);
        window.setGravity(Gravity.BOTTOM);
        getDialog().setCanceledOnTouchOutside(true); //dismiss the dialog when pressing outside


        btns = new View[3];
        btns[0] = view.findViewById(R.id.Btn_tab_1);
        btns[1] = view.findViewById(R.id.Btn_tab_2);
        btns[2] = view.findViewById(R.id.Btn_tab_3);

        btns[0].setSelected(true);

        btns[0].setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   viewPager.setCurrentItem(0, true);
                   btns[previousBtn].setSelected(false);
                   btns[0].setSelected(true);
                   previousBtn = 0;
               }
           }
        );

        btns[1].setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   viewPager.setCurrentItem(1, true);
                   btns[previousBtn].setSelected(false);
                   btns[1].setSelected(true);
                   previousBtn = 1;
               }
           }
        );

        btns[2].setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   viewPager.setCurrentItem(2, true);
                   btns[previousBtn].setSelected(false);
                   btns[2].setSelected(true);
                   previousBtn = 2;
               }
           }
        );

        return view;
    }

    private List getFragments(){
        List fList = new ArrayList();
        fList.add(SampleFragment.newInstance("Fragment 1",1));
        fList.add(SampleFragment.newInstance("Fragment 2",2));
        fList.add(SampleFragment.newInstance("Fragment 3",3));
        return fList;
    }
}
