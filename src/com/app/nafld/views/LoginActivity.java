package com.app.nafld.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

import com.app.nafld.R;
import com.app.nafld.constants.Constants;

public class LoginActivity extends ActionBarActivity {
	
	private boolean keepMeLoggedInBool;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);

		EditText password = (EditText) findViewById(R.id.edittext_password);
		password.setTypeface(Typeface.SERIF);
		password.setTransformationMethod(new PasswordTransformationMethod());

		Button btn_signin = (Button) findViewById(R.id.btn_login);
		btn_signin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				
				if (keepMeLoggedInBool) {
					SharedPreferences sharedPref = getSharedPreferences(
							Constants.DATABASE_PREF_NAME, MODE_PRIVATE);
					SharedPreferences.Editor editor = sharedPref.edit();
					editor.putString(Constants.TEXT_ACCESSTOKEN, Constants.TEXT_USERLOGGEDIN);
					editor.commit();
				}
				Intent screenChangeIntent = null;
				screenChangeIntent = new Intent(LoginActivity.this,
						ConditionsActivity.class);
				LoginActivity.this.startActivity(screenChangeIntent);
			}
		});
		
		CheckBox keepMeLoggedIn = (CheckBox) findViewById(R.id.checkbox_rememberme);
		keepMeLoggedIn
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						keepMeLoggedInBool = isChecked;
					}
				});

		// Action on click of Create An Account Button
		TextView textview_createaccount = (TextView) findViewById(R.id.textview_createaccount);
		textview_createaccount.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent screenChangeIntent = null;
				screenChangeIntent = new Intent(LoginActivity.this,
						SignupActivity.class);
				LoginActivity.this.startActivity(screenChangeIntent);
			}
		});
		
		// Action on click of Forgot Password Button
				TextView textview_forgotpwd = (TextView) findViewById(R.id.textview_forgotpwd);
				textview_forgotpwd.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View view) {
						Intent screenChangeIntent = null;
						screenChangeIntent = new Intent(LoginActivity.this,
								ForgotPwdActivity.class);
						LoginActivity.this.startActivity(screenChangeIntent);
					}
				});
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		View view = getCurrentFocus();
		boolean ret = super.dispatchTouchEvent(event);

		if (view instanceof EditText) {
			View w = getCurrentFocus();
			int scrcoords[] = new int[2];
			w.getLocationOnScreen(scrcoords);
			float x = event.getRawX() + w.getLeft() - scrcoords[0];
			float y = event.getRawY() + w.getTop() - scrcoords[1];

			if (event.getAction() == MotionEvent.ACTION_UP
					&& (x < w.getLeft() || x >= w.getRight() || y < w.getTop() || y > w
							.getBottom())) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(getWindow().getCurrentFocus()
						.getWindowToken(), 0);
			}
		}
		return ret;
	}

}