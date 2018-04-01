package com.marton.ui;

import com.marton.martonsafeguard.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SettingItemView extends RelativeLayout{

	private CheckBox cb_status;
	private TextView tv_desc;
	private TextView tv_title;
	
	private String title;
	private String desc_on;
	private String desc_off;
	
	private String namespace = "http://schemas.android.com/apk/res/com.marton.martonsafeguard";
	
	public SettingItemView(Context context) {
		super(context);
		initView(context);	
	}

	public SettingItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);	
		title = attrs.getAttributeValue(namespace, "title");
		desc_on = attrs.getAttributeValue(namespace, "desc_on");
		desc_off = attrs.getAttributeValue(namespace, "desc_off");
		tv_title.setText(title);
	}

	public SettingItemView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView(context);	
	}

	private void initView(Context context){
		View.inflate(context, R.layout.setting_item_view, this);
		cb_status = (CheckBox) this.findViewById(R.id.cb_status);
		tv_desc = (TextView) this.findViewById(R.id.tv_desc);
		tv_title = (TextView) this.findViewById(R.id.tv_title);	
	}

	/**
	 * 校验组合空间是否选中
	 */
	public boolean isChecked(){
		return cb_status.isChecked();
	}
	
	public void setChecked(boolean checked){
		if(checked){
			setDesc(desc_on);
		}else{
			setDesc(desc_off);
		}
		cb_status.setChecked(checked);
	}
	/**
	 * 设置组合控件的名字
	 * @param text
	 */
	public void setDesc(String text){
		tv_desc.setText(text);
	}
}
