package com.qonkylabs.malangbeachmapping;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qobkylabs.malangbeachmapping.R;
import com.squareup.picasso.Picasso;

public class ListLokasiAdapter extends BaseAdapter {

	private Context mContext;
	LayoutInflater inflater;
	private final ArrayList<HashMap<String, String>> urls;
	HashMap<String, String> resultp = new HashMap<String, String>();

	public static final String IMAGE_URL = "http://192.168.1.6/android/res/kategori/";

	public ListLokasiAdapter(Context context,
			ArrayList<HashMap<String, String>> items) {
		mContext = context;
		urls = items;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return urls.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return getItem(position).hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView judul, lokasi;
		ImageView gambar;

		inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View view = inflater.inflate(R.layout.fragmentlist_pantai, parent,
				false);
		resultp = urls.get(position);

		judul = (TextView) view.findViewById(R.id.judul);
		lokasi = (TextView) view.findViewById(R.id.deskripsi);
		gambar = (ImageView) view.findViewById(R.id.list_image);

		judul.setText(resultp.get(FragmentPantai.NAME_L));
		lokasi.setText("Lokasi :\r\n"+resultp.get(FragmentPantai.LOK_D));

		Picasso.with(mContext)
				.load(IMAGE_URL + resultp.get(FragmentPantai.IMG_G))
				.placeholder(R.drawable.loader).error(R.drawable.logo).fit()
				.centerCrop().into(gambar);

		return view;

	}

}
