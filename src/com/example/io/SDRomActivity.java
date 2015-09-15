package com.example.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.androidstudy.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SDRomActivity extends Activity implements OnClickListener {
	private static final String TAG = "SDRomActivity";
	private EditText et_sd_user;
	private EditText et_sd_pwd;
	private CheckBox cb_sd_user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sdrom);

		et_sd_user = (EditText) this.findViewById(R.id.et_sd_name);
		et_sd_pwd = (EditText) this.findViewById(R.id.et_sd_psd);

		cb_sd_user = (CheckBox) this.findViewById(R.id.cb_sd_user);
		Button bt_sd_login = (Button) this.findViewById(R.id.bt_sd_login);
		bt_sd_login.setOnClickListener(this);

		getInfo();
	}

	private void getInfo() {
		try {
			File file = new File(Environment.getExternalStorageDirectory(), "info.txt");
			FileInputStream fis = new FileInputStream(file);
			// 把字节流转换成字符流
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String text = br.readLine();
			String[] s = text.split("##");

			et_sd_user.setText(s[0]);
			et_sd_pwd.setText(s[1]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_sd_login:
			String user = et_sd_user.getText().toString();
			String pwd = et_sd_pwd.getText().toString();
			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
				if (cb_sd_user.isChecked()) {
					try {
						File file = new File(Environment.getExternalStorageDirectory(), "info.txt");
						FileOutputStream fos = new FileOutputStream(file);
						fos.write((user + "##" + pwd).getBytes());
						fos.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			break;

		default:
			break;
		}
	}
}
