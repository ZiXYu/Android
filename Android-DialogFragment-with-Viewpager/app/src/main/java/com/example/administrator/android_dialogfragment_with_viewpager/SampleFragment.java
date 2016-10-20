package com.example.administrator.android_dialogfragment_with_viewpager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SampleFragment extends Fragment{

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private int item;
    private String urlString = "";
    int i = 0;

    public static final SampleFragment newInstance(String message,int item)
    {
        SampleFragment fragment = new SampleFragment();
        Bundle bdl = new Bundle(item);
        fragment.item = item;
        bdl.putString(EXTRA_MESSAGE, message);
        fragment.setArguments(bdl);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_sample, container, false);

        TextView textView = (TextView) v.findViewById(R.id.set_text);
        textView.setText("This is fragment " + item);

        return v;
    }

}