package com.example.ejfragmaestrodetalle;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

public class SplashActivity extends Activity{

	private static final long SPLASH_DELAY = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.splash);
		
		TimerTask task = new TimerTask(){
			public void run(){
				Intent mainIntent = new Intent().setClass(SplashActivity.this, MainActivity.class);
				startActivity(mainIntent);
				finish();
			}
		};
		
		Timer timer = new Timer();
		timer.schedule(task,SPLASH_DELAY);
	}	
}
