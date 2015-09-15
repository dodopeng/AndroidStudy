package com.example.androidstudy;

import com.example.io.RomActivity;
import com.example.io.SDRomActivity;
import com.example.layout.LayoutActivity;
import com.example.layout.RelativeActivity;
import com.example.phone.PhoneActivity;
import com.example.phone.SmsActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button bt_phoneAct = (Button) this.findViewById(R.id.bt_phoneAct);
		Button bt_smsAct = (Button) this.findViewById(R.id.bt_smsAct);
		Button bt_layoutAct = (Button) this.findViewById(R.id.bt_layoutAct);
		Button bt_relayoutAct = (Button) this.findViewById(R.id.bt_RelAct);
		Button bt_romAct = (Button) this.findViewById(R.id.bt_RomAct);
		Button bt_sdromAct = (Button) this.findViewById(R.id.bt_SDRomAct);
		bt_phoneAct.setOnClickListener(this);
		bt_smsAct.setOnClickListener(this);
		bt_layoutAct.setOnClickListener(this);
		bt_relayoutAct.setOnClickListener(this);
		bt_romAct.setOnClickListener(this);
		bt_sdromAct.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_phoneAct:
			Log.i(TAG, "bt_phoneAct被点击");
			Intent intent1 = new Intent(this, PhoneActivity.class);
			startActivity(intent1);
			break;
		case R.id.bt_smsAct:
			Log.i(TAG, "bt_smsAct被点击");
			Intent intent2 = new Intent(this, SmsActivity.class);
			startActivity(intent2);
			break;
		case R.id.bt_RelAct:
			Log.i(TAG, "bt_RelAct被点击");
			Intent intent3 = new Intent(this, RelativeActivity.class);
			startActivity(intent3);
			break;
		case R.id.bt_layoutAct:
			Log.i(TAG, "bt_layoutAct被点击");
			Intent intent4 = new Intent(this, LayoutActivity.class);
			startActivity(intent4);
			break;
		case R.id.bt_RomAct:
			Log.i(TAG, "bt_RomAct被点击");
			Intent intent5 = new Intent(this, RomActivity.class);
			startActivity(intent5);
			break;
		case R.id.bt_SDRomAct:
			Log.i(TAG, "bt_SDRomAct被点击");
			Intent intent6 = new Intent(this, SDRomActivity.class);
			startActivity(intent6);
			break;
		default:
			break;
		}
	}
}
