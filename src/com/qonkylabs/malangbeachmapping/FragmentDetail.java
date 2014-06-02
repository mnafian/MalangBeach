package com.qonkylabs.malangbeachmapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.actionbarsherlock.app.SherlockListFragment;
import com.qobkylabs.malangbeachmapping.R;
import com.squareup.picasso.Picasso;

public class FragmentDetail extends SherlockListFragment {
	ListView list;
	List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
	ImageView imDetail;
	String key, name_l, desc, location, image;
	public static final String IMAGE_URL = "http://192.168.1.6/android/res/kategori/";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Intent in = getActivity().getIntent();
		key = (String) in.getStringExtra("key");
		name_l = (String) in.getStringExtra("name_l");
		image = (String) in.getStringExtra("image");
		desc = (String) in.getStringExtra("desc_d");
		location = (String) in.getStringExtra("location");
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("keyword", key);
			hm.put("nama_lokasi", name_l);
			hm.put("image_detail", image);
			hm.put("deskripsi", location+"\r\n"+desc);			
			aList.add(hm);

		String[] from = { "nama_lokasi", "deskripsi"};
		int[] to = { R.id.NamaLokasi, R.id.detailLokasi};

		SimpleAdapter adapter = new SimpleAdapter(getActivity()
				.getBaseContext(), aList, R.layout.fragment_detail, from, to);

		list = getListView();
		Context context = getListView().getContext();
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.image_header, null);
		imDetail = (ImageView) view.findViewById(R.id.detailImage);

		Picasso.with(getActivity()).load(IMAGE_URL+image)
				.fit().into(imDetail);
		list.addHeaderView(view);

		setListAdapter(adapter);
	}
}
