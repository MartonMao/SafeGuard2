package com.marton.adapter;

import com.marton.martonsafeguard.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GVAdapter extends BaseAdapter{
	Context context;
	String[] names;
	int[] ivs;
	public GVAdapter(Context context, String[] names, int[] ivs) {
		this.context = context;
		this.names = names;
		this.ivs = ivs;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return names.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		HolderView holder = null;
		if(convertView == null){
			view = convertView;
			view = LayoutInflater.from(context).inflate(R.layout.list_item_home, null);
			holder = new HolderView();
			holder.iv = (ImageView) view.findViewById(R.id.iv_item);
			holder.tv = (TextView) view.findViewById(R.id.tv_item);
			view.setTag(holder);
		}else{
			view = convertView;
			holder = (HolderView) view.getTag();
		}
		holder.iv.setImageResource(ivs[position]);
		holder.tv.setText(names[position]);
		return view;
	}
	
	private class HolderView{
		TextView tv;
		ImageView iv;
	}

}
