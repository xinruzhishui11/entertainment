package com.panzhiming.play.ui;

import com.panzhiming.play.R;
import com.panzhiming.play.R.id;
import com.panzhiming.play.R.layout;
import com.panzhiming.play.util.RotateAnimUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;


public class MainActivity extends Activity implements OnClickListener{
	private ImageButton ibHome;
	private ImageButton ibMenu;
	
	private ImageButton ibMusic;
	private ImageButton ibMovie;
	Context mContext;
	private boolean isLevel1isDisplay = true;
	private boolean isLevel2isDisplay = true;
	private boolean isLevel3isDisplay = true;
	
	private RelativeLayout rlLevel1;
	private RelativeLayout rlLevel2;
	private RelativeLayout rlLevel3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext= MainActivity.this;
        
        initViews();
        setListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	// TODO Auto-generated method stub
    	return super.onCreateOptionsMenu(menu);
    }





	private void initViews() {
		ibHome = (ImageButton) findViewById(R.id.ib_home);
		ibMenu = (ImageButton) findViewById(R.id.ib_menu);
		
		ibMusic = (ImageButton) findViewById(R.id.ib_music);
		ibMovie =  (ImageButton) findViewById(R.id.ib_movie);
		
		rlLevel1 = (RelativeLayout) findViewById(R.id.rl_level1);
		rlLevel2 = (RelativeLayout) findViewById(R.id.rl_level2);
		rlLevel3 = (RelativeLayout) findViewById(R.id.rl_level3);
		
		
	}
	
	private void setListeners() {
		ibHome.setOnClickListener(this);
		ibMenu.setOnClickListener(this);
		ibMusic.setOnClickListener(this);
		ibMovie.setOnClickListener(this);
	}



	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.ib_home:
			homeDelar();
			break;
			
		case R.id.ib_menu:
			menuDelar();
			break;
			
		case R.id.ib_movie:
			movie();
			break;

		}
	}
	
	private void homeDelar(){
		int delay = 0;
		if(isLevel3isDisplay){
			RotateAnimUtil.rotateOutAnim(rlLevel3, 0);
			isLevel3isDisplay = false;
			delay += 200;
			//1.判断第二层是否隐藏，如果没有隐藏，转出去
			RotateAnimUtil.rotateOutAnim(rlLevel2, delay);
			isLevel2isDisplay = false;
		}else{
			if(isLevel2isDisplay){
				RotateAnimUtil.rotateOutAnim(rlLevel2, 0);
				isLevel2isDisplay = false;
			}else{
				RotateAnimUtil.rotateInAnim(rlLevel2, 0);
				delay += 200;
				RotateAnimUtil.rotateInAnim(rlLevel3, delay);
				isLevel2isDisplay = true;
				isLevel3isDisplay = true;
			}
		}
	}
	
	private void menuDelar(){
		//1.判断第三层是否隐藏，如果没有隐藏，转出去
		if(isLevel3isDisplay){
			RotateAnimUtil.rotateOutAnim(rlLevel3,0);
		}else{
			//如果隐藏，转进来
			RotateAnimUtil.rotateInAnim(rlLevel3,0);
		}
		isLevel3isDisplay = !isLevel3isDisplay;
		
	}
	
	private void movie(){
		Intent intent = new Intent(mContext,MovieActivity.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		int delay = 0;
		if(keyCode == KeyEvent.KEYCODE_MENU){
			if(!isLevel1isDisplay){
				RotateAnimUtil.rotateInAnim(rlLevel1, 0);
				RotateAnimUtil.rotateInAnim(rlLevel2, 200);
				RotateAnimUtil.rotateInAnim(rlLevel3, 400);
				
				isLevel1isDisplay = true;
				isLevel2isDisplay = true;
				isLevel3isDisplay = true;
			}else{
				if(isLevel3isDisplay){
					RotateAnimUtil.rotateOutAnim(rlLevel3, 0);
					delay += 200;
					RotateAnimUtil.rotateOutAnim(rlLevel2, delay);
					delay += 200;
					RotateAnimUtil.rotateOutAnim(rlLevel1, delay);
					isLevel1isDisplay = false;
					isLevel2isDisplay = false;
					isLevel3isDisplay = false;
				}else{
					if(isLevel2isDisplay){
						RotateAnimUtil.rotateOutAnim(rlLevel2, 0);
						delay += 200;
						RotateAnimUtil.rotateInAnim(rlLevel1, delay);
						isLevel1isDisplay = false;
						isLevel2isDisplay = false;
					}
					else {
						RotateAnimUtil.rotateOutAnim(rlLevel1, 0);
						isLevel1isDisplay = false;
					}
				}
			}
		}
		return true;//消费完全
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
