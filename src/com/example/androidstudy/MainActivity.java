package com.example.androidstudy;

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
		bt_phoneAct.setOnClickListener(this);
		bt_smsAct.setOnClickListener(this);
		bt_layoutAct.setOnClickListener(this);
		bt_relayoutAct.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_phoneAct:
			Log.i(TAG, "bt_phoneAct被点击");
			Intent intent1 = new Intent(this, PhoneActivity.class);
			startActivity(intent1);
			finish();
			break;
		case R.id.bt_smsAct:
			Log.i(TAG, "bt_smsAct被点击");
			Intent intent2 = new Intent(this, SmsActivity.class);
			startActivity(intent2);
			finish();
			break;
		case R.id.bt_RelAct:
			Log.i(TAG, "bt_RelAct被点击");
			Intent intent3 = new Intent(this, RelativeActivity.class);
			startActivity(intent3);
			finish();
			break;
		case R.id.bt_layoutAct:
			Log.i(TAG, "bt_layoutAct被点击");
			Intent intent4 = new Intent(this, LayoutActivity.class);
			startActivity(intent4);
			finish();
			break;
		default:
			break;
		}
	}
}
