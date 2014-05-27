package com.qobkylabs.malangbeachmapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

public class About extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);

		String judul[] = new String[] { "Developer", "Designer", "Website",
				"Contact" };
		String info[] = new String[] { "M. Nafian Wildana", "Danial Abror",
				"http://www.qonkystudio.com", "admin@qonkystudio.com" };

		List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

		for (int i = 0; i < judul.length; i++) {
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("judul", judul[i]);
			hm.put("info", info[i]);
			aList.add(hm);
		}

		String[] from = { "judul", "info" };
		int[] to = { R.id.judulabs, R.id.info };

		SimpleAdapter adapter = new SimpleAdapter(this, aList,
				R.layout.list_about, from, to);

		setListAdapter(adapter);

	}
}
