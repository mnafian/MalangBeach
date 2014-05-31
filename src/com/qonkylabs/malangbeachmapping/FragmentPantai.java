package com.qonkylabs.malangbeachmapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.actionbarsherlock.app.SherlockListFragment;
import com.google.android.gms.maps.model.LatLng;
import com.qobkylabs.malangbeachmapping.R;

public class FragmentPantai extends SherlockListFragment {
	ListView list;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Each row in the list stores country name, currency and flag
		List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

		for (int i = 0; i < DaerahWisata.pantai.length; i++) {
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("pantai", DaerahWisata.pantai[i]);
			hm.put("foto", Integer.toString(DaerahWisata.imageId[i]));
			hm.put("detail", "Lokasi : \r\n" + DaerahWisata.detailp[i]);
			aList.add(hm);
		}

		String[] from = { "foto", "pantai", "detail" };
		int[] to = { R.id.list_image, R.id.judul, R.id.deskripsi };

		SimpleAdapter adapter = new SimpleAdapter(getActivity()
				.getBaseContext(), aList, R.layout.fragmentlist_pantai, from,
				to);

		setListAdapter(adapter);

		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent a = null;
		LatLng posisi;
		Bundle args = new Bundle();
		switch (position) {

		case 0:
			posisi = new LatLng(-8.447159, 112.651799);
			args.putParcelable("place_position", posisi);
			a = new Intent(getActivity(), MapsMenu.class);
			a.putExtra("lat", args);
			a.putExtra("pos", "goa");
			a.putExtra("lokasi", "Pantai Goa Cina Malang Selatan");
			break;
		case 1:
			posisi = new LatLng(-8.431354, 112.686206);
			args.putParcelable("place_position", posisi);
			a = new Intent(getActivity(), MapsMenu.class);
			a.putExtra("lat", args);
			a.putExtra("pos", "send");
			a.putExtra("lokasi", "Pantai Sendang Biru & Akses Ke Pulau Sempu");
			break;
		case 2:
			posisi = new LatLng(-8.443069, 112.664548);
			args.putParcelable("place_position", posisi);
			a = new Intent(getActivity(), MapsMenu.class);
			a.putExtra("lat", args);
			a.putExtra("pos", "clung");
			a.putExtra("lokasi", "Pantai Clungup");
			break;
		case 3:
			posisi = new LatLng(-8.371426, 112.838349);
			args.putParcelable("place_position", posisi);
			a = new Intent(getActivity(), MapsMenu.class);
			a.putExtra("lat", args);
			a.putExtra("pos", "leng");
			a.putExtra("lokasi", "Pantai Lenggoksono, Tirtoyudo");
			break;
		case 4:
			posisi = new LatLng(-8.433449, 112.638965);
			args.putParcelable("place_position", posisi);
			a = new Intent(getActivity(), MapsMenu.class);
			a.putExtra("lat", args);
			a.putExtra("pos", "baj");
			a.putExtra("lokasi", "Pantai Bajulmati, Gedangan");
			break;
		}
		if (null != a) {
			startActivity(a);
		}
	}

}