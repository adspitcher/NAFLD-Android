package com.app.nafld.views;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.app.nafld.R;
import com.app.nafld.constants.Constants;

public class SplashActivity extends Activity {

	// Time in Milliseconds
	private int SPLASH_TIMER = 2000;
	private String accessToken;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_splash);
		
		SharedPreferences sharedPref = getSharedPreferences(
				Constants.DATABASE_PREF_NAME, MODE_PRIVATE);
		accessToken = sharedPref.getString(Constants.TEXT_ACCESSTOKEN,
				Constants.TEXT_DATABASE_ACCESS_VALUE_DEFAULT);

		// New Handler to start new Activity and close this Splash after few
		// seconds
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				if (!accessToken.equals(Constants.TEXT_DATABASE_ACCESS_VALUE_DEFAULT)) {
					Intent screenChangeIntent = null;
					screenChangeIntent = new Intent(SplashActivity.this,
							HomeActivity.class);
					SplashActivity.this.startActivity(screenChangeIntent);
					SplashActivity.this.finish();
				} else {
					Intent screenChangeIntent = null;
					screenChangeIntent = new Intent(SplashActivity.this,
							LoginActivity.class);
					SplashActivity.this.startActivity(screenChangeIntent);
					SplashActivity.this.finish();
				}
			}
		}, SPLASH_TIMER);
	}

}