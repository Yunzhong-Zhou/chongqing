package com.zhitiekeji.equipmentmanagement.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;

/**
 * @author ling
 *	功能描述：自定义底部工具栏
 */
public class FragmentIndicator1 extends LinearLayout implements OnClickListener {

	private int mDefaultIndicator = 0;

	private static int mCurIndicator;

	private static View[] mIndicators;

	private OnIndicateListener mOnIndicateListener;

	private  int COLOR_UNSELECT;
	private  int COLOR_SELECT ;
    private LayoutInflater layoutInflater;

	private FragmentIndicator1(Context context) {
		super(context);
	}

	public FragmentIndicator1(Context context, AttributeSet attrs) {
		super(context, attrs);
		layoutInflater= LayoutInflater.from(context);
		mCurIndicator = mDefaultIndicator;
		setOrientation(LinearLayout.HORIZONTAL);
		init();
	}

	private void init() {
		COLOR_UNSELECT=getContext().getResources().getColor(R.color.default_text);
		COLOR_SELECT=getContext().getResources().getColor(R.color.lightblue500);
		LinearLayout ll_view = (LinearLayout) layoutInflater.inflate(R.layout.fragmentindicator1,null);
		mIndicators = new View[ll_view.getChildCount()];
		for (int i = 0; i < mIndicators.length; i++) {
			mIndicators[i] = ll_view.getChildAt(i);
			mIndicators[i].setOnClickListener(this);
			mIndicators[i].setTag(Integer.valueOf(i));
		}
		LayoutParams PARAM_MP_WC = new LayoutParams(
				LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
        addView(ll_view,PARAM_MP_WC);
		setIndicator(mCurIndicator);
	}

	public void setIndicator(int which) {
		// 清除以前的状态。
		//mIndicators[mCurIndicator].setBackgroundColor(Color.alpha(0));
		ImageView prevIcon;
		TextView prevText;
		switch(mCurIndicator) {
			case 0:
				prevIcon =(ImageView) mIndicators[mCurIndicator].findViewById(R.id.imageView1);
				prevIcon.setImageResource(R.mipmap.repair1_0);
				prevText = (TextView) mIndicators[mCurIndicator].findViewById(R.id.textView1);
				prevText.setTextColor(COLOR_UNSELECT);
				break;
			case 1:
				prevIcon =(ImageView) mIndicators[mCurIndicator].findViewById(R.id.imageView2);
				prevIcon.setImageResource(R.mipmap.repair2_0);
				prevText = (TextView) mIndicators[mCurIndicator].findViewById(R.id.textView2);
				prevText.setTextColor(COLOR_UNSELECT);
				break;
			case 2:
				prevIcon =(ImageView) mIndicators[mCurIndicator].findViewById(R.id.imageView3);
				prevIcon.setImageResource(R.mipmap.repair3_0);
				prevText = (TextView) mIndicators[mCurIndicator].findViewById(R.id.textView3);
				prevText.setTextColor(COLOR_UNSELECT);
				break;
			case 3:
				prevIcon =(ImageView) mIndicators[mCurIndicator].findViewById(R.id.imageView4);
				prevIcon.setImageResource(R.mipmap.repair4_0);
				prevText = (TextView) mIndicators[mCurIndicator].findViewById(R.id.textView4);
				prevText.setTextColor(COLOR_UNSELECT);
				break;
			case 4:
				prevIcon =(ImageView) mIndicators[mCurIndicator].findViewById(R.id.imageView5);
				prevIcon.setImageResource(R.mipmap.repair5_0);
				prevText = (TextView) mIndicators[mCurIndicator].findViewById(R.id.textView5);
				prevText.setTextColor(COLOR_UNSELECT);
				break;
		}

		// 更新当前状态。
		//mIndicators[which].setBackgroundResource(R.drawable.indic_select);
		ImageView currIcon;
		TextView currText;
		switch(which) {
			case 0:
				currIcon =(ImageView) mIndicators[which].findViewById(R.id.imageView1);
				currIcon.setImageResource(R.mipmap.repair1_1);
				currText = (TextView) mIndicators[which].findViewById(R.id.textView1);
				currText.setTextColor(COLOR_SELECT);
				break;
			case 1:
				currIcon =(ImageView) mIndicators[which].findViewById(R.id.imageView2);
				currIcon.setImageResource(R.mipmap.repair2_1);
				currText = (TextView) mIndicators[which].findViewById(R.id.textView2);
				currText.setTextColor(COLOR_SELECT);
				break;
			case 2:
				currIcon =(ImageView) mIndicators[which].findViewById(R.id.imageView3);
				currIcon.setImageResource(R.mipmap.repair3_1);
				currText = (TextView) mIndicators[which].findViewById(R.id.textView3);
				currText.setTextColor(COLOR_SELECT);
				break;
			case 3:
				currIcon =(ImageView) mIndicators[which].findViewById(R.id.imageView4);
				currIcon.setImageResource(R.mipmap.repair4_1);
				currText = (TextView) mIndicators[which].findViewById(R.id.textView4);
				currText.setTextColor(COLOR_SELECT);
				break;
			case 4:
				currIcon =(ImageView) mIndicators[which].findViewById(R.id.imageView5);
				currIcon.setImageResource(R.mipmap.repair5_1);
				currText = (TextView) mIndicators[which].findViewById(R.id.textView5);
				currText.setTextColor(COLOR_SELECT);
				break;
		}

		mCurIndicator = which;
	}

	public interface OnIndicateListener {
		public void onIndicate(View v, int which);
	}

	public void setOnIndicateListener(OnIndicateListener listener) {
		mOnIndicateListener = listener;
	}

	@Override
	public void onClick(View v) {
		if (mOnIndicateListener != null) {
			int tag = (Integer) v.getTag();
			switch (tag) {
				case 0:
					if (mCurIndicator != 0) {
						mOnIndicateListener.onIndicate(v, 0);
						setIndicator(0);
					}
					break;
				case 1:
					if (mCurIndicator != 1) {
						mOnIndicateListener.onIndicate(v, 1);
						setIndicator(1);
					}
					break;
				case 2:
					if (mCurIndicator != 2) {
						mOnIndicateListener.onIndicate(v, 2);
						setIndicator(2);
					}
					break;
				case 3:
					if (mCurIndicator != 3) {
						mOnIndicateListener.onIndicate(v, 3);
						setIndicator(3);
					}
					break;
				case 4:
					if (mCurIndicator != 4) {
						mOnIndicateListener.onIndicate(v, 4);
						setIndicator(4);
					}
					break;
				default:
					break;
			}
		}
	}
}
