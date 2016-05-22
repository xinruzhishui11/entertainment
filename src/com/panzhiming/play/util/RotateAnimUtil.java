package com.panzhiming.play.util;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public class RotateAnimUtil {
	
	private static RotateAnimation ra;

	public static void rotateOutAnim(RelativeLayout rlLevel, int delay) {
		float fromDegrees = 0f;//旋转开始角度
		float toDegrees = -180f;//旋转结束角度     逆时针旋转
		int pivotXType = Animation.RELATIVE_TO_SELF;//x轴旋转类型
		float pivotXValue =0.5f;//x轴旋转值
		int pivotYType =  Animation.RELATIVE_TO_SELF;//y轴旋转类型
		float pivotYValue =1;//y轴旋转值
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
		float fromDegrees = -180f;//旋转开始角度
		float toDegrees = 0f;//旋转结束角度     顺时针旋转
		int pivotXType = Animation.RELATIVE_TO_SELF;//x轴旋转类型
		float pivotXValue =0.5f;//x轴旋转值
		int pivotYType =  Animation.RELATIVE_TO_SELF;//y轴旋转类型
		float pivotYValue =1;//y轴旋转值
		ra = new RotateAnimation(fromDegrees, toDegrees,
							pivotXType, pivotXValue, pivotYType, pivotYValue);
		ra.setDuration(200);
		ra.setStartOffset(delay);
		ra.setFillAfter(true);
		rlLevel.startAnimation(ra);
	}

}
