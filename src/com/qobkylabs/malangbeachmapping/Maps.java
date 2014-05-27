package com.qobkylabs.malangbeachmapping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends Activity {
	String title;
	private GoogleMap map;
	LatLng LAT = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_maps);

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		Bundle bundle = getIntent().getParcelableExtra("lat");
		Intent in = getIntent();
		title = (String) in.getStringExtra("lokasi");
		LAT = bundle.getParcelable("place_position");

		LoadMaps(LAT, title);
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
