package com.qobkylabs.malangbeachmapping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.actionbarsherlock.app.SherlockListFragment;

public class FragmentTab1 extends SherlockListFragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragmenttab1, null);
		String[] mathList = new String[] { "Pantai Goa Cina", "Pantai Sendang Biru", "Pantai Lenggoksono",
				"Pantai Sipelot" };
		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, mathList));
		return view;
	}
}