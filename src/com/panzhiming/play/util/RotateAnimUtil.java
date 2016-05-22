package com.panzhiming.play.util;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public class RotateAnimUtil {
	
	private static RotateAnimation ra;

	public static void rotateOutAnim(RelativeLayout rlLevel, int delay) {
		float fromDegrees = 0f;//��ת��ʼ�Ƕ�
		float toDegrees = -180f;//��ת�����Ƕ�     ��ʱ����ת
		int pivotXType = Animation.RELATIVE_TO_SELF;//x����ת����
		float pivotXValue =0.5f;//x����תֵ
		int pivotYType =  Animation.RELATIVE_TO_SELF;//y����ת����
		float pivotYValue =1;//y����תֵ
		ra = new RotateAnimation(fromDegrees, toDegrees,
							pivotXType, pivotXValue, pivotYType, pivotYValue);
		ra.setDuration(200);
		ra.setStartOffset(delay);
		ra.setFillAfter(true);
		
		ra.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				
			}
		});
		rlLevel.startAnimation(ra);
		
	}

	public static void rotateInAnim(RelativeLayout rlLevel, int delay) {
		float fromDegrees = -180f;//��ת��ʼ�Ƕ�
		float toDegrees = 0f;//��ת�����Ƕ�     ˳ʱ����ת
		int pivotXType = Animation.RELATIVE_TO_SELF;//x����ת����
		float pivotXValue =0.5f;//x����תֵ
		int pivotYType =  Animation.RELATIVE_TO_SELF;//y����ת����
		float pivotYValue =1;//y����תֵ
		ra = new RotateAnimation(fromDegrees, toDegrees,
							pivotXType, pivotXValue, pivotYType, pivotYValue);
		ra.setDuration(200);
		ra.setStartOffset(delay);
		ra.setFillAfter(true);
		rlLevel.startAnimation(ra);
	}

}
