package com.marton.martonsafeguard;

import com.marton.ui.SettingItemView;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Setting extends Activity {

	private SettingItemView siv_update;
	private SharedPreferences sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
	
		sp = getSharedPreferences("config", MODE_PRIVATE);
		siv_update = (SettingItemView) findViewById(R.id.siv_update);
		setUpdateView();
		siv_update.setOnClickListener(listener);
	}
	
	private OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Editor editor = sp.edit();
			if(siv_update.isChecked()){
				siv_update.setChecked(false);
				editor.putBoolean("update", false);
			}else{
				siv_update.setChecked(true);
				editor.putBoolean("update", true);
			}
			editor.commit();
		}
	};
	private void setUpdateView() {
		// TODO Auto-generated method stub
		boolean update = sp.getBoolean("update", false);
		if(update){
			//自动升级开启
			siv_update.setChecked(true);
		}else{
			siv_update.setChecked(false);
		}
	}
}
