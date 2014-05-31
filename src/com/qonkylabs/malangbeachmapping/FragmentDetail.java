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

public class FragmentDetail extends SherlockListFragment {
	ListView list;
	List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
	ImageView imDetail;
	String pos;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Intent in = getActivity().getIntent();
		pos = (String) in.getStringExtra("pos");
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		for (int i = 0; i < DaerahWisata.pantai.length; i++) {
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("pantai", pos);
			hm.put("detail", "Lokasi : \r\n" + DaerahWisata.detailp[i]);
			aList.add(hm);
		}

		String[] from = { "pantai", "detail" };
		int[] to = { R.id.NamaLokasi, R.id.detailLokasi };

		SimpleAdapter adapter = new SimpleAdapter(getActivity()
				.getBaseContext(), aList, R.layout.fragment_detail, from, to);

		list = getListView();
		Context context = getListView().getContext();
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.image_header, null);
		imDetail = (ImageView) view.findViewById(R.id.detailImage);

		if (pos.equals("goa")) {
			imDetail.setImageResource(R.drawable.pantaigoacina);
		} else if (pos.equals("send")) {
			imDetail.setImageResource(R.drawable.pantaisendangbiru);
		} else if (pos.equals("clung")) {
			imDetail.setImageResource(R.drawable.pantaiclungup);
		} else if (pos.equals("leng")) {
			imDetail.setImageResource(R.drawable.pantailenggoksono);
		} else if (pos.equals("baj")) {
			imDetail.setImageResource(R.drawable.pantaibajulmati);
		}
		list.addHeaderView(view);

		setListAdapter(adapter);
	}

}
