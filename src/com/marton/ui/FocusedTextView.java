package com.marton.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewDebug.ExportedProperty;
import android.widget.TextView;

/**
 * �Զ���һ��TextView һ�������н���
 */
public class FocusedTextView extends TextView{

	public FocusedTextView(Context context) {
		super(context);

	}

	
	public FocusedTextView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	/**
	 *��ǰ��û�н���ģ�ֻ��ǿ�ƻ�ȡ���㣬����ƭAndroidϵͳ
	 */
	@Override
	@ExportedProperty(category = "focus")
	public boolean isFocused() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
