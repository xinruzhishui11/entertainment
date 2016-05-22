package com.panzhiming.play.ui;

import java.util.ArrayList;
import java.util.List;

import com.panzhiming.play.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MovieActivity extends Activity {
	private ViewPager vpMovie;
	private LinearLayout llPointContanier;
	private TextView tvDesc;
	private List<ImageView> imageList;

	private String[] contextDesc;
	private int[] imageResIds;

	private boolean isRunning;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_movie);
		// 初始化控件
		initViews();
		// 设置监听器
		initListeners();
		// 添加数据
		initData();
		// 添加适配器
		initAdapter();

		// 启动线程，自动更新viewPager
		startThread();
	}

	private void initViews() {
		llPointContanier = (LinearLayout) findViewById(R.id.ll_point_contanier);
		tvDesc = (TextView) findViewById(R.id.tv_desc);
		vpMovie = (ViewPager) findViewById(R.id.vp_movie);
	}

	private void initListeners() {
		// 为viewPager设置监听器
		vpMovie.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				int newPosition = position % imageList.size();

				// 条目选中时
				tvDesc.setText(contextDesc[newPosition]);

				setEnable(newPosition);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	private void setEnable(int position) {
		for (int i = 0; i < llPointContanier.getChildCount(); i++) {
			llPointContanier.getChildAt(i).setEnabled(false);
		}

		llPointContanier.getChildAt(position).setEnabled(true);
	}

	private void initData() {
		// 图片资源，小圆点
		imageResIds = new int[] { R.drawable.a, R.drawable.b, R.drawable.c,
				R.drawable.d, R.drawable.e };
		imageList = new ArrayList<ImageView>();
		View point;
		ImageView imageView;
		for (int i = 0; i < imageResIds.length; i++) {
			imageView = new ImageView(this);
			imageView.setBackgroundResource(imageResIds[i]);
			imageList.add(imageView);

			point = new View(this);
			point.setBackgroundResource(R.drawable.selector_bg_point);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(5,
					5);
			if (i != 0) {
				params.leftMargin = 10;
			}
			llPointContanier.addView(point, params);
			llPointContanier.getChildAt(i).setEnabled(false);
		}

		// 文字描述
		contextDesc = new String[] { "父亲的身份", "好想好想爱上你", "奇妙时光", "那年青春我们正好",
				"金水桥" };

	}

	private void initAdapter() {

		tvDesc.setText(contextDesc[0]);

		vpMovie.setAdapter(new MyAdapter());

		vpMovie.setCurrentItem(50000);
	}

	private class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return Integer.MAX_VALUE;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view == object;
		}

		// 添加要显示的条目
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			int newPosition = position % imageList.size();
			ImageView imageView = imageList.get(newPosition);
			container.addView(imageView);
			return imageView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((ImageView) object);
		}
	}

	private void startThread() {
		// 每过两秒，条目自动更换
		new Thread() {
			@Override
			public void run() {
				isRunning = true;
				while (isRunning) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					runOnUiThread(new Runnable() {
						public void run() {
							vpMovie.setCurrentItem(vpMovie.getCurrentItem() + 1);
						}
					});

				}

			}
		}.start();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		isRunning = false;

	}
}
