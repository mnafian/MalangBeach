package com.qonkylabs.malangbeachmapping;

import com.qobkylabs.malangbeachmapping.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Launcher extends Activity implements OnClickListener {
	Button start, about;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.launcher);
		Button mulai = (Button) findViewById(R.id.start);
		Button tentang = (Button) findViewById(R.id.tentang);
		mulai.setOnClickListener(this);
		tentang.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.start:
			Intent in = new Intent(Launcher.this, MenuUtama.class);
			startActivity(in);
			break;
		case R.id.tentang:
			Intent in2 = new Intent(Launcher.this, About.class);
			startActivity(in2);
			break;

		}
	}

}
