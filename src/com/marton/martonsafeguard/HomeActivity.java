package com.marton.martonsafeguard;

import com.marton.adapter.GVAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class HomeActivity extends Activity {

	private GridView list_home;
	private GVAdapter adapter;
	
	private String[] names = {
		"�ֻ�����", "ͨѶ��ʿ", "�������",
		"���̹���", "����ͳ��", "�ֻ�ɱ��",
		"��������", "�߼�����", "��������"
	};
	
	private int[] ivs = {
		R.drawable.safe,        R.drawable.callmsgsafe, R.drawable.app,
		R.drawable.taskmanager, R.drawable.netmanager,  R.drawable.trojan,
		R.drawable.sysoptimize, R.drawable.atools,      R.drawable.settings
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.avtivity_home);
		
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		list_home = (GridView) findViewById(R.id.list_home);
		adapter = new GVAdapter(this, names, ivs);
		list_home.setAdapter(adapter);
		list_home.setOnItemClickListener(listener);
	}
	
	private OnItemClickListener listener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			switch (position) {
			case 8:
				Intent i = new Intent(HomeActivity.this, Setting.class);
				startActivity(i);
				break;

			default:
				break;
			}
			
		}
	};

}
