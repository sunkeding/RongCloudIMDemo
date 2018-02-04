package com.imdemo.skd.imdemo;

import android.content.Context;

import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imkit.widget.adapter.ConversationListAdapter;

/**
 * Created by skd on 2018/1/17.
 */

public class MyConversationListFragment extends ConversationListFragment {
    @Override
    public ConversationListAdapter onResolveAdapter(Context context) {
        return super.onResolveAdapter(context);
    }
}
