package com.qonkylabs.malangbeachmapping;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockMapFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends SherlockMapFragment {
	String title;
	private GoogleMap map;
	LatLng LAT = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        map = getMap();
        Bundle bundle = getActivity().getIntent().getParcelableExtra("lat");
		Intent in = getActivity().getIntent();
		title = (String) in.getStringExtra("lokasi");
		LAT = bundle.getParcelable("place_position");

		LoadMaps(LAT, title);
        return root;
    }

	public void LoadMaps(LatLng posisiLat, String judulLokasi) {
		map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		map.addMarker(new MarkerOptions()
				.position(posisiLat)
				.title(judulLokasi)
				.snippet("Lokasi Tujuan Wisata Anda")
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
		
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(LAT, 15));
		map.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
		
		
	}
}
