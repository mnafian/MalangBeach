package com.qonkylabs.malangbeachmapping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.actionbarsherlock.app.SherlockFragment;
import com.qobkylabs.malangbeachmapping.R;
 
public class FragmentPemandian extends SherlockFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmentlist_pemandian, container, false);
        return rootView;
    }
 
}
