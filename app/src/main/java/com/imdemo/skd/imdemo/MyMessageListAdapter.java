package com.imdemo.skd.imdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.adapter.MessageListAdapter;

/**
 * Created by skd on 2018/1/17.
 */

public class MyMessageListAdapter extends MessageListAdapter {
    public MyMessageListAdapter(Context context) {
        super(context);
    }

    @Override
    protected View newView(Context context, int position, ViewGroup group) {
        return super.newView(context, position, group);

    }

    @Override
    protected void bindView(View v, int position, UIMessage data) {
        super.bindView(v, position, data);
    }
}
