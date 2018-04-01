package com.marton.martonsafeguard;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

public class SplashActivity extends Activity {

	protected static final int ENTER_HOME = 1;
	protected static final int DELAY = 5;
	private TextView tv_splash_version;
	private TextView tv_update_info;
	private String description;
	/**
	 * 新版的下载地址
	 */
	private String apkurl;
	private SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		initView();		
		showAnimation();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				isCheckUpdate();
			}
		}, 2000);
	}
	
	private void showAnimation() {
		// TODO Auto-generated method stub
		AlphaAnimation aa = new AlphaAnimation(0f, 1.0f);
		aa.setDuration(2000);
		findViewById(R.id.rl_root_splash).startAnimation(aa);
	}

	private void isCheckUpdate() {
		// TODO Auto-generated method stub
		boolean update = sp.getBoolean("update", false);
		if(update){
			checkUpdate();
		}else{
			enterHome();
		}
	}
	
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case ENTER_HOME:
				enterHome();
				break;

			default:
				break;
			}
		}


	};
	
	private void enterHome() {
		// TODO Auto-generated method stub
		Intent i = new Intent(SplashActivity.this, HomeActivity.class);
		startActivity(i);
		finish();
	};

	/**
	 * 检查升级
	 */
	private void checkUpdate() {
		// TODO Auto-generated method stub
		handler.sendEmptyMessage(ENTER_HOME);
	}

	private void initView(){
		sp = getSharedPreferences("config", MODE_PRIVATE);
		tv_splash_version = (TextView) findViewById(R.id.tv_splash_version);
		tv_splash_version.setText("版本号："+getVersionName());
		tv_update_info = (TextView) findViewById(R.id.tv_update_info);		
	}

	/**
	 * 获取应用的版本名称
	 * @return
	 */
	private String getVersionName() {
		PackageManager pm = getPackageManager();
		try {
			PackageInfo info = pm.getPackageInfo(getPackageName(), 0);
			return info.versionName;
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
