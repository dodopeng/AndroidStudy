package com.example.phone;

import java.util.ArrayList;

import com.example.androidstudy.R;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends Activity implements OnClickListener {

	private static final String TAG = "SmsActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms);

		Button bt_sms = (Button) this.findViewById(R.id.bt_sms);
		bt_sms.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_sms:
			Log.i(TAG, "bt_sms被点击");
			EditText et_smsNum = (EditText) this.findViewById(R.id.et_smsNum);
			EditText et_content = (EditText) this.findViewById(R.id.et_smsCont);

			String number = et_smsNum.getText().toString();
			String content = et_content.getText().toString();

			Log.i(TAG, number + ":" + content);
			SmsManager smsManager = SmsManager.getDefault();
			ArrayList<String> messages = smsManager.divideMessage(content);
			for (String message : messages) {
				smsManager.sendTextMessage(number, null, message, null, null);
			}
			Toast.makeText(this, "短信发送成功", 0).show();
			break;

		default:
			break;
		}
	}
}
