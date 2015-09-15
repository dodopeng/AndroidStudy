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
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class RomActivity extends Activity implements OnClickListener {

	private static final String TAG = "RomActivity";
	private EditText et_user;
	private EditText et_pwd;
	private CheckBox cb_user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rom);

		et_user = (EditText) this.findViewById(R.id.et_name);
		et_pwd = (EditText) this.findViewById(R.id.et_psd);

		cb_user = (CheckBox) this.findViewById(R.id.cb_user);
		Button bt_login = (Button) this.findViewById(R.id.bt_login);

		bt_login.setOnClickListener(this);

		getInfo();

	}

	private void getInfo() {
		try {
			File file = new File(getFilesDir(), "info.txt");
			FileInputStream fis = new FileInputStream(file);
			// 把字节流转换成字符流
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String text = br.readLine();
			String[] s = text.split("##");

			et_user.setText(s[0]);
			et_pwd.setText(s[1]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_login:
			String user = et_user.getText().toString();
			String pwd = et_pwd.getText().toString();
			// Log.i(TAG, "username:" + user);
			// Log.i(TAG, "password:" + pwd);
			if (cb_user.isChecked()) {
				try {
					File file = new File(getFilesDir(), "info.txt");
					FileOutputStream fos = new FileOutputStream(file);
					fos.write((user + "##" + pwd).getBytes());
					fos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Toast.makeText(this, "登陆成功", 0).show();
			break;

		default:
			break;
		}
	}
}
