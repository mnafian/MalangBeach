package com.qobkylabs.malangbeachmapping;

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

public class FragmentCoban extends SherlockListFragment {
	ListView list;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

		for (int i = 0; i < DaerahWisata.coban.length; i++) {
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("coban", DaerahWisata.coban[i]);
			hm.put("foto", Integer.toString(DaerahWisata.imageIdCb[i]));
			hm.put("detail", "Lokasi : \r\n" + DaerahWisata.detailc[i]);
			aList.add(hm);
		}

		String[] from = { "foto", "coban" , "detail"};
		int[] to = { R.id.list_image_cb, R.id.judul_cb, R.id.deskripsi_cb };

		SimpleAdapter adapter = new SimpleAdapter(getActivity()
				.getBaseContext(), aList, R.layout.fragmentlist_coban, from, to);

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
			posisi = new LatLng(-7.884728, 112.476911);
			args.putParcelable("place_position", posisi);
			a = new Intent(getActivity(), Maps.class);
			a.putExtra("lat", args);
			a.putExtra("lokasi", "Coban Rondo, Batu");
			break;
		case 1:
			posisi = new LatLng(-8.003745, 112.870450);
			args.putParcelable("place_position", posisi);
			a = new Intent(getActivity(), Maps.class);
			a.putExtra("lat", args);
			a.putExtra("lokasi", "Coban Trisula, Desa Ngadas");
			break;
		case 2:
			posisi = new LatLng(-8.012381, 112.855808);
			args.putParcelable("place_position", posisi);
			a = new Intent(getActivity(), Maps.class);
			a.putExtra("lat", args);
			a.putExtra("lokasi", "Coban Pelangi, Desa Ngadas");
			break;
		case 3:
			posisi = new LatLng(-7.984722, 112.521111);
			args.putParcelable("place_position", posisi);
			a = new Intent(getActivity(), Maps.class);
			a.putExtra("lat", args);
			a.putExtra("lokasi", "Coban Glotak, Desa Bedalisodo");
			break;
		case 4:
			posisi = new LatLng(-7.905000, 112.498056);
			args.putParcelable("place_position", posisi);
			a = new Intent(getActivity(), Maps.class);
			a.putExtra("lat", args);
			a.putExtra("lokasi", "Coban Rais, Batu");
			break;
		case 5:
			posisi = new LatLng(-7.804444, 112.516944);
			args.putParcelable("place_position", posisi);
			a = new Intent(getActivity(), Maps.class);
			a.putExtra("lat", args);
			a.putExtra("lokasi", "Coban Talun, Batu");
			break;
		case 6:
			posisi = new LatLng(-7.892222, 112.474722);
			args.putParcelable("place_position", posisi);
			a = new Intent(getActivity(), Maps.class);
			a.putExtra("lat", args);
			a.putExtra("lokasi", "Coban Tengah, Batu");
			break;
		case 7:
			posisi = new LatLng(-7.894444, 112.475556);
			args.putParcelable("place_position", posisi);
			a = new Intent(getActivity(), Maps.class);
			a.putExtra("lat", args);
			a.putExtra("lokasi", "Coban Manten, Batu");
			break;
		}
		if (null != a) {
			startActivity(a);
		}
	}

}