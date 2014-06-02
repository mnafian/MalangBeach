package com.qonkylabs.malangbeachmapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.google.android.gms.maps.model.LatLng;
import com.qobkylabs.malangbeachmapping.R;

public class FragmentPantai extends SherlockListFragment {
	ListView list;
	private ProgressDialog pDialog;

	public static final String NAME_L = "nama";
	public static final String KAT_L = "cat";
	public static final String KEY = "key";
	public static final String LOK_D = "lokasi";
	public static final String DESK_D = "deskripsi";
	public static final String LAT_K = "lat";
	public static final String LONG_K = "long";
	public static final String IMG_G = "gambar";

	public static final String URL_WS = "http://192.168.1.6/android/services.php";

	JSONArray categories = null;
	JSONParser jsonParser = new JSONParser();
	private BaseAdapter mAdapter;

	public ArrayList<HashMap<String, String>> listPantai;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.list_activity, container, false);
		listPantai = new ArrayList<HashMap<String, String>>();

		new LoadData().execute();
		return view;
	}

	class LoadData extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Get Data");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... args) {

			List<NameValuePair> params = new ArrayList<NameValuePair>();

			String json = jsonParser.makeHttpRequest(URL_WS, "GET", params);
			Log.d("Categories JSON: ", "> " + json);

			return json;
		}

		@Override
		protected void onPostExecute(String json) {
			// TODO Auto-generated method stub
			try {
				categories = new JSONArray(json);
				if (categories != null) {
					for (int i = 0; i < categories.length(); i++) {
						JSONObject obj = categories.getJSONObject(i);

						String nama = obj.getString(NAME_L);
						String cat = obj.getString(KAT_L);
						String kunci = obj.getString(KEY);
						String lokasi = obj.getString(LOK_D);
						String deskripsi = obj.getString(DESK_D);
						String lati = obj.getString(LAT_K);
						String longi = obj.getString(LONG_K);
						String gambar = obj.getString(IMG_G);

						HashMap<String, String> map = new HashMap<String, String>();

						map.put(NAME_L, nama);
						map.put(KAT_L, cat);
						map.put(KEY, kunci);
						map.put(LOK_D, lokasi);
						map.put(DESK_D, deskripsi);
						map.put(LAT_K, lati);
						map.put(LONG_K, longi);
						map.put(IMG_G, gambar);

						listPantai.add(map);
					}
					mAdapter = new ListLokasiAdapter(getActivity()
							.getApplicationContext(), listPantai);
					getListView().setAdapter(mAdapter);
					pDialog.dismiss();
				}
			} catch (JSONException e) {
				Log.d("Categories: ", "null");
			}
		}
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent a = null;
		LatLng positionMap;
		Bundle args = new Bundle();
		String key = listPantai.get(position).get(KEY).toString();
		String name_l = listPantai.get(position).get(NAME_L).toString();
		String llat = listPantai.get(position).get(LAT_K).toString();
		String llong = listPantai.get(position).get(LONG_K).toString();
		String desc = listPantai.get(position).get(DESK_D).toString();
		String image = listPantai.get(position).get(IMG_G).toString();
		String location = listPantai.get(position).get(LOK_D).toString();

		positionMap = new LatLng(Double.parseDouble(llat), Double.parseDouble(llong));

		args.putParcelable("place_position", positionMap);
		a = new Intent(getActivity(), MapsMenu.class);
		a.putExtra("lat", args);
		a.putExtra("key", key);
		a.putExtra("name_l", name_l);
		a.putExtra("desc_d", desc);
		a.putExtra("location", location);
		a.putExtra("image", image);

		if (null != a) {
			startActivity(a);
		}
	}

}